package com.camhub.antiochschool.command.teacher;

import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by darith on 6/14/17.
 */
public class TeacherFormCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {

        // set action attribute
        if("student/add".equals(getCommandName())) {
            request.setAttribute("action", "add");
        } else if("student/update".equals(getCommandName())) {
            request.setAttribute("action", "update");
        } else request.setAttribute("action", "");



        forward("student-register-form");

    }
}
