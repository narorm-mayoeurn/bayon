package com.camhub.antiochschool.command.payroll;

import com.camhub.antiochschool.domain.Invoice;
import com.camhub.antiochschool.domain.Student;
import com.camhub.antiochschool.service.StudentFacade;
import org.bayon.form.validation.FormValidationType;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public class InvoiceFormCommand extends FrontCommand {

    String target = "invoice-form";

    @Override
    public void execute() throws ServletException, IOException {

        if(!getValidator(FormValidationType.IS_NUMBER).validate(request.getParameter("id"), null)) {
            target = "404";
        } else {
            Student student = StudentFacade.getInstance().get(Long.valueOf(request.getParameter("id")));
            if(student == null) target = "404";
            else {
                request.setAttribute("student", student);
            }
        }

        // set action attribute
        if("payroll/add".equals(getCommandName())) {
            request.setAttribute("action", "add");
        }
        else {
            request.setAttribute("action", "");
        }

    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();

    }

    @Override
    protected void responseAsHtml() throws ServletException, IOException {
        super.responseAsHtml();
        forward(target);
    }
}
