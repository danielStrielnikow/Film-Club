package pl.danielstrielnikow.filmclub.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import pl.danielstrielnikow.filmclub.domain.film.FilmService;
import pl.danielstrielnikow.filmclub.domain.film.dto.FilmDto;
import pl.danielstrielnikow.filmclub.domain.genre.GenreService;
import pl.danielstrielnikow.filmclub.domain.genre.dto.GenreDto;

import java.util.List;

@Controller
public class GenreController {
    private final FilmService filmService;
    private final GenreService genreService;

    public GenreController(FilmService filmService, GenreService genreService) {
        this.filmService = filmService;
        this.genreService = genreService;
    }

    @GetMapping("gatunek/{name}")
    public String getGenre(@PathVariable String name, Model model, @RequestParam(defaultValue = "0") int page) {
        GenreDto genre = genreService.findGenreByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        int size = 10;
        List<FilmDto> films = filmService.findFilmsByGenrePaginated(name, page, size);
        int totalPages = filmService.getTotalPagesForFilmsByGenre(name, size);
        int startPage = Math.max(page - 5, 0); // Aby nie przekroczyć strony 0
        int endPage = Math.min(startPage + 9, totalPages - 1);
        model.addAttribute("genre", genre);
        model.addAttribute("heading", genre.getName());
        model.addAttribute("description", "Filmy tego gatunku");
        model.addAttribute("films", films);
        model.addAttribute("currentPage", page); // Numeracja od 1 strony
        model.addAttribute("totalPages", totalPages); // Liczba stron
        model.addAttribute("startPage", startPage); // Początek zakresu stron
        model.addAttribute("endPage", endPage);
        model.addAttribute("isGenrePage", true);
        return "film-listing";
    }

    @GetMapping("/gatunki-filmowe")
    public String getGenreList(Model model) {
        List<GenreDto> genres = genreService.findAllGenres();
        model.addAttribute("genres", genres);
        return "genre-listing";
    }
}
