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
import com.camhub.antiochschool.domain.Program;
import com.camhub.antiochschool.domain.Student;
import com.camhub.antiochschool.domain.Teacher;
import com.camhub.antiochschool.domain.Class;
import com.camhub.antiochschool.service.ClassFacade;
import com.camhub.antiochschool.service.TeacherFacade;
import org.bayon.web.FrontServlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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

        register(PayrollListCommand.class, "payroll/list");
        register(PayrollDeleteCommand.class, "payroll/delete");
        register(PayrollFormCommand.class, "payroll/add");
        register(PayrollFormCommand.class, "payroll/updateInvoice");
        register(PayrollSaveCommand.class, "payroll/save");

        register(TeacherFormCommand.class, "about");
        register(ClassListCommand.class, "classes");
        register(ClassFormCommand.class, "classes/add", "classes/update");
        register(ClassSaveCommand.class, "classes/save");
        register(ClassDeleteCommand.class, "classes/delete");

        // default value
//        Teacher t = new Teacher();
//        t.setKhmerName("Sok Samol");
//        t.setEnglishName("Sok Samol");
//        t.setGender("M");
//        try {
//            t.setBirthdate(new SimpleDateFormat("MM/dd/yyyy").parse("11/11/1990"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        t.setPhone("012994455");
//        t.setEmail("sok.samol@gmail.com");
//
//        Long teacherId = TeacherFacade.getInstance().create(t);
//
//        // program
//        Program p = new Program();
//        p.setName("(GEPP) General English Program Part-Time");
//        Long programId = ClassFacade.getInstance().createProgram(p);
//
//
//        Class c = new Class();
//        c.setName("12E");
//        c.setTeacherId(teacherId);
//        c.setProgramId(programId);
//        c.setSession("Morning");
//        c.setDescription("Just for testing");
//        Long classId = ClassFacade.getInstance().createClass(c);
//
//        Student s = new Student();
//        s.setKhmerName("Sok San");
//        s.setEnglishName("Sok San");
//
    }



    @Override
    public String defaultTemplate() {
        return "adminlte";
    }


}
