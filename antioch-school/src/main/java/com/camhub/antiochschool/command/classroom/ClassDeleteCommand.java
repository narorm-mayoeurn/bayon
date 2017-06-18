package com.camhub.antiochschool.command.classroom;

import com.camhub.antiochschool.service.ClassFacade;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by nm on 17/6/17.
 */
public class ClassDeleteCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {
        String id = request.getParameter("id");

        if(id != null && !id.isEmpty()){
            ClassFacade.getInstance().delete(Long.valueOf(id));
        }
    }
}
