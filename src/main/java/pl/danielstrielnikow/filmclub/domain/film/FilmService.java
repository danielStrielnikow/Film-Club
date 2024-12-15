package pl.danielstrielnikow.filmclub.domain.film;

import org.springframework.stereotype.Service;
import pl.danielstrielnikow.filmclub.domain.film.dto.FilmSaveDto;
import pl.danielstrielnikow.filmclub.domain.film.dto.FilmDto;
import pl.danielstrielnikow.filmclub.domain.genre.Genre;
import pl.danielstrielnikow.filmclub.domain.genre.GenreRepository;
import pl.danielstrielnikow.filmclub.storage.FileStorageService;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;
    private final GenreRepository genreRepository;
    private final FileStorageService fileStorageService;

    public FilmService(FilmRepository filmRepository, GenreRepository genreRepository, FileStorageService fileStorageService) {
        this.filmRepository = filmRepository;
        this.genreRepository = genreRepository;
        this.fileStorageService = fileStorageService;
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

    public List<FilmDto> findFilmByGenreName(String genre) {
        return filmRepository.findAllByGenre_NameIgnoreCase(genre)
                .stream()
                .map(FilmDtoMapper::map)
                .toList();
    }
    public void addFilm(FilmSaveDto filmSaveDto) {
        Film film = new Film();
        film.setTitle(filmSaveDto.getTitle());
        film.setOriginalTitle(filmSaveDto.getOriginalTitle());
        film.setPromoted(filmSaveDto.isPromoted());
        film.setReleaseYear(filmSaveDto.getReleaseYear());
        film.setShortDescription(filmSaveDto.getShortDescription());
        film.setDescription(filmSaveDto.getDescription());
        film.setYoutubeTrailerId(filmSaveDto.getYoutubeTrailerId());
        Genre genre = genreRepository.findByNameIgnoreCase(filmSaveDto.getGenre()).orElseThrow();
        film.setGenre(genre);
        if (filmSaveDto.getPoster() != null) {
            String savedFileName = fileStorageService.saveImage(filmSaveDto.getPoster());
            film.setPoster(savedFileName);
        }
        filmRepository.save(film);
    }
}
