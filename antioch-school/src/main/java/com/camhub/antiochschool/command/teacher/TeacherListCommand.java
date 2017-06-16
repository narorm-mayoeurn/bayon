package com.camhub.antiochschool.command.teacher;

import com.camhub.antiochschool.service.TeacherFacade;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by darith on 6/14/17.
 */
public class TeacherListCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {
        TeacherFacade facade = TeacherFacade.getInstance();

        int offset = getIntParam("offset", 0);
        int limit = getIntParam("limit", 10);

        request.setAttribute("teachers", facade.getTeachers(offset, limit));
    }

    @Override
    protected void responseAsHtml() throws ServletException, IOException {
        super.responseAsHtml();
        forward("teacher-list");
    }

    int getIntParam(String name, int _default) {
        String param = request.getParameter(name);
        if (param == null) {
            return _default;
        }
        return Integer.parseInt(param);
    }
}
