package pl.danielstrielnikow.filmclub.domain.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.danielstrielnikow.filmclub.domain.film.FilmService;
import pl.danielstrielnikow.filmclub.domain.film.dto.FilmDto;

import java.util.Optional;

@Controller
public class FilmController {
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/film/{id}")
    public String getFilm(@PathVariable long id, Model model) {
        Optional<FilmDto> optionalFilm = filmService.findFilmById(id);
        optionalFilm.ifPresent(film -> model.addAttribute("film", film));
        return "film";
    }
}
