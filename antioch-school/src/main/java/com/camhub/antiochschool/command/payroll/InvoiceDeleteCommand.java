package com.camhub.antiochschool.command.payroll;

import com.camhub.antiochschool.service.StudentFacade;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Chandara Leang on 6/17/2017.
 */
public class InvoiceDeleteCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {
        String id = request.getParameter("id");

        if(id != null && !id.isEmpty()){

            StudentFacade.getInstance().deletePayroll(Long.valueOf(id));

        }
    }
}
