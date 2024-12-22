package pl.danielstrielnikow.filmclub.domain.film;

import org.springframework.stereotype.Service;
import pl.danielstrielnikow.filmclub.domain.film.dto.FilmSaveDto;
import pl.danielstrielnikow.filmclub.domain.film.dto.FilmDto;
import pl.danielstrielnikow.filmclub.domain.genre.Genre;
import pl.danielstrielnikow.filmclub.domain.genre.GenreRepository;
import pl.danielstrielnikow.filmclub.storage.FileStorageService;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private final FilmRepository filmRepository;
    private final GenreRepository genreRepository;
    private final FileStorageService fileStorageService;
    private final PagingRepository pagingRepository;

    public FilmService(FilmRepository filmRepository,
                       GenreRepository genreRepository,
                       FileStorageService fileStorageService,
                       PagingRepository pagingRepository) {
        this.filmRepository = filmRepository;
        this.genreRepository = genreRepository;
        this.fileStorageService = fileStorageService;
        this.pagingRepository = pagingRepository;
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

    public List<FilmDto> findTopFilms(int size) {
        Pageable page = Pageable.ofSize(size);
        return filmRepository.findTopByRating(page).stream()
                .map(FilmDtoMapper::map)
                .toList();
    }

    public List<FilmDto> findAllFilmsPaginated(int page, int size) {
        // Zabezpieczamy przed przekroczeniem liczby stron
        page = Math.max(page, 0); // Zapewnia, że page nie będzie mniejsze niż 0
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return pagingRepository.findAll(pageable).stream()
                .map(FilmDtoMapper::map)
                .toList();
    }

    public int getTotalPagesForAllFilms(int size) {
        long totalFilms = filmRepository.count();  // Liczymy wszystkie filmy
        return (int) Math.max(1, Math.ceil((double) totalFilms / size));  // Liczba stron, co najmniej 1
    }


    public Optional<FilmDto> findFilmIdByTitle(String title) {
        return filmRepository.findByTitleIgnoreCase(title)
                .map(FilmDtoMapper::map);
    }

}

