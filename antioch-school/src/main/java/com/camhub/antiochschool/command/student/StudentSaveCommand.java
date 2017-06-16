package com.camhub.antiochschool.command.student;

import com.camhub.antiochschool.domain.Student;
import com.camhub.antiochschool.helper.Pair;
import com.camhub.antiochschool.service.StudentFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bayon.form.validation.RequestValidationType;
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

    List<Pair<String, String>> errorMessages = new ArrayList<>();

    @Override
    public void execute() throws ServletException, IOException {

        Student student = new Student();



        if(RequestValidationType.IS_EMPTY != validationContext.execute(request, "student_id")) {
            errorMessages.add(new Pair<>("student_id", "Student ID cannot be empty."));
        }

        if(RequestValidationType.IS_EMPTY != validationContext.execute(request, "khmer_name")) {
            errorMessages.add(new Pair<>("khmer_name", "Student Khmer name cannot be empty."));
        }

        if(RequestValidationType.IS_NAME != validationContext.execute(request, "english_name")) {
            errorMessages.add(new Pair<>("english_name", "Student English name is not correct."));
        }

        if(RequestValidationType.IS_GENDER != validationContext.execute(request, "gender")) {
            errorMessages.add(new Pair<>("gender", "Gender must be \"Male\" or \"Female\"."));
        }

        if(RequestValidationType.IS_DATE != validationContext.execute(request, "birthdate")) {
            errorMessages.add(new Pair<>("birthdate", "Date of birth is not correct."));
        }

        if(RequestValidationType.IS_DATE != validationContext.execute(request, "birthdate")) {
            errorMessages.add(new Pair<>("birthdate", "The age must be between 0 to 120."));
        }




        if(!errorMessages.isEmpty()) {

            student.setStudentId(request.getParameter("student_id"));
            student.setKhmerName(request.getParameter("khmer_name"));
            student.setEnglishName(request.getParameter("english_name"));
            student.setGender(request.getParameter("gender").charAt(0));



            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date birthdate = null;
            try {
                birthdate = df.parse(request.getParameter("birthdate"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            student.setBirthDate(birthdate);


            if(request.getParameter("id") != null) {
                if(RequestValidationType.IS_NUMBER != validationContext.execute(request, "id")) {
                    student.setId(Long.valueOf(request.getParameter("id")));

                    StudentFacade.getInstance().update(student);
                } else {
                    StudentFacade.getInstance().create(student);
                }
            }


        }

    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();

        String json = "";

        if(errorMessages.isEmpty()) {
            json = new ObjectMapper().writeValueAsString(new Pair<>("message", "Student information has been saved."));
        } else {
            response.setStatus(400);
            json = new ObjectMapper().writeValueAsString(errorMessages);
        }

        response.getWriter().write(json);
    }





}
