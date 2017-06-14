package org.bayon.web;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by darith on 6/13/17.
 */
public abstract class FrontCommand {


    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;


    public abstract void execute();



    public FrontCommand getCommand(String name) {
        try {
            return (FrontCommand) CommandClassMapper.getInstance().getCommandClass(name).asSubclass(FrontCommand.class).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return new UnknownCommand();
    }




}
