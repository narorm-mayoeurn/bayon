package org.bayon.form.validation;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Chandara Leang on 6/13/2017.
 */

public interface FormValidation {
    boolean validate(String input, FormCriteria crit);
}
