package com.camhub.antiochschool.command.payroll;

import com.camhub.antiochschool.domain.Payroll;
import com.camhub.antiochschool.helper.Pair;
import com.camhub.antiochschool.repository.PayrollRepository;
import com.camhub.antiochschool.repository.SingletonRepositoryFactory;
import com.camhub.antiochschool.service.StudentFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bayon.form.validation.FormValidationType;
import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public class PayrollSaveCommand extends FrontCommand {

    List<Pair<String, String>> errorMessages = new ArrayList<>();

    @Override
    public void execute() throws ServletException, IOException {

        Payroll payroll = new Payroll();

        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("payroll_no"), null)) {
            errorMessages.add(new Pair<>("payroll_no", "Payroll No cannot be empty."));
        }

        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("tuition_fee"), null)) {
            errorMessages.add(new Pair<>("tuition_fee", "Turtion Fee is required."));
        }

        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("admin_fee"), null)) {
            errorMessages.add(new Pair<>("admin_fee", "Administration Fee is required."));
        }

        if(getValidator(FormValidationType.IS_EMPTY).validate(request.getParameter("supply_fee"), null)) {
            errorMessages.add(new Pair<>("supply_fee", "Supply Fee is required."));
        }

        if(errorMessages.isEmpty()) {
            payroll.setPayrollNo(request.getParameter("payroll_no"));
            payroll.setTuitionFee(Double.parseDouble(request.getParameter("tuition_fee")));
            payroll.setAdministrationFee(Double.parseDouble(request.getParameter("admin_fee")));
            payroll.setSupplyFee(Double.parseDouble(request.getParameter("supply_fee")));

            String id = request.getParameter("id");

            if (id == null || id.isEmpty()) {
                StudentFacade.getInstance().create(payroll);
            } else {
                payroll.setId(Long.valueOf(id));
                StudentFacade.getInstance().update(payroll);
            }
        }
    }

    @Override
    protected void responseAsJson() throws ServletException, IOException {
        super.responseAsJson();

        String json = "";

        if(errorMessages.isEmpty()) {
            json = new ObjectMapper().writeValueAsString(new Pair<>("message", "Payroll information has been saved."));
        } else {
            response.setStatus(400);
            json = new ObjectMapper().writeValueAsString(errorMessages);
        }

        response.getWriter().write(json);
    }
}
