package com.camhub.antiochschool;

import com.camhub.antiochschool.command.classroom.ClassDeleteCommand;
import com.camhub.antiochschool.command.classroom.ClassFormCommand;
import com.camhub.antiochschool.command.classroom.ClassListCommand;
import com.camhub.antiochschool.command.classroom.ClassSaveCommand;
import com.camhub.antiochschool.command.login.LoginFormCommand;
import com.camhub.antiochschool.command.payroll.*;
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
        register(StudentRegisterFormCommand.class, "student/register", "student/update");
        register(StudentDeleteCommand.class, "student/delete");

        register(StudentSaveCommand.class, "student/save");

        register(TeacherListCommand.class, "teacher/list");
        register(TeacherDeleteCommand.class, "teacher/delete");
        register(TeacherFormCommand.class, "teacher/add");
        register(TeacherFormCommand.class, "teacher/updateInvoice");
        register(TeacherSaveCommand.class, "teacher/save");

        register(InvoiceListCommand.class, "invoice/list");
        register(InvoiceDeleteCommand.class, "invoice/delete");
        register(InvoiceFormCommand.class, "invoice/add");
        register(InvoiceSaveCommand.class, "invoice/save");
        register(InvoicePrintCommand.class, "invoice/print");

        register(TeacherFormCommand.class, "about");
        register(ClassListCommand.class, "classes");
        register(ClassFormCommand.class, "classes/add", "classes/update");
        register(ClassSaveCommand.class, "classes/save");
        register(ClassDeleteCommand.class, "classes/delete");
    }



    @Override
    public String defaultTemplate() {
        return "adminlte";
    }


}
