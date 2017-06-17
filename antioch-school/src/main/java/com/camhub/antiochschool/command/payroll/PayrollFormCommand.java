package com.camhub.antiochschool.command.payroll;

import com.camhub.antiochschool.domain.Payroll;
import com.camhub.antiochschool.repository.PayrollRepository;
import com.camhub.antiochschool.repository.SingletonRepositoryFactory;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public class PayrollFormCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {

        // set action attribute
        if("payroll/add".equals(getCommandName())) {
            request.setAttribute("action", "add");
        } else if("payroll/add".equals(getCommandName())) {

            Long id = Long.valueOf(request.getParameter("id"));

            PayrollRepository studentRep = SingletonRepositoryFactory.getFactory().getPayrollRepository();

            request.setAttribute("action", "update");
        } else request.setAttribute("action", "");

    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();

    }

    @Override
    protected void responseAsHtml() throws ServletException, IOException {
        super.responseAsHtml();
        forward("payroll-form");
    }
}
