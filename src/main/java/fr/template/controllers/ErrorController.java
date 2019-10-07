/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author zouhairhajji
 */
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    
    @Autowired
    private ErrorAttributes errorAttributes;
    
    /**
     * 
     * Handle error path .
     */
    @Override
    public String getErrorPath() {
        System.out.println("retuen error");
        return "/error";
    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request, WebRequest webRequest, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        final Throwable error = errorAttributes.getError(webRequest);

        model.addAttribute("exception", error);
        model.addAttribute("message", error == null ? "" : error.getMessage());

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "errors/error-404";

            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "errors/error-500";
            }
        }

        return "errors/error-xxx";
    }

    @GetMapping("/throwErrorForTest")
    public String throwError() {
        throw new RuntimeException("my exception");
    }
    
    @GetMapping("/403")
    public String show_403() {
        return "errors/error-403";
    }
    
}
