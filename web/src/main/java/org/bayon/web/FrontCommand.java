package org.bayon.web;



import org.bayon.form.validation.HttpServletRequestValidationImp;
import org.bayon.form.validation.HttpServletRequestValidation;
import org.bayon.form.validation.RequestValidationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
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

    protected RequestValidationContext validationContext;
    protected Set<HttpServletRequestValidation> strategies;

    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;


    public abstract void execute() throws ServletException, IOException;


    public final void init(String commandName, ServletContext context, HttpServletRequest req, HttpServletResponse resp) {
        this.context = context;
        this.request = req;
        this.response = resp;

        registerValidationRules();
        validationContext = new RequestValidationContext(strategies);

    }

    public void setTemplate(String template) {
        this.template = template;
    }

    protected final void forward(String target) throws ServletException, IOException {
        request.setAttribute("page", target);
        target = String.format("/template/%s/index.jsp", template);
        RequestDispatcher dispatcher = context.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }


    protected void responseAsJson() throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");
    }

    protected void responseAsHtml() throws ServletException, IOException {
        response.setHeader("Content-Type", "text/html");
    }

    public final String getCommandName() {
        return commandName;
    }




    protected void registerValidationRules() {
        strategies = new LinkedHashSet<>();

        strategies.add(HttpServletRequestValidationImp.IS_EMPTY);
        strategies.add(HttpServletRequestValidationImp.IS_AGE);
        strategies.add(HttpServletRequestValidationImp.IS_DATE);
        strategies.add(HttpServletRequestValidationImp.IS_EMAIL);
        strategies.add(HttpServletRequestValidationImp.IS_GENDER);
        strategies.add(HttpServletRequestValidationImp.IS_PHONE);
        strategies.add(HttpServletRequestValidationImp.IS_PASSWORD);

    }
}
