package pl.danielstrielnikow.filmclub.domain.film;

import pl.danielstrielnikow.filmclub.domain.film.dto.FilmDto;
import pl.danielstrielnikow.filmclub.domain.rating.Rating;


class FilmDtoMapper {
    static FilmDto map(Film film) {
        double avgRating = film.getRatings().stream()
                .map(Rating::getRating)
                .mapToDouble(val -> val).average().orElse(0);
        int ratingCount = film.getRatings().size();
        return new FilmDto(
                film.getId(),
                film.getTitle(),
                film.getOriginalTitle(),
                film.getShortDescription(),
                film.getDescription(),
                film.getYoutubeTrailerId(),
                film.getReleaseYear(),
                film.getGenres(),
                film.isPromoted(),
                film.getPoster(),
                avgRating,
                ratingCount,
                film.getImdbRating()
        );
    }
}

