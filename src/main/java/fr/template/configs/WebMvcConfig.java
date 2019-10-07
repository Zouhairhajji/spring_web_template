/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.configs;

import fr.template.handlers.HandleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author zouhairhajji
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private HandleRequest handleRequest;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handleRequest);
    }
    
    
    
}
