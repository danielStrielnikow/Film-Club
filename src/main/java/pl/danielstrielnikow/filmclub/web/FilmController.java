package pl.danielstrielnikow.filmclub.web;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import pl.danielstrielnikow.filmclub.domain.film.FilmService;
import pl.danielstrielnikow.filmclub.domain.film.dto.FilmDto;
import pl.danielstrielnikow.filmclub.domain.rating.RatingService;

import java.util.List;
import java.util.Optional;

@Controller
public class FilmController {
    private final FilmService filmService;
    private final RatingService ratingService;

    public FilmController(FilmService filmService, RatingService ratingService) {
        this.filmService = filmService;
        this.ratingService = ratingService;
    }

    @GetMapping("/film/{id}")
    public String getMovie(@PathVariable long id,
                           Model model,
                           Authentication authentication) {
        FilmDto film = filmService.findFilmById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("film", film);
        //Jeżeli użytkownik jest zalogowany
        if (authentication != null) {
            String currentUserEmail = authentication.getName();
            //to wyszukujemy jego głos
            Integer rating = ratingService.getUserRatingForFilm(currentUserEmail, id).orElse(0);
            //i zapisujemy go w modelu
            model.addAttribute("userRating", rating);
        }
        return "film";
    }

    @GetMapping("/top10")
    public String findTop10(Model model) {
        List<FilmDto> top10Films = filmService.findTopFilms(10);
        model.addAttribute("heading", "Filmowe Top10");
        model.addAttribute("description", "Filmy najlepiej oceniane przez użytkowników");
        model.addAttribute("films", top10Films);
        return "film-listing";
    }
}
