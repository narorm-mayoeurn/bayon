package com.camhub.antiochschool.command.payroll;

import com.camhub.antiochschool.service.StudentFacade;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public class PayrollListCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {
        StudentFacade facade = StudentFacade.getInstance();

        int offset = getIntParam("offset", 0);
        int limit = getIntParam("limit", 10);

        request.setAttribute("payrolls", facade.getPayrolls(offset, limit));
    }

    @Override
    protected void responseAsHtml() throws ServletException, IOException {
        super.responseAsHtml();
        forward("payroll-list");
    }

    int getIntParam(String name, int _default) {
        String param = request.getParameter(name);
        if (param == null) {
            return _default;
        }
        return Integer.parseInt(param);
    }
}
