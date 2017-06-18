package com.camhub.antiochschool.command.student;

import com.camhub.antiochschool.service.StudentFacade;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Chandara Leang on 6/17/2017.
 */
public class StudentDeleteCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {
        String id = request.getParameter("id");

        if(id != null && !id.isEmpty()){
            StudentFacade.getInstance().delete(Long.valueOf(id));
        }
    }
}
