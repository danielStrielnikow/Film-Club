package pl.danielstrielnikow.filmclub.domain.film;

import org.springframework.stereotype.Service;
import pl.danielstrielnikow.filmclub.domain.film.dto.FilmDto;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<FilmDto> findAllPromotedFilms() {
        return filmRepository.findAllByPromotedIsTrue()
                .stream()
                .map(FilmDtoMapper::map)
                .toList();
    }

    public Optional<FilmDto> findFilmById(long id) {
        return filmRepository.findById(id).map(FilmDtoMapper::map);
    }
}