package pl.danielstrielnikow.filmclub.domain.film.dto;

import pl.danielstrielnikow.filmclub.domain.genre.Genre;

import java.util.List;

public class FilmDto {
    private Long id;
    private String title;
    private String originalTitle;
    private String shortDescription;
    private String description;
    private String youtubeTrailerId;
    private Integer releaseYear;
    private List<Genre> genre;
    private boolean promoted;
    private String poster;
    private double avgRating;
    private int ratingCount;
    private Double imdbRating;

    public FilmDto(Long id, String title, String originalTitle, String shortDescription, String description, String youtubeTrailerId, Integer releaseYear, List<Genre> genre, boolean promoted, String poster, double avgRating, int ratingCount, Double imdbRating) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.shortDescription = shortDescription;
        this.description = description;
        this.youtubeTrailerId = youtubeTrailerId;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.promoted = promoted;
        this.poster = poster;
        this.avgRating = avgRating;
        this.ratingCount = ratingCount;
        this.imdbRating = imdbRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutubeTrailerId() {
        return youtubeTrailerId;
    }

    public void setYoutubeTrailerId(String youtubeTrailerId) {
        this.youtubeTrailerId = youtubeTrailerId;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }


    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }
}

