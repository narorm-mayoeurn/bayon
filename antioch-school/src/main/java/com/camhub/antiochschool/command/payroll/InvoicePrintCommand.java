package com.camhub.antiochschool.command.payroll;

import com.camhub.antiochschool.domain.Invoice;
import com.camhub.antiochschool.domain.Student;
import com.camhub.antiochschool.service.StudentFacade;
import org.bayon.form.validation.FormCriteria;
import org.bayon.form.validation.FormCriteriaImp;
import org.bayon.form.validation.FormValidationType;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public class InvoicePrintCommand extends FrontCommand {

    String target = "invoice-print";

    @Override
    public void execute() throws ServletException, IOException {

        if(!getValidator(FormValidationType.IS_NUMBER).validate(request.getParameter("id"), null)) {
            target = "404";
        } else {

            Invoice invoice = StudentFacade.getInstance().getPayrollById(Long.parseLong(request.getParameter("id")));
            if(invoice != null) {
                Student student = StudentFacade.getInstance().get(invoice.getStudentId());

                if(student != null) {
                    request.setAttribute("invoice", invoice);
                    request.setAttribute("student", student);
                } else target = "404";
            } else target = "404";


        }

    }

    @Override
    protected void responseAsHtml() throws ServletException, IOException {
        super.responseAsHtml();
        forward(target);
    }
}
