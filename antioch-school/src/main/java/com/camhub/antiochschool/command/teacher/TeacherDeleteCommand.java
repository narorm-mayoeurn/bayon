package com.camhub.antiochschool.command.teacher;

import com.camhub.antiochschool.service.TeacherFacade;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public class TeacherDeleteCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {
        String id = request.getParameter("id");

        if(id != null && !id.isEmpty()){
            TeacherFacade.getInstance().delete(Long.valueOf(id));
        }
    }
}
