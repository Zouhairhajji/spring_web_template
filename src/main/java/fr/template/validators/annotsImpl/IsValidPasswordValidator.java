/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.validators.annotsImpl;

import fr.template.validators.annots.IsValidPassword;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author zouhairhajji
 */
public class IsValidPasswordValidator implements ConstraintValidator<IsValidPassword, String>{

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
        return true;
    }

    @Override
    public void initialize(IsValidPassword constraintAnnotation) {
    
    }
    
    
    
    
}
