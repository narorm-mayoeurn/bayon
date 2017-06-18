package org.bayon.web;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.bayon.form.validation.FormValidationFactoryImp;
import org.bayon.form.validation.FormValidationImp;
import org.bayon.form.validation.FormValidation;
import org.bayon.form.validation.FormValidationType;

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


    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    protected ObjectMapper objectMapper;


    public abstract void execute() throws ServletException, IOException;


    public final void init(String commandName, ServletContext context, HttpServletRequest req, HttpServletResponse resp) {
        this.commandName = commandName;
        this.context = context;
        this.request = req;
        this.response = resp;

        objectMapper = new ObjectMapper();

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

    protected final FormValidation getValidator(FormValidationType type) {
        return FormValidationFactoryImp.getInstance().getValidator(type);
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









}
