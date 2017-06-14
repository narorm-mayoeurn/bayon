package org.bayon.web;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by darith on 6/13/17.
 */
public class CommandClassMapper {

    private static CommandClassMapper instance = new CommandClassMapper();
    private Map<String, Class<? extends FrontCommand>> commands = new HashMap<>();

    private CommandClassMapper() {}

    public static CommandClassMapper getInstance() {
        return instance;
    }

    public void register(String name, Class<? extends FrontCommand> cls) {
        commands.put(name, cls);
    }

    public Class<? extends FrontCommand> getCommandClass(String key) {
        return commands.containsKey(key) ? commands.get(key) : UnknownCommand.class;
    }

}
