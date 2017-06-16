package com.camhub.antiochschool.command.teacher;

import com.camhub.antiochschool.domain.Teacher;
import com.camhub.antiochschool.repository.SingletonRepositoryFactory;
import com.camhub.antiochschool.repository.TeacherRepository;
import com.camhub.antiochschool.repository.TeacherRepositoryImpl;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public class TeacherSaveCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {

        Teacher teacher = new Teacher();

        teacher.setKhmerName(request.getParameter("kh_name"));
        teacher.setEnglishName(request.getParameter("en_name"));
        teacher.setGender(request.getParameter("gender"));

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date birthdate = null;

        try {
            birthdate = df.parse(request.getParameter("birthdate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        teacher.setBirthdate(birthdate);
        teacher.setPhone(request.getParameter("phone"));
        teacher.setEmail(request.getParameter("email"));

        TeacherRepository teacherRep = SingletonRepositoryFactory.getFactory().getTeacherRepository();
        teacherRep.create(teacher);
    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();
    }
}
