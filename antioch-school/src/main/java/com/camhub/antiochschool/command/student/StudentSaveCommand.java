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
public class StudentSaveCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {

        Student student = new Student();


        student.setStudentId(request.getParameter("student_id"));
        student.setKhmerName(request.getParameter("khmer_name"));
        student.setEnglishName(request.getParameter("english_name"));
        student.setGender(request.getParameter("gender"));
        student.setGender(request.getParameter("phone"));
        student.setGender(request.getParameter("email"));

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
        studentRep.create(student);
    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();
    }





}
