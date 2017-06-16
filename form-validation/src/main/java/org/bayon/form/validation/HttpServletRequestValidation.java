package org.bayon.form.validation;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Chandara Leang on 6/13/2017.
 */

public interface HttpServletRequestValidation {
    boolean validate(HttpServletRequest req, String name);
    RequestValidationType getValidationType();
}
