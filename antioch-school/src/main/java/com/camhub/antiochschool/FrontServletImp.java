package com.camhub.antiochschool;

import com.camhub.antiochschool.command.login.LoginFormCommand;
import com.camhub.antiochschool.command.payroll.PayrollFormCommand;
import com.camhub.antiochschool.command.payroll.PayrollListCommand;
import com.camhub.antiochschool.command.payroll.PayrollSaveCommand;
import com.camhub.antiochschool.command.student.StudentListCommand;
import com.camhub.antiochschool.command.student.StudentRegisterFormCommand;
import com.camhub.antiochschool.command.student.StudentSaveCommand;
import com.camhub.antiochschool.command.teacher.*;
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
        register(TeacherDeleteCommand.class, "teacher/delete");
        register(TeacherFormCommand.class, "teacher/add");
        register(TeacherFormCommand.class, "teacher/update");
        register(TeacherSaveCommand.class, "teacher/save");

        register(PayrollListCommand.class, "payroll/list");
        register(PayrollFormCommand.class, "payroll/add");
        register(PayrollFormCommand.class, "payroll/update");
        register(PayrollSaveCommand.class, "payroll/save");

        register(TeacherFormCommand.class, "about");

    }



    @Override
    public String defaultTemplate() {
        return "adminlte";
    }


}
