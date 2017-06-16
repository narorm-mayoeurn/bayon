package com.camhub.antiochschool.command.student;

import com.camhub.antiochschool.domain.Student;
import com.camhub.antiochschool.repository.StudentRepository;
import com.camhub.antiochschool.repository.StudentRepositoryImpl;
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

    Map<String, String> errorMessages = new HashMap<>();

    @Override
    public void execute() throws ServletException, IOException {

        Student student = new Student();


<<<<<<< HEAD
        if(RequestValidationType.IS_EMPTY != validationContext.execute(request, "student_id")) {
            errorMessages.put("student_id", "Student ID cannot be empty.");
        }

        if(RequestValidationType.IS_EMPTY != validationContext.execute(request, "khmer_name")) {
            errorMessages.put("khmer_name", "Student Khmer name cannot be empty.");
        }
=======
        student.setStudentId(request.getParameter("student_id"));
        student.setKhmerName(request.getParameter("khmer_name"));
        student.setEnglishName(request.getParameter("english_name"));
>>>>>>> aff988b15b676f36c5830ce566b1a68f533377f9

        if(RequestValidationType.IS_NAME != validationContext.execute(request, "english_name")) {
            errorMessages.put("english_name", "Student English name is not correct.");
        }

        if(RequestValidationType.IS_GENDER != validationContext.execute(request, "gender")) {
            errorMessages.put("gender", "Gender must be \"Male\" or \"Female\".");
        }

        if(RequestValidationType.IS_DATE != validationContext.execute(request, "birthdate")) {
            errorMessages.put("birthdate", "Date of birth is not correct.");
        }

        if(RequestValidationType.IS_DATE != validationContext.execute(request, "birthdate")) {
            errorMessages.put("birthdate", "The age must be between 0 to 120.");
        }


<<<<<<< HEAD

        if(!errorMessages.isEmpty()) {

            student.setStudentId(request.getParameter("student_id"));
            student.setKhmerName(request.getParameter("khmer_name"));
            student.setEnglishName(request.getParameter("english_name"));
            student.setGender(request.getParameter("gender"));



            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date birthdate = null;
            try {
                birthdate = df.parse(request.getParameter("birthdate"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            student.setBirthDate(birthdate);


            Date now = new Date();
            student.setAddedDate(now);
            student.setModifiedDate(now);

            StudentRepository studentRep = new StudentRepositoryImpl();

            if(request.getParameter("id") != null) {
                if(RequestValidationType.IS_NUMBER != validationContext.execute(request, "id")) {
                    student.setId(Long.valueOf(request.getParameter("id")));
                    studentRep.update(student);
                } else {

                    studentRep.create(student);
                }
            }


        }
=======
        StudentRepository studentRep = new StudentRepositoryImpl();
        studentRep.create(student);
>>>>>>> aff988b15b676f36c5830ce566b1a68f533377f9
    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();

        String json = "";

        if(errorMessages.isEmpty()) {
            json = new ObjectMapper().writeValueAsString(new HashMap().put("message", "Student information has been saved."));
        } else {
            json = new ObjectMapper().writeValueAsString(errorMessages);
        }

        response.getWriter().write(json);
    }





}
