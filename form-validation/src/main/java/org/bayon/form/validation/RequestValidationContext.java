package org.bayon.form.validation;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Chandara Leang on 6/14/2017.
 */

public class RequestValidationContext {
    private Set<HttpServletRequestValidation> userValidations;

    public RequestValidationContext(Set<HttpServletRequestValidation> userValidations){
        this.userValidations = userValidations;
    }

    /*
    * This method performs validation for fields one by one and return the invalid one if found.
    * Otherwise, it will continue validating remaining fields. If all the fields are valid then will return null.
    */
    public RequestValidationType execute(HttpServletRequest request, String name){
        HttpServletRequestValidation userValidation = HttpServletRequestValidationImp.UNSUPPORTED;
        for (Iterator<HttpServletRequestValidation> iterator = userValidations.iterator(); iterator.hasNext();) {
            userValidation = iterator.next();
            if (userValidation.validate(request, name)) {

                return userValidation.getValidationType();
            }
        }
        return null;
    }

    /*
    * This method performs validation for fields one by one and
    * add the invalid one into a list if found and returns that list.
    */
    public List<RequestValidationType> executeAndGetList(HttpServletRequest request, String name) {
        HttpServletRequestValidation userValidation = HttpServletRequestValidationImp.UNSUPPORTED;
        List<RequestValidationType> validatedTypes = new ArrayList<RequestValidationType>();
        for (Iterator<HttpServletRequestValidation> iterator = userValidations.iterator(); iterator.hasNext();) {
            userValidation = iterator.next();
            if (userValidation.validate(request, name)) {
                validatedTypes.add(userValidation.getValidationType());
            }
        }
        return validatedTypes;
    }
}
