package com.mjavka.fresupp.annotations;

import com.mjavka.fresupp.actions.AbstractRegistrationAction;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author mjavka
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {   
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {       
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){   
        AbstractRegistrationAction user = (AbstractRegistrationAction) obj;
        return user.getPassword().equals(user.getMatchingPassword());    
    }     
}
