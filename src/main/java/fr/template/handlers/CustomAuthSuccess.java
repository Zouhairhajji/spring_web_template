/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.handlers;

import fr.template.entities.UserEntity;
import fr.template.services.AuthentificationService;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author QTKT2194
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CustomAuthSuccess extends SimpleUrlAuthenticationSuccessHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthentificationService authService;

    public CustomAuthSuccess() {
        super();
        setUseReferer(true);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession httpSession = request.getSession();
        UserEntity user = (UserEntity) authentication.getPrincipal();

        httpSession.setAttribute("LAST_NAME", user.getLastName());
        httpSession.setAttribute("FIRST_NAME", user.getFirstName());
        httpSession.setAttribute("FULL_NAME", user.getLastName() + " " + user.getFirstName());

        List<String> roles = user.getRoles().stream()
                .map(s -> s.getLabel())
                .collect(Collectors.toList());
        httpSession.setAttribute("USER_LIST_ROLES", roles);

        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        this.authService.logLoginAttempt(user.getUsername(), ipAddress, Boolean.TRUE, roles);

        logger.info("new auth ");
        
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
