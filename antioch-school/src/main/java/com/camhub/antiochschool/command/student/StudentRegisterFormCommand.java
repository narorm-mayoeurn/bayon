package com.camhub.antiochschool.command.student;

import com.camhub.antiochschool.domain.Student;
import com.camhub.antiochschool.repository.StudentRepository;
import com.camhub.antiochschool.repository.StudentRepositoryImpl;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

            Long id = Long.valueOf(request.getParameter("id"));

            StudentRepository studentRep = new StudentRepositoryImpl();

            request.setAttribute("action", "update");
        } else request.setAttribute("action", "");

    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();

    }

    @Override
    protected void responseAsHtml() throws ServletException, IOException {
        super.responseAsHtml();
        forward("student-register-form");
    }

    private void validate() {

    }


}
