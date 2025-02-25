package pl.danielstrielnikow.filmclub.web.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.danielstrielnikow.filmclub.domain.film.FilmService;
import pl.danielstrielnikow.filmclub.domain.film.dto.FilmSaveDto;
import pl.danielstrielnikow.filmclub.domain.genre.GenreService;
import pl.danielstrielnikow.filmclub.domain.genre.dto.GenreDto;

import java.util.List;

@Controller
public class FilmManagementController {
    private final FilmService filmService;
    private final GenreService genreService;

    public FilmManagementController(FilmService filmService, GenreService genreService) {
        this.filmService = filmService;
        this.genreService = genreService;
    }

    @GetMapping("/admin/dodaj-film")
    public String addFilmForm(Model model) {
        List<GenreDto> allGenres = genreService.findAllGenres();
        model.addAttribute("genres", allGenres);
        FilmSaveDto film = new FilmSaveDto();
        model.addAttribute("film", film);
        return "/admin/film-form";
    }

    @PostMapping("/admin/dodaj-film")
    public String addFilm(FilmSaveDto film, RedirectAttributes redirectAttributes) {
        filmService.addFilm(film);
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE,
                "Film %s został zapisany".formatted(film.getTitle())
        );
        return "redirect:/admin";
    }

    @PostMapping("/admin/aktulizuj")
    public ResponseEntity<String> refreshMovies() {
        filmService.fetchAndSaveFilms();
        return ResponseEntity.ok("Filmy zostały zaktualizowane");
    }
}
