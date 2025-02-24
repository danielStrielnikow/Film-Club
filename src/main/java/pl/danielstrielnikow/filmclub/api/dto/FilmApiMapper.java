package pl.danielstrielnikow.filmclub.api.dto;

import pl.danielstrielnikow.filmclub.domain.film.Film;
import pl.danielstrielnikow.filmclub.domain.genre.Genre;
import pl.danielstrielnikow.filmclub.domain.genre.GenreRepository;

public class FilmApiMapper {

    private final GenreRepository genreRepository;

    public FilmApiMapper(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    public static Film mapToEntity(FilmApiDto apiDto) {
        Film film = new Film();

        film.setTitle(apiDto.getOriginalTitle());
        film.setOriginalTitle(apiDto.getOriginalTitle());
        film.setShortDescription("");
        film.setDescription(apiDto.getDescription());
        film.setYoutubeTrailerId(apiDto.getYoutubeTrailerId());
        film.setReleaseYear(apiDto.getReleaseYear());
//        film.setGenre(genre);
        film.setPromoted(true);
        film.setPoster(apiDto.getPoster());
//        film.setRatings(apiDto.getAvgRating());

        return film;
    }
}

