package com.camhub.antiochschool.command.classroom;

import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by darith on 6/14/17.
 */
public class ClassroomFormCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {

        // set action attribute
        if("classroom/add".equals(getCommandName())) {
            request.setAttribute("action", "add");
        } else if("student/update".equals(getCommandName())) {
            request.setAttribute("action", "update");
        } else request.setAttribute("action", "");



        forward("classroom-form");

    }
}
