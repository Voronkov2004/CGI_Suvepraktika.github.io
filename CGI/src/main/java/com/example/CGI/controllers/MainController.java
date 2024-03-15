package com.example.CGI.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/about")
    public String aboutPage(Model model) {
        return "about";
    }

    @GetMapping("/login")
    public String logInPage(Model model) {
        return "login";
    }
}