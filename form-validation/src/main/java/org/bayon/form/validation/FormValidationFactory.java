package org.bayon.form.validation;

/**
 * Created by darith on 6/16/17.
 */
public interface FormValidationFactory {
    public FormValidation getValidator(FormValidationType type);
}
