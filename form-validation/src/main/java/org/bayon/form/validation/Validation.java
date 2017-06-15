package org.bayon.form.validation;

/**
 * Created by Chandara Leang on 6/13/2017.
 */

public interface Validation {
    <T extends UserInput> boolean validate(T input);
    ValidationType getValidationType();
}
