package org.bayon.form.validation;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Chandara Leang on 6/14/2017.
 */

public enum HttpServletRequestValidationImp implements HttpServletRequestValidation {

    IS_EMPTY(RequestValidationType.IS_EMPTY) {
        public boolean validate(HttpServletRequest req, String name) {
            return req.getParameter(name) == null || req.getParameter(name).isEmpty();
        }
    },

    IS_DATE(RequestValidationType.IS_DATE) {
        @Override
        public boolean validate(HttpServletRequest req, String name) {
            if(req.getParameter(name) == null){
                return false;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            sdf.setLenient(false);

            try {

                //if not valid, it will throw ParseException
                Date date = sdf.parse(req.getParameter(name));
                System.out.println(date);

            } catch (ParseException e) {

                e.printStackTrace();
                return false;
            }

            return true;
        }
    },
    
    IS_GENDER(RequestValidationType.IS_GENDER){
        public boolean validate(HttpServletRequest req, String name) {
            return !IS_EMPTY.validate(req, name) && (req.getParameter(name).equals("M") || req.getParameter(name).equals("F"));
        }
    },


    IS_AGE(RequestValidationType.IS_AGE){
        public boolean validate(HttpServletRequest req, String name) {

            int age = 0;
            int factor = 0;
            Date currentDate = new Date();
            Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();
            Date dob = null;
            try {
                dob = new SimpleDateFormat("MM/dd/yyyy").parse(req.getParameter(name));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            cal1.setTime(dob);
            cal2.setTime(currentDate);

            if(cal2.get(Calendar.DAY_OF_YEAR)<cal1.get(Calendar.DAY_OF_YEAR)){
                factor = -1;
            }

            age = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR) + factor;

            return age >= 0 && age <= 120;
        }
    },


    IS_EMAIL(RequestValidationType.IS_EMAIL){
        public boolean validate(HttpServletRequest req, String name) {
            return !IS_EMPTY.validate(req, name) && req.getParameter(name).matches("[a-zA-Z0-9._]+@[a-zA-Z0-9]+.[a-zA-Z._]{1,6}");
        }
    },

    IS_PASSWORD(RequestValidationType.IS_PASSWORD){
        public boolean validate(HttpServletRequest req, String name) {
            return req.getParameter(name).matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        }
    },


    IS_PHONE(RequestValidationType.IS_PHONE){
        public boolean validate(HttpServletRequest req, String name) {
            return !IS_EMPTY.validate(req, name) && req.getParameter(name).matches("[0-9+() ]{7,20}");
        }
    },

    IS_NUMBER(RequestValidationType.IS_NUMBER){
        public boolean validate(HttpServletRequest req, String name) {
            return !IS_EMPTY.validate(req, name) && req.getParameter(name).matches("[0-9]*.?[0-9]+");
        }
    },




    UNSUPPORTED (RequestValidationType.UNSUPPORTED) {
        public boolean validate(HttpServletRequest req, String name) {
            return false;
        }
    };

    private RequestValidationType validationType;

    private HttpServletRequestValidationImp(RequestValidationType validationType){
        this.validationType = validationType;
    }

    @Override
    public RequestValidationType getValidationType() {
        return validationType;
    }
}
