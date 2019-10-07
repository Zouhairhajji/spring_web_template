/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.controllers.admin;

import fr.template.abstracts.AbstractController;
import fr.template.entities.UserEntity;
import fr.template.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author zouhairhajji
 */
@Controller
@RequestMapping("users")
public class UserController extends AbstractController{

    @Autowired
    private UserService userService;
    
    
    public UserController() {
        super("users_views");
    }
    
    @GetMapping("list_users")
    public String list_all_users(Model model) {
        super.init("list_users", "List users", model);
        
        List<UserEntity> users =  this.userService.findAllUsers();
        model.addAttribute("users", users);
        
        return super.render();
    }
    
    
    
}
