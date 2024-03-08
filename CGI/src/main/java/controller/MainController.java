package com.example.CGI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Main Page");
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage(Model model) {
        return "about";
    }

    @GetMapping("/pricing")
    public String pricingPage(Model model) {
        return "price";
    }

    @GetMapping("/login")
    public String logInPage(Model model) {
        return "login";
    }
}