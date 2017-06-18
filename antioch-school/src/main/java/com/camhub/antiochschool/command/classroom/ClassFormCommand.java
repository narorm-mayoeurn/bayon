package com.camhub.antiochschool.command.classroom;

import com.camhub.antiochschool.domain.Class;
import com.camhub.antiochschool.domain.Teacher;
import com.camhub.antiochschool.service.ClassFacade;
import com.camhub.antiochschool.service.TeacherFacade;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by darith on 6/14/17.
 */
public class ClassFormCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {

        // set action attribute
        if("classes/add".equals(getCommandName())) {
            request.setAttribute("action", "add");
        } else if("classes/updateInvoice".equals(getCommandName())) {
            request.setAttribute("action", "updateInvoice");

            Long id = Long.valueOf(request.getParameter("id"));
            Class clazz = ClassFacade.getInstance().get(id);
            request.setAttribute("clazz", clazz);

        } else request.setAttribute("action", "");

        request.setAttribute("programs", ClassFacade.getInstance().getPrograms());
        request.setAttribute("teachers", ClassFacade.getInstance().getTeachers());
    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();

    }

    @Override
    protected void responseAsHtml() throws ServletException, IOException {
        super.responseAsHtml();
        forward("classroom-form");
    }
}
