package pl.danielstrielnikow.filmclub.domain.film;

import pl.danielstrielnikow.filmclub.domain.film.dto.FilmDto;


class FilmDtoMapper {
    static FilmDto map(Film film) {
        return new FilmDto(
                film.getId(),
                film.getTitle(),
                film.getOriginalTitle(),
                film.getShortDescription(),
                film.getDescription(),
                film.getYoutubeTrailerId(),
                film.getReleaseYear(),
                film.getGenre().getName(),
                film.isPromoted()
        );
    }
}

