package org.bayon.form.validation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Chandara Leang on 6/14/2017.
 */

public class UserValidationContext {
    private Set<Validation> userValidations;

    public UserValidationContext(Set<Validation> userValidations){
        this.userValidations = userValidations;
    }

    /*
    * This method performs validation for fields one by one and return the invalid one if found.
    * Otherwise, it will continue validating remaining fields. If all the fields are valid then will return null.
    */
    public ValidationType execute(UserInput userInput){
        Validation userValidation = UserValidation.UNSUPPORTED;
        for (Iterator<Validation> iterator = userValidations.iterator(); iterator.hasNext();) {
            userValidation = iterator.next();
            if (userValidation.validate(userInput)) {
                return userValidation.getValidationType();
            }
        }
        return null;
    }

    /*
    * This method performs validation for fields one by one and
    * add the invalid one into a list if found and returns that list.
    */
    public List<ValidationType> executeAndGetList(UserInput userInput) {
        Validation userValidation = UserValidation.UNSUPPORTED;
        List<ValidationType> validatedTypes = new ArrayList<ValidationType>();
        for (Iterator<Validation> iterator = userValidations.iterator(); iterator.hasNext();) {
            userValidation = iterator.next();
            if (userValidation.validate(userInput)) {
                validatedTypes.add(userValidation.getValidationType());
            }
        }
        return validatedTypes;
    }
}
