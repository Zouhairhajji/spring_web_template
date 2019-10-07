/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.forms.users;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author zouhairhajji
 */
@Builder
@Getter
@Setter
public class CreateUserForm {
    
    @NotEmpty
    @Size(min = 2, max = 10)
    public String email;
    
    public String password;
    
    public String firstName;
    
    public String lastName;
    
    public String entity;
    
    public String phoneNumber;
    
}
