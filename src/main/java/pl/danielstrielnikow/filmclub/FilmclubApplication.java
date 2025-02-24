package pl.danielstrielnikow.filmclub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.danielstrielnikow.filmclub.domain.film.FilmService;

import java.io.IOException;

@SpringBootApplication
public class FilmclubApplication implements CommandLineRunner {

    private final FilmService filmService;

    public FilmclubApplication(FilmService filmService) {
        this.filmService = filmService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FilmclubApplication.class, args);
    }

    @Override
    public void run(String... args) throws IOException, InterruptedException {
        filmService.fetchAndSaveFilms();
    }
}
