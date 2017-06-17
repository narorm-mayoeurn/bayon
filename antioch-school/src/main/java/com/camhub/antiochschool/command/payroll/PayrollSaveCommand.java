package com.camhub.antiochschool.command.payroll;

import com.camhub.antiochschool.domain.Payroll;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public class PayrollSaveCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {

        Payroll payroll = new Payroll();

//        payroll.setKhmerName(request.getParameter("kh_name"));
//        payroll.setEnglishName(request.getParameter("en_name"));
//        payroll.setGender(request.getParameter("gender"));
//
//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//        Date birthdate = null;
//
//        try {
//            birthdate = df.parse(request.getParameter("birthdate"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        teacher.setBirthdate(birthdate);
//        teacher.setPhone(request.getParameter("phone"));
//        teacher.setEmail(request.getParameter("email"));
//
//        TeacherRepository teacherRep = SingletonRepositoryFactory.getFactory().getTeacherRepository();
//        teacherRep.create(teacher);
    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();
    }
}
