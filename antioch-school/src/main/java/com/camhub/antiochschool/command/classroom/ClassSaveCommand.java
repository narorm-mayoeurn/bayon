package com.camhub.antiochschool.command.classroom;

import com.camhub.antiochschool.domain.Class;
import com.camhub.antiochschool.service.ClassFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bayon.form.validation.FormValidationType;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nm on 6/16/2017.
 */
public class ClassSaveCommand extends FrontCommand {

    Map<String, String> errorMessages = new HashMap<>();

    @Override
    public void execute() throws ServletException, IOException {

        Class clazz = new Class();

        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("name"), null)) {
            errorMessages.put("name", "Class cannot be empty.");
        }

        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("session"), null)) {
            errorMessages.put("session", "Session cannot be empty.");
        }

        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("programId"), null)) {
            errorMessages.put("programId", "Program cannot be empty.");
        }

        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("teacherId"), null)) {
            errorMessages.put("teacherId", "Teacher cannot be empty.");
        }

        if(errorMessages.isEmpty()) {
            clazz.setName(request.getParameter("name"));
            clazz.setSession(request.getParameter("session"));
            clazz.setDescription(request.getParameter("description"));

            try {
                clazz.setProgramId(Long.valueOf(request.getParameter("programId")));
                clazz.setTeacherId(Long.valueOf(request.getParameter("teacherId")));
            } catch (Exception e) {
                e.printStackTrace();
            }

            String id = request.getParameter("id");

            if (id == null || id.isEmpty()) {
                ClassFacade.getInstance().createClass(clazz);
            } else {
                clazz.setId(Long.valueOf(id));
                ClassFacade.getInstance().updateClass(clazz);
            }
        }
    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();

        if(errorMessages.isEmpty()) {
            Map<String, String> msg = new HashMap<>();
            msg.put("message", "Class information has been saved.");
            response.getWriter().write(objectMapper.writeValueAsString(msg));
        } else {
            response.setStatus(400);
            response.getWriter().write(objectMapper.writeValueAsString(errorMessages));
        }
    }
}
