/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.bootstraps;

import fr.template.forms.users.CreateUserForm;
import fr.template.services.UserService;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author zouhairhajji
 */
@Component
public class AccessLogin implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
 

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent e) {
        logger.info("[BOOTSTRAP-INIT] {}", this.getClass());
        
        this.userService.createRole("ROLE_ADMIN", Boolean.FALSE);
        this.userService.createRole("ROLE_USER", Boolean.TRUE);
        
        
        String username = "admin@admin.fr";
        CreateUserForm user1 = CreateUserForm.builder()
                .email(username)
                .password("admin")
                .entity("/cori/coo/perf")
                .firstName("admin")
                .lastName("admin")
                .phoneNumber("0000000000")
                .build();
        
        this.userService.createUser(user1);
        this.userService.updateLockByUsername(username, Boolean.FALSE);
        
        
        
        logger.info("[BOOTSTRAP-INIT] {}", this.getClass());
    }

}
