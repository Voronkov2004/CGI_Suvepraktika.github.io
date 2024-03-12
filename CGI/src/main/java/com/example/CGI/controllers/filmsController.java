package com.example.CGI.controllers;

import com.example.CGI.models.Films;
import com.example.CGI.repository.FilmsRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String filmPostAdd(@RequestParam String title, @RequestParam String full_text, @RequestParam String rating, @RequestParam String picture_link, @RequestParam String genre, Model model){
        Films films = new Films(title, full_text, rating, picture_link, genre);
        filmsRepository.save(films);
        return "redirect:/";
    }

    @GetMapping("/{id}/seats")
    public String ticketsForFilm(@PathVariable(value = "id") long id, Model model){
        filmsRepository.findById(id);
        return "seats";
    }

    @PostMapping("/{id}/seats")
    public String istuKohad(@PathVariable(value = "id") long id, @RequestParam("chairs") int chairs, HttpSession session){
        session.setAttribute("chairs", chairs);
        return "redirect:/{id}/seats/payment";
    }

    @GetMapping("/{id}/seats/payment")
    public String payment(@PathVariable(value = "id") long id, HttpSession session, Model model){
        Integer chairs = (Integer) session.getAttribute("chairs");
        model.addAttribute("chairs", chairs);
        return "payment";
    }

    @GetMapping("/{id}/sessions")
    public String showSessions(@PathVariable(value = "id") long id, Model model){
        filmsRepository.findById(id);
        Films film = filmsRepository.findById(id).get();
        model.addAttribute("title", film.getTitle());
        model.addAttribute("picture", film.getPicture_link());
        return "sessions";
    }

}
