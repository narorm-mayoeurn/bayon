package com.camhub.antiochschool.command.teacher;

import com.camhub.antiochschool.domain.Teacher;
import com.camhub.antiochschool.service.TeacherFacade;
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
        if("teacher/add".equals(getCommandName())) {
            request.setAttribute("action", "add");
        } else if("teacher/update".equals(getCommandName())) {
            request.setAttribute("action", "update");

            Long id = Long.valueOf(request.getParameter("id"));
            Teacher teacher = TeacherFacade.getInstance().get(id);
            request.setAttribute("teacher", teacher);
        } else request.setAttribute("action", "");


    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();
    }

    @Override
    protected void responseAsHtml() throws ServletException, IOException {
        super.responseAsHtml();

        forward("teacher-form");
    }
}
