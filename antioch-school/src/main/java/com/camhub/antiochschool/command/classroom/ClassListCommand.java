package com.camhub.antiochschool.command.classroom;

import com.camhub.antiochschool.service.ClassFacade;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by darith on 6/14/17.
 */
public class ClassListCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {

        int offset = getIntParam("offset", 0);
        int limit = getIntParam("limit", 10);

        request.setAttribute("classes", ClassFacade.getInstance().getClasses(offset, limit));
        request.setAttribute("programs", ClassFacade.getInstance().getPrograms());
        request.setAttribute("teachers", ClassFacade.getInstance().getTeachers());
    }

    @Override
    protected void responseAsHtml() throws ServletException, IOException {
        super.responseAsHtml();
        forward("classroom-list");
    }
}
