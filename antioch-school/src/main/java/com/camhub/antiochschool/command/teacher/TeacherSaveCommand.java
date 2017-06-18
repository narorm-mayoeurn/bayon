package com.camhub.antiochschool.command.teacher;

import com.camhub.antiochschool.domain.Teacher;
import com.camhub.antiochschool.helper.Pair;
import com.camhub.antiochschool.repository.SingletonRepositoryFactory;
import com.camhub.antiochschool.repository.TeacherRepository;
import com.camhub.antiochschool.repository.TeacherRepositoryImpl;
import com.camhub.antiochschool.service.TeacherFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bayon.form.validation.FormCriteria;
import org.bayon.form.validation.FormCriteriaImp;
import org.bayon.form.validation.FormValidationType;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public class TeacherSaveCommand extends FrontCommand {

    Map<String, String> errorMessages = new HashMap<>();

    @Override
    public void execute() throws ServletException, IOException {

        Teacher teacher = new Teacher();

        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("kh_name"), null)) {
            errorMessages.put("kh_name", "Khmer Name cannot be empty.");
        }

        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("en_name"), null)) {
            errorMessages.put("en_name", "English Name cannot be empty.");
        }

        if(!getValidator(FormValidationType.IS_GENDER).validate(request.getParameter("gender"), null)) {
            errorMessages.put("gender", "Gender must be \"Male\" or \"Female\".");
        }

        String msgBirthdate = "";
        if(!getValidator(FormValidationType.IS_DATE).validate(request.getParameter("birthdate"), null)) {
            msgBirthdate = "Date of birth is not correct.";
        }

        FormCriteria crit = new FormCriteriaImp();
        crit.setIntFrom(0);
        crit.setIntTo(120);
        if(!getValidator(FormValidationType.IS_AGE).validate(request.getParameter("birthdate"), crit)) {
            if(!msgBirthdate.isEmpty()) msgBirthdate += "\n";
            msgBirthdate += "The age must be between 0 to 120.";
        }


        if(!msgBirthdate.isEmpty()) errorMessages.put("birthdate", msgBirthdate);

        if(!getValidator(FormValidationType.IS_PHONE).validate(request.getParameter("phone"), null)) {
            errorMessages.put("phone", "Phone Number is not correct.");
        }

        if(!getValidator(FormValidationType.IS_EMAIL).validate(request.getParameter("email"), null)) {
            errorMessages.put("email", "Email is not correct.");
        }

        if(errorMessages.isEmpty()) {
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

            String id = request.getParameter("id");

            if (id == null || id.isEmpty()) {
                TeacherFacade.getInstance().create(teacher);
            } else {
                teacher.setId(Long.valueOf(id));
                TeacherFacade.getInstance().update(teacher);
            }
        }
    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();

        String json = "";

        if(errorMessages.isEmpty()) {
            System.out.println("yes");
            Map<String, String> msg = new HashMap<>();
            msg.put("message", "Teacher information has been saved.");
            json = objectMapper.writeValueAsString(msg);
        } else {
            response.setStatus(400);
            json = new ObjectMapper().writeValueAsString(errorMessages);
        }

        response.getWriter().write(json);
    }
}
