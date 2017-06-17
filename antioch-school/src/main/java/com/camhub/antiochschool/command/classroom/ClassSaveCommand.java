package com.camhub.antiochschool.command.classroom;

import com.camhub.antiochschool.domain.Class;
import com.camhub.antiochschool.service.ClassFacade;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by nm on 6/16/2017.
 */
public class ClassSaveCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {

        Class clazz = new Class();

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

        if(id == null || id.isEmpty()){
            ClassFacade.getInstance().createClass(clazz);
        } else {
            clazz.setId(Long.valueOf(id));
            ClassFacade.getInstance().updateClass(clazz);
        }

    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();
    }
}
