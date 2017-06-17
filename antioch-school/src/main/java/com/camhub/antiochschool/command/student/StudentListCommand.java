package com.camhub.antiochschool.command.student;

import com.camhub.antiochschool.service.StudentFacade;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by darith on 6/14/17.
 */
public class StudentListCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {
        StudentFacade facade = StudentFacade.getInstance();

        int offset = getIntParam("offset", 0);
        int limit = getIntParam("limit", 10);

        request.setAttribute("students", facade.getStudents(offset, limit));
    }

    @Override
    protected void responseAsHtml() throws ServletException, IOException {
        super.responseAsHtml();
        forward("student-list");
    }
}
