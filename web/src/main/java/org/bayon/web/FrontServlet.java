package org.bayon.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by darith on 6/13/17.
 */
public abstract class FrontServlet extends HttpServlet {

    private String template;
    private FrontCommand frontCommand;
    private CommandClassMapper cmdClassMapper = CommandClassMapper.getInstance();


    public void init() throws ServletException {
        registerCommandClass();
        template = defaultTemplate();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        frontCommand = getCommand(req);
        frontCommand.init(getCommandName(req), getServletContext(), req, resp);
        frontCommand.setTemplate(template);
        frontCommand.execute();



        if(req.getParameter("_a") != null) {
                frontCommand.responseAsJson();
        }

        else {
            frontCommand.responseAsHtml();
        }


    }



    private FrontCommand getCommand(HttpServletRequest req) {
        try {
            String name = getCommandName(req);
            return CommandClassMapper.getInstance().getCommandClass(name).asSubclass(FrontCommand.class).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return new UnknownCommand();
    }



    public String getCommandName(HttpServletRequest req) {
        return req.getRequestURI().substring(1);
    }
    public void register(Class<? extends FrontCommand> cls, String... uri) {
        for(String n : uri) {
            cmdClassMapper.register(n, cls);
        }
    }





    public abstract void registerCommandClass();
    public abstract String defaultTemplate();



}
