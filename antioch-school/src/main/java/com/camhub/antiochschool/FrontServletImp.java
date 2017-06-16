package com.camhub.antiochschool;

import com.camhub.antiochschool.command.login.LoginFormCommand;
import com.camhub.antiochschool.command.student.StudentListCommand;
import com.camhub.antiochschool.command.student.StudentRegisterFormCommand;
import com.camhub.antiochschool.command.student.StudentSaveCommand;
import com.camhub.antiochschool.command.teacher.TeacherFormCommand;
import com.camhub.antiochschool.command.teacher.TeacherListCommand;
import com.camhub.antiochschool.command.teacher.TeacherSaveCommand;
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


        register("teacher/list", TeacherListCommand.class);
        register("teacher/add", TeacherFormCommand.class);
        register("teacher/update", TeacherFormCommand.class);
        register("teacher/save", TeacherSaveCommand.class);


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
