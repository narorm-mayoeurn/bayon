package com.camhub.antiochschool;

import com.camhub.antiochschool.command.classroom.ClassDeleteCommand;
import com.camhub.antiochschool.command.classroom.ClassFormCommand;
import com.camhub.antiochschool.command.classroom.ClassListCommand;
import com.camhub.antiochschool.command.classroom.ClassSaveCommand;
import com.camhub.antiochschool.command.login.LoginFormCommand;
import com.camhub.antiochschool.command.payroll.PayrollDeleteCommand;
import com.camhub.antiochschool.command.payroll.PayrollFormCommand;
import com.camhub.antiochschool.command.payroll.PayrollListCommand;
import com.camhub.antiochschool.command.payroll.PayrollSaveCommand;
import com.camhub.antiochschool.command.student.StudentDeleteCommand;
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
        register(StudentDeleteCommand.class, "student/delete");
        register(StudentRegisterFormCommand.class, "student/updateInvoice");
        register(StudentSaveCommand.class, "student/save");

        register(TeacherListCommand.class, "teacher/list");
        register(TeacherDeleteCommand.class, "teacher/delete");
        register(TeacherFormCommand.class, "teacher/add");
        register(TeacherFormCommand.class, "teacher/updateInvoice");
        register(TeacherSaveCommand.class, "teacher/save");

        register(PayrollListCommand.class, "payroll/list");
        register(PayrollDeleteCommand.class, "payroll/delete");
        register(PayrollFormCommand.class, "payroll/add");
        register(PayrollFormCommand.class, "payroll/updateInvoice");
        register(PayrollSaveCommand.class, "payroll/save");

        register(TeacherFormCommand.class, "about");
        register(ClassListCommand.class, "classes");
        register(ClassFormCommand.class, "classes/add", "classes/updateInvoice");
        register(ClassSaveCommand.class, "classes/save");
        register(ClassDeleteCommand.class, "classes/delete");
    }



    @Override
    public String defaultTemplate() {
        return "adminlte";
    }


}
