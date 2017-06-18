package com.camhub.antiochschool.command.payroll;

import com.camhub.antiochschool.domain.Invoice;
import com.camhub.antiochschool.domain.Invoice;
import com.camhub.antiochschool.service.StudentFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bayon.form.validation.FormValidationType;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public class PayrollSaveCommand extends FrontCommand {

    Map<String, String> errorMessages = new HashMap<>();

    @Override
    public void execute() throws ServletException, IOException {

        Invoice invoice = new Invoice();

        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("payroll_no"), null)) {
            errorMessages.put("payroll_no", "Invoice No cannot be empty.");
        }

        if(!getValidator(FormValidationType.IS_NUMBER).validate(request.getParameter("tuition_fee"), null)) {
            errorMessages.put("tuition_fee", "Turtion Fee is required.");
        }

        if(!getValidator(FormValidationType.IS_NUMBER).validate(request.getParameter("admin_fee"), null)) {
            errorMessages.put("admin_fee", "Administration Fee is required.");
        }

        if(!getValidator(FormValidationType.IS_NUMBER).validate(request.getParameter("supply_fee"), null)) {
            errorMessages.put("supply_fee", "Supply Fee is required.");
        }

        if(errorMessages.isEmpty()) {
            invoice.setPayrollNo(request.getParameter("payroll_no"));
            invoice.setTuitionFee(Double.parseDouble(request.getParameter("tuition_fee")));
            invoice.setAdministrationFee(Double.parseDouble(request.getParameter("admin_fee")));
            invoice.setSupplyFee(Double.parseDouble(request.getParameter("supply_fee")));

            String id = request.getParameter("id");

            if (id == null || id.isEmpty()) {
                StudentFacade.getInstance().create(invoice);
            } else {
                invoice.setId(Long.valueOf(id));
                StudentFacade.getInstance().update(invoice);
            }
        }
    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();

        String json = "";

        if(errorMessages.isEmpty()) {
            System.out.println("yes");
            Map<String, String> msg = new HashMap<>();
            msg.put("message", "Invoice information has been saved.");
            json = objectMapper.writeValueAsString(msg);
        } else {
            response.setStatus(400);
            json = new ObjectMapper().writeValueAsString(errorMessages);
        }

        response.getWriter().write(json);
    }
}
