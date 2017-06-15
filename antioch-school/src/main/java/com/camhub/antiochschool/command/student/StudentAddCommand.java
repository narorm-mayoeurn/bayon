package com.camhub.antiochschool.command.student;

import com.camhub.antiochschool.domain.Student;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by darith on 6/15/17.
 */
public class StudentAddCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {

        Student student = new Student();
        student.setStudentId(request.getParameter("student_id"));
        student.setStudentId(request.getParameter("khmer_name"));
        student.setStudentId(request.getParameter("english_name"));
        student.setStudentId(request.getParameter("gender"));
        student.setStudentId(request.getParameter("birthdate"));
        student.setStudentId(request.getParameter("phone"));
        student.setStudentId(request.getParameter("email"));


        

    }
}
