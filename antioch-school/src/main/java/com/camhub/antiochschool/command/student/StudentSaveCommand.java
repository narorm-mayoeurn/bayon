package com.camhub.antiochschool.command.student;

import com.camhub.antiochschool.domain.Student;
import com.camhub.antiochschool.service.StudentFacade;
import org.bayon.form.validation.*;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;




/**
 * Created by darith on 6/14/17.
 */
public class StudentSaveCommand extends FrontCommand {

    Map<String, String> errorMessages = new HashMap<>();

    @Override
    public void execute() throws ServletException, IOException {



        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("student_id"), null)) {
            errorMessages.put("student_id", "Student ID cannot be empty.");
        }

        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("khmer_name"), null)) {
            errorMessages.put("khmer_name", "Student Khmer name cannot be empty.");
        }

        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("english_name"), null)) {
            errorMessages.put("english_name", "Student English name is not correct.");
        }

        if(!getValidator(FormValidationType.IS_GENDER).validate(request.getParameter("gender"), null)) {
            errorMessages.put("gender", "Gender must be \"Male\" or \"Female\".");
        }


        String msgBirthdate = "";
        if(!getValidator(FormValidationType.IS_DATE).validate(request.getParameter("birthdate"), null)) {
            msgBirthdate = "Date of birth is not correct.";
        }

        FormCriteria crit = new FormCriteriaImp();
        crit.setIntFrom(0);
        crit.setIntTo(120);
        if(!getValidator(FormValidationType.IS_AGE).validate(request.getParameter("birthdate"), crit)) {
            if(!msgBirthdate.isEmpty()) msgBirthdate += "\n";
            msgBirthdate += "The age must be between 0 to 120.";
        }


        if(!msgBirthdate.isEmpty()) errorMessages.put("birthdate", msgBirthdate);



        if(errorMessages.isEmpty()) {
            Student student = new Student();

            student.setStudentId(request.getParameter("student_id"));
            student.setKhmerName(request.getParameter("khmer_name"));
            student.setEnglishName(request.getParameter("english_name"));
            student.setGender(request.getParameter("gender"));

            if(!getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("contact_phone"), null)) {
                student.setContactPhone(request.getParameter("contact_phone"));
            }
            if(!getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("contact_address"), null)) {
                student.setContactAddress(request.getParameter("contact_address"));
            }
            if(getValidator(FormValidationType.IS_NUMBER).validate(request.getParameter("class"), null)) {
                student.setClassId(Long.valueOf(request.getParameter("class")));
            }


            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date birthdate = null;
            try {
                birthdate = df.parse(request.getParameter("birthdate"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            student.setBirthDate(birthdate);


            if(getValidator(FormValidationType.IS_NUMBER).validate(request.getParameter("id"), null)) {

                student.setId(Long.valueOf(request.getParameter("id")));
                StudentFacade.getInstance().update(student);
            } else {

                StudentFacade.getInstance().create(student);
            }



        }

    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();

        if(errorMessages.isEmpty()) {
            Map<String, String> msg = new HashMap<>();
            msg.put("message", "Student information has been saved.");
            response.getWriter().write(objectMapper.writeValueAsString(msg));
        } else {
            response.setStatus(400);
            response.getWriter().write(objectMapper.writeValueAsString(errorMessages));
        }
    }
}
