package pl.danielstrielnikow.filmclub.domain.genre;

import pl.danielstrielnikow.filmclub.domain.genre.dto.GenreDto;

public class GenreDtoMapper {
    static GenreDto map(Genre genre) {
        return new GenreDto(
                genre.getId(),
                genre.getName()
        );
    }
}
