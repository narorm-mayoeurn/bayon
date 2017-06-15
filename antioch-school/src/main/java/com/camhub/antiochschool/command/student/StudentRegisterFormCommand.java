package com.camhub.antiochschool.command.student;

import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by darith on 6/14/17.
 */
public class StudentRegisterFormCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {

        // set action attribute
        if("student/register".equals(getCommandName())) {
            request.setAttribute("action", "register");
        } else if("student/update".equals(getCommandName())) {
            request.setAttribute("action", "update");
        } else request.setAttribute("action", "");

    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();

        response.getWriter().print("Hello !!!!!!");
    }

    @Override
    protected void responseAsHtml() throws ServletException, IOException {
        super.responseAsHtml();
        forward("student-register-form");
    }
}
