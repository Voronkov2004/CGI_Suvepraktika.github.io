package com.example.CGI.controllers;

import com.example.CGI.models.Films;
import com.example.CGI.repository.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class filmsController {

    @Autowired
    private FilmsRepository filmsRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Main Page");
        Iterable<Films> films = filmsRepository.findAll();
        model.addAttribute("films", films);
        return "home";
    }

    @GetMapping("/add")
    public String addFilm(Model model) {
        model.addAttribute("title", "Add Film");
        return "add-film";
    }

    @PostMapping("/add")
    public String filmPostAdd(@RequestParam String title, @RequestParam String full_text, @RequestParam String rating, Model model){
        Films films = new Films(title, full_text, rating);
        filmsRepository.save(films);
        return "redirect:/";
    }

}
