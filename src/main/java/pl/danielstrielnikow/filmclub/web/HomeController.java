package pl.danielstrielnikow.filmclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String home(Model model,
                       @RequestParam(defaultValue = "0") int page) {
        int size = 10;
        // Paginowane filmy
        List<FilmDto> allFilmsPaginated = filmService.findAllFilmsPaginated(page, size);

        // Liczba stron
        int totalPages = filmService.getTotalPagesForAllFilms(size);

        // Określamy początek i koniec zakresu stron do wyświetlenia (zawsze 10 przycisków)
        int startPage = Math.max(page - 5, 0); // Aby nie przekroczyć strony 0
        int endPage = Math.min(startPage + 9, totalPages - 1); // Maksymalnie 10 przycisków

        model.addAttribute("heading", "Promowane filmy");
        model.addAttribute("description", "Filmy polecane przez nasz zespół");
        model.addAttribute("films", allFilmsPaginated); // Przekazujemy paginowane filmy
        model.addAttribute("currentPage", page); // Numeracja od 1 strony
        model.addAttribute("totalPages", totalPages); // Liczba stron
        model.addAttribute("startPage", startPage); // Początek zakresu stron
        model.addAttribute("endPage", endPage); // Koniec zakresu stron

        model.addAttribute("isHomePage", true);
        return "film-listing";
    }


}
