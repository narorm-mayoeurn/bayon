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
public class InvoiceSaveCommand extends FrontCommand {

    Map<String, String> errorMessages = new HashMap<>();

    @Override
    public void execute() throws ServletException, IOException {

        Invoice invoice = new Invoice();

        if(!getValidator(FormValidationType.IS_NUMBER).validate(request.getParameter("student_id"), null)) {
            errorMessages.put("student_id", "Invoice No cannot be empty.");
        }

        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("invoice_no"), null)) {
            errorMessages.put("invoice_no", "Invoice No cannot be empty.");
        }

        if(!getValidator(FormValidationType.IS_DATE).validate(request.getParameter("invoice_date"), null)) {
            errorMessages.put("invoice_date", "Invoice date cannot be empty.");
        }


        Boolean hasTuitionFee = false;

        FormCriteria crit = new FormCriteriaImp();
        crit.setFlag(true);
        crit.setIntFrom(0);
        crit.setIntTo(1000);

        if(!getValidator(FormValidationType.IS_RANGE).validate(request.getParameter("tuition_fee"), crit)) {
            errorMessages.put("tuition_fee", "Tuition Fee is required (0 - 1000).");
        } else {
            crit.setFlag(false);
            if(getValidator(FormValidationType.IS_RANGE).validate(request.getParameter("tuition_fee"), crit)) {
                hasTuitionFee = true;
                if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("start_end_date"), null)) {
                    errorMessages.put("start_end_date", "Effective date cannot be empty.");
                }
            }
            crit.setFlag(true);
        }

        if(!getValidator(FormValidationType.IS_RANGE).validate(request.getParameter("admin_fee"), crit)) {
            errorMessages.put("admin_fee", "Administration Fee is required (0 - 1000).");
        }

        if(!getValidator(FormValidationType.IS_RANGE).validate(request.getParameter("supply_fee"), crit)) {
            errorMessages.put("supply_fee", "Supply Fee is required (0 - 1000).");
        }

        String startDate = "";
        String endDate = "";

        if(errorMessages.isEmpty() && hasTuitionFee) {
            String[] t = request.getParameter("start_end_date").split(" - ");
            startDate = t[0];
            endDate = t[1];

            if(!getValidator(FormValidationType.IS_DATE).validate(startDate, null) || !getValidator(FormValidationType.IS_DATE).validate(endDate, null)) {
                errorMessages.put("start_end_date", "Effective date is not correct.");
            }
        }

        if(errorMessages.isEmpty()) {

            invoice.setStudentId(Long.parseLong(request.getParameter("student_id")));
            invoice.setInvoiceNo(request.getParameter("invoice_no"));

            try {
                invoice.setInvoiceDate(new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("invoice_date")));

                if(hasTuitionFee) {
                    invoice.setStartDate(new SimpleDateFormat("MM/dd/yyyy").parse(startDate));
                    invoice.setEndDate(new SimpleDateFormat("MM/dd/yyyy").parse(endDate));
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }

            invoice.setTuitionFee(Double.parseDouble(request.getParameter("tuition_fee")));
            invoice.setAdministrationFee(Double.parseDouble(request.getParameter("admin_fee")));
            invoice.setSupplyFee(Double.parseDouble(request.getParameter("supply_fee")));


            if(getValidator(FormValidationType.IS_NUMBER).validate(request.getParameter("total_discount"), null)) {
                invoice.setTotalDiscount(Double.parseDouble(request.getParameter("total_discount")));
            }

            Long invoiceId = StudentFacade.getInstance().create(invoice);

            // if student pay for tuition fee, set this invoice as active
            if(invoice.getTuitionFee() > 0) {
                Student student = StudentFacade.getInstance().get(Long.parseLong(request.getParameter("student_id")));
                student.setInvoiceId(invoiceId);
                StudentFacade.getInstance().update(student);
            }
        }
    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();

        if(errorMessages.isEmpty()) {
            Map<String, String> msg = new HashMap<>();
            msg.put("message", "Invoice has been saved.");
            response.getWriter().write(objectMapper.writeValueAsString(msg));
        } else {
            response.setStatus(400);
            response.getWriter().write(objectMapper.writeValueAsString(errorMessages));
        }
    }
}
