package pl.danielstrielnikow.filmclub.domain.rating;

import org.springframework.stereotype.Service;
import pl.danielstrielnikow.filmclub.domain.film.Film;
import pl.danielstrielnikow.filmclub.domain.film.FilmRepository;
import pl.danielstrielnikow.filmclub.domain.user.User;
import pl.danielstrielnikow.filmclub.domain.user.UserRepository;

import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final FilmRepository filmRepository;

    public RatingService(RatingRepository ratingRepository,
                         UserRepository userRepository,
                         FilmRepository filmRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
    }

    public void addOrUpdateRating(String userEmail, long filmId, int rating) {
        Rating ratingToSaveOrUpdate = ratingRepository.findByUser_EmailAndFilm_Id(userEmail, filmId)
                .orElseGet(Rating::new);
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        Film film = filmRepository.findById(filmId).orElseThrow();
        ratingToSaveOrUpdate.setUser(user);
        ratingToSaveOrUpdate.setFilm(film);
        ratingToSaveOrUpdate.setRating(rating);
        ratingRepository.save(ratingToSaveOrUpdate);
    }

    public Optional<Integer> getUserRatingForFilm(String userEmail, long filmId) {
        return ratingRepository.findByUser_EmailAndFilm_Id(userEmail, filmId)
                .map(Rating::getRating);
    }
}
