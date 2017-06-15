package org.bayon.form.validation;

import java.text.ParseException;

/**
 * Created by Chandara Leang on 6/14/2017.
 */

public enum UserValidation implements Validation{

    NAME(ValidationType.NAME){
        public <T extends UserInput> boolean validate(T input) {
            if(input.isInputValid() && input.getName().isEmpty()){
                return true;
            }
            return false;
        }
    },

    GENDER(ValidationType.GENDER){
        public <T extends UserInput> boolean validate(T input) {
            if(input.isInputValid() && input.getGender().isEmpty()){
                return true;
            }
            return false;
        }
    },

    DATE_OF_BIRTH(ValidationType.DATE_OF_BIRTH){
        public <T extends UserInput> boolean validate(T input) {

            try {
                if(input.isInputValid() && input.getDateOfBirth().isEmpty() && input.underEighteen()<18) {
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        }
    },

    EMAIL(ValidationType.EMAIL){
        public <T extends UserInput> boolean validate(T input) {
            if(input.isInputValid() && input.getEmail().isEmpty()){
                return true;
            }
            return false;
        }
    },

    PASSWORD(ValidationType.PASSWORD){
        public <T extends UserInput> boolean validate(T input) {
            if(input.isInputValid() && input.getPassword().isEmpty()){
                return true;
            }
            return false;
        }
    },

    SSN(ValidationType.SSN){
        public <T extends UserInput> boolean validate(T input) {
            if(input.isInputValid() && input.getSSN().isEmpty()){
                return true;
            }
            return false;
        }
    },

    PHONE(ValidationType.PHONE){
        public <T extends UserInput> boolean validate(T input) {
            if(input.isInputValid() && input.getPhone().isEmpty()){
                return true;
            }
            return false;
        }
    },

    STREET(ValidationType.STREET){
        public <T extends UserInput> boolean validate(T input) {
            if(input.isInputValid() && input.getStreet().isEmpty()){
                return true;
            }
            return false;
        }
    },

    CITY(ValidationType.CITY){
        public <T extends UserInput> boolean validate(T input) {
            if(input.isInputValid() && input.getCity().isEmpty()){
                return true;
            }
            return false;
        }
    },

    STATE(ValidationType.STATE){
        public <T extends UserInput> boolean validate(T input) {
            if(input.isInputValid() && input.getState().isEmpty()){
                return true;
            }
            return false;
        }
    },

    ZIP(ValidationType.ZIP){
        public <T extends UserInput> boolean validate(T input) {
            if(input.isInputValid() && input.getZip().isEmpty()){
                return true;
            }
            return false;
        }
    },

    UNSUPPORTED (ValidationType.UNSUPPORTED) {
        public <T extends UserInput> boolean validate(T input) {
            return false;
        }
    };

    private ValidationType validationType;

    private UserValidation(ValidationType validationType){
        this.validationType = validationType;
    }

    @Override
    public ValidationType getValidationType() {
        return validationType;
    }
}
