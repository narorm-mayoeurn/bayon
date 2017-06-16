package com.camhub.antiochschool;

import com.camhub.antiochschool.command.login.LoginFormCommand;
import com.camhub.antiochschool.command.student.StudentListCommand;
import com.camhub.antiochschool.command.student.StudentRegisterFormCommand;
import com.camhub.antiochschool.command.student.StudentSaveCommand;
import com.camhub.antiochschool.command.teacher.TeacherFormCommand;
import com.camhub.antiochschool.command.teacher.TeacherListCommand;
import org.bayon.web.FrontServlet;

/**
 * Created by darith on 6/14/17.
 */
public class FrontServletImp extends FrontServlet {

    @Override
    public void registerCommandClass() {
        register(LoginFormCommand.class, "login");
        register(StudentListCommand.class, "", "home");


        register(StudentListCommand.class, "student/list");
        register(StudentRegisterFormCommand.class, "student/register");
        register(StudentRegisterFormCommand.class, "student/update");
        register(StudentSaveCommand.class, "student/save");


        register(TeacherListCommand.class, "teacher/list");
        register(TeacherFormCommand.class, "teacher/add");
        register(TeacherFormCommand.class, "teacher/update");


        register(TeacherListCommand.class, "classroom/list");
        register(TeacherFormCommand.class, "classroom/add");
        register(TeacherFormCommand.class, "classroom/update");


        register(TeacherFormCommand.class, "about");

    }



    @Override
    public String defaultTemplate() {
        return "adminlte";
    }


}
