package org.bayon.form.validation;

/**
 * Created by darith on 6/16/17.
 */
public class FormValidationFactoryImp implements FormValidationFactory {

    private static FormValidationFactoryImp instance = new FormValidationFactoryImp();

    private FormValidationFactoryImp() {}

    public static FormValidationFactoryImp getInstance() {
        return instance;
    }

    @Override
    public FormValidation getValidator(FormValidationType type) {
        if(type == FormValidationType.IS_AGE) return FormValidationImp.IS_AGE;
        if(type == FormValidationType.IS_DATE) return FormValidationImp.IS_DATE;
        if(type == FormValidationType.IS_EMAIL) return FormValidationImp.IS_EMAIL;
        if(type == FormValidationType.IS_EMPTY) return FormValidationImp.IS_EMPTY;
        if(type == FormValidationType.IS_GENDER) return FormValidationImp.IS_GENDER;
        if(type == FormValidationType.IS_MATCH) return FormValidationImp.IS_MATCH;
        if(type == FormValidationType.IS_NUMBER) return FormValidationImp.IS_NUMBER;
        if(type == FormValidationType.IS_PASSWORD) return FormValidationImp.IS_PASSWORD;
        if(type == FormValidationType.IS_PHONE) return FormValidationImp.IS_PHONE;
        return null;
    }
}
