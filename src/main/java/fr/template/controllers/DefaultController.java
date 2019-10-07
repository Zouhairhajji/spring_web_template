/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.controllers;

import fr.template.forms.users.CreateUserForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author zouhairhajji
 */
@Controller
@RequestMapping("")
public class DefaultController  {

    private final static Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @GetMapping("/")
    public String show_dashboard(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //logger.info("{}", auth.getAuthorities());
        //logger.info("{}", auth.getPrincipal());

        return "dashboard";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            HttpServletResponse response,
            Model model) {

        
        model.addAttribute("new_user", CreateUserForm.builder().build());
        

        // check if error login
        if (error != null) {
            model.addAttribute("error", " L'identifiant ou le mot de passe est incorrect !!");
            logger.info("login error");
            
        }

        // check if logout request
        if (logout != null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null) {
                new SecurityContextLogoutHandler().logout(this.request, this.response, auth);
                logger.info("logout ok");
            }
        }
        
        // check if login request
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if( !(authentication instanceof AnonymousAuthenticationToken) ) {
            return "redirect:/";
        }

        return "login";
    }


}
