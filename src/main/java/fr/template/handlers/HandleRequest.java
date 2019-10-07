/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.handlers;

import fr.template.entities.RoleEntity;
import fr.template.entities.UserEntity;
import fr.template.services.AuthentificationService;
import java.util.Enumeration;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author zouhairhajji
 */
@Component
public class HandleRequest extends HandlerInterceptorAdapter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    
    @Autowired
    private AuthentificationService authentificationService;
    
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String params = getParameters(request);
        String ip = this.getRemoteAddr(request);
        String schema = request.getScheme();
        String verb = request.getMethod();
        String url = request.getRequestURL().toString();
        String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        String roles = this.getCurrentRoles();
        String username = this.getCurrentUsername();

        
        this.authentificationService.logRequest(username, roles, schema, ip, verb, url, params, body);
        
        return super.preHandle(request, response, handler);
    }

    private String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth == null) {
            return "";
        }else if(auth.getPrincipal() instanceof UserEntity) {
            UserEntity principal = (UserEntity) auth.getPrincipal();
            return principal.getUsername();
        }else {
            return "";
        }
    }

    private String getCurrentRoles() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return "";
        }else if(auth.getPrincipal() instanceof UserEntity) {
            UserEntity principal = (UserEntity) auth.getPrincipal();
            return principal.getRoles().stream().map(RoleEntity::getLabel).collect(Collectors.joining(", "));
        }else if (auth.getPrincipal() instanceof String){
            return auth.getPrincipal().toString();
        }else {
            return  "{UNDEFINED}";
        }
    }

    private String getRemoteAddr(HttpServletRequest request) {
        String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
        if (ipFromHeader != null && ipFromHeader.length() > 0) {
            return ipFromHeader;
        }
        return request.getRemoteAddr();
    }

    private String getParameters(HttpServletRequest request) {
        StringBuffer posted = new StringBuffer();
        Enumeration<?> e = request.getParameterNames();
        if (e != null) {
            posted.append("?");
        }
        while (e.hasMoreElements()) {
            if (posted.length() > 1) {
                posted.append("&");
            }
            String curr = (String) e.nextElement();
            posted.append(curr + "=");
            if (curr.contains("password")
                    || curr.contains("pass")
                    || curr.contains("pwd")) {
                posted.append("*****");
            } else {
                posted.append(request.getParameter(curr));
            }
        }
        String ip = request.getHeader("X-FORWARDED-FOR");
        String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
        if (ipAddr != null && !ipAddr.equals("")) {
            posted.append("&_psip=" + ipAddr);
        }
        return posted.toString();
    }

}
