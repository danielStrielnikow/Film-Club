package pl.danielstrielnikow.filmclub.domain.rating;

import jakarta.persistence.*;
import pl.danielstrielnikow.filmclub.domain.film.Film;
import pl.danielstrielnikow.filmclub.domain.user.User;

@Entity
@Table(name = "film_rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    private Integer rating;
    private Integer avgImdbRating;

    public Rating() {
    }

    public Rating(User user, Film film, Integer rating, Integer avgImdbRating) {
        this.user = user;
        this.film = film;
        this.rating = rating;
        this.avgImdbRating = avgImdbRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getAvgImdbRating() {
        return avgImdbRating;
    }

    public void setAvgImdbRating(Integer avgImdbRating) {
        this.avgImdbRating = avgImdbRating;
    }
}
