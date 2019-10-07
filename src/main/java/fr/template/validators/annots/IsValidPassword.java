/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.validators.annots;

import fr.template.validators.annotsImpl.IsValidPasswordValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author zouhairhajji
 */
@Documented
@Target(value = {ElementType.METHOD, ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsValidPasswordValidator.class)
public @interface IsValidPassword {
    
    String message() default "the password must meet complexity requirement";
    
    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
