package com.camhub.antiochschool;

import com.camhub.antiochschool.command.HomeCommand;
import com.camhub.antiochschool.command.login.LoginFormCommand;
import com.camhub.antiochschool.command.student.StudentListCommand;
import com.camhub.antiochschool.command.student.StudentRegisterFormCommand;
import com.camhub.antiochschool.command.teacher.TeacherFormCommand;
import com.camhub.antiochschool.command.teacher.TeacherListCommand;
import org.bayon.web.FrontServlet;

/**
 * Created by darith on 6/14/17.
 */
public class FrontServletImp extends FrontServlet {

    @Override
    public void registerCommandClass() {
        register("login", LoginFormCommand.class);
        register("home", StudentListCommand.class);

        register("student/list", StudentListCommand.class);
        register("student/register", StudentRegisterFormCommand.class);
        register("student/update", StudentRegisterFormCommand.class);


        register("teacher/list", TeacherListCommand.class);
        register("teacher/add", TeacherFormCommand.class);
        register("teacher/update", TeacherFormCommand.class);


        register("classroom/list", TeacherListCommand.class);
        register("classroom/add", TeacherFormCommand.class);
        register("classroom/update", TeacherFormCommand.class);


        register("about", TeacherFormCommand.class);

    }



    @Override
    public String defaultTemplate() {
        return "adminlte";
    }


}
