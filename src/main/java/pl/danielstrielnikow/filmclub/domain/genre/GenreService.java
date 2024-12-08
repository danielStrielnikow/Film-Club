package pl.danielstrielnikow.filmclub.domain.genre;

import org.springframework.stereotype.Service;
import pl.danielstrielnikow.filmclub.domain.genre.dto.GenreDto;

import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;


    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Optional<GenreDto> findGenreByName(String name) {
        return genreRepository.findByNameIgnoreCase(name)
                .map(GenreDtoMapper::map);
    }
}
