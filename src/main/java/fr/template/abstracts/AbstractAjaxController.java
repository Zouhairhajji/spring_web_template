/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.abstracts;

import fr.template.forms.ValidationJsonResponse;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author zouhairhajji
 */
@RequestMapping("ajax")
public abstract class AbstractAjaxController {

    public ValidationJsonResponse verif_form(BindingResult bindingResult, Class<?> clazz) {
        Map<String, String> errors = bindingResult.getFieldErrors().stream()
                .collect(
                        Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                );
        Boolean valid = bindingResult.hasErrors();
        
        
        ValidationJsonResponse<Object> a  = new ValidationJsonResponse<Object>();
        
        return null;
    }

}
