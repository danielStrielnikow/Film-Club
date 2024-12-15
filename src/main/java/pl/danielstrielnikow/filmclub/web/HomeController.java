package pl.danielstrielnikow.filmclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.danielstrielnikow.filmclub.domain.film.FilmService;
import pl.danielstrielnikow.filmclub.domain.film.dto.FilmDto;

import java.util.List;

@Controller
public class HomeController {
    private final FilmService filmService;

    public HomeController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<FilmDto> promotedFilms = filmService.findAllPromotedFilms();
        model.addAttribute("heading", "Promowane filmy");
        model.addAttribute("description", "Filmy polecane przez nasz zespół");
        model.addAttribute("films", promotedFilms);
        return "film-listing";
    }
}
