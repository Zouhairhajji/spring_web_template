/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.abstracts;

import org.springframework.ui.Model;

/**
 *
 * @author zouhairhajji
 */
public abstract class AbstractController {

    private String view_name;
    private String view_folder;
    private String title;
    private long last_request;
    private Model model;

    public AbstractController(String view_folder) {
        this.view_folder = view_folder;
    }

    protected void init(String view_name, String title, Model model) {
        this.view_name = view_name;
        this.model = model;
        this.last_request = System.currentTimeMillis();

        this.model.addAttribute("title", title);
    }
    
    protected String render() {
        String filePath = this.view_folder + System.getProperty("file.separator") + this.view_name;
        long elapsed_time = this.last_request - System.currentTimeMillis();
        this.model.addAttribute("elapsed_time", elapsed_time);
        return filePath;
    }

    protected String send_redirect(String redirect_path) {
        return "redirect:" + redirect_path;
    }

}
