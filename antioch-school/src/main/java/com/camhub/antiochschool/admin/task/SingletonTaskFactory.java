package com.camhub.antiochschool.admin.task;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nm on 17/6/17.
 */
public final class SingletonTaskFactory implements TaskFactory {

    private static final SingletonTaskFactory INSTANCE = new SingletonTaskFactory();

    private Map<String, Task> tasks;

    private SingletonTaskFactory() {
        tasks = new HashMap<>();
        tasks.put("populatePrograms", new PopulateProgramsTask());
        tasks.put("createAdminUser", new CreateAdminUserTask());
    }

    public static SingletonTaskFactory getInstance() {
        return INSTANCE;
    }

    public Task getTask(String name) {
        return tasks.get(name);
    }
}
