/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.ajaxController;

import fr.template.abstracts.AbstractAjaxController;
import fr.template.forms.ValidationJsonResponse;
import fr.template.forms.users.CreateUserForm;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zouhairhajji
 */
@RestController
@RequestMapping("users")
public class AjaxUserController extends AbstractAjaxController{

    @GetMapping("xxx")
    public ValidationJsonResponse<CreateUserForm> createUser(BindingResult bindingResult) {
        System.out.println("XXXXXX");
        
        return super.verif_form(bindingResult, CreateUserForm.class);
    }

}
