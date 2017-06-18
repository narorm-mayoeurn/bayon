package com.camhub.antiochschool.command.student;

import com.camhub.antiochschool.domain.Class;
import com.camhub.antiochschool.domain.Student;
import com.camhub.antiochschool.repository.SingletonRepositoryFactory;
import com.camhub.antiochschool.repository.StudentRepository;
import com.camhub.antiochschool.repository.StudentRepositoryImpl;
import com.camhub.antiochschool.service.ClassFacade;
import com.camhub.antiochschool.service.StudentFacade;
import org.bayon.form.validation.FormValidationType;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by darith on 6/14/17.
 */
public class StudentRegisterFormCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {

        request.setAttribute("classList", ClassFacade.getInstance().getAllClasses());

        // set action attribute
        if("student/register".equals(getCommandName())) {
            request.setAttribute("action", "register");
        } else if("student/update".equals(getCommandName())) {

            if(getValidator(FormValidationType.IS_NUMBER).validate(request.getParameter("id"), null)) {

                Long id = Long.valueOf(request.getParameter("id"));
                Student student = StudentFacade.getInstance().get(id);
                request.setAttribute("student", student);
                request.setAttribute("action", "update");
            } else {
                forward("404");
            }
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
