package pl.danielstrielnikow.filmclub.api.dto;

import org.springframework.stereotype.Component;
import pl.danielstrielnikow.filmclub.domain.film.Film;
import pl.danielstrielnikow.filmclub.domain.genre.Genre;
import pl.danielstrielnikow.filmclub.domain.genre.GenreRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilmApiMapper {

    private final GenreRepository genreRepository;

    public FilmApiMapper(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    public  Film mapToEntity(FilmApiDto apiDto) {
        Film film = new Film();

        film.setTitle(apiDto.getOriginalTitle());
        film.setOriginalTitle(apiDto.getOriginalTitle());
        film.setShortDescription("");
        film.setDescription(apiDto.getDescription());
        film.setYoutubeTrailerId(apiDto.getYoutubeTrailerId());
        film.setReleaseYear(apiDto.getReleaseYear());

        List<Genre> genres = new ArrayList<>();
        for (String genreName : apiDto.getGenres()) {
            Genre genre = genreRepository.findByNameIgnoreCase(genreName)
                    .orElseGet(() -> {
                        Genre newGenre = new Genre();
                        newGenre.setName(genreName);
                        genreRepository.save(newGenre);  // Zapisz nowy gatunek
                        return newGenre;
                    });
            genres.add(genre);
        }

        film.setGenres(genres);
        film.setPromoted(true);
        film.setPoster(apiDto.getPoster());
        film.setImdbRating(apiDto.getImdbRating());

        return film;
    }
}

