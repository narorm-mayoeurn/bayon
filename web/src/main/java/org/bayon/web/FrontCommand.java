package org.bayon.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by darith on 6/13/17.
 */
public abstract class FrontCommand {


    private String template;
    private String commandName;

    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;


    public abstract void execute() throws ServletException, IOException;


    public void init(String commandName, ServletContext context, HttpServletRequest req, HttpServletResponse resp) {
        this.context = context;
        this.request = req;
        this.response = resp;


    }

    public void setTemplate(String template) {
        this.template = template;
    }

    protected void forward(String target) throws ServletException, IOException {
        request.setAttribute("page", target);
        target = String.format("/template/%s/index.jsp", template);
        RequestDispatcher dispatcher = context.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }

    public String getCommandName() {
        return commandName;
    }

}
