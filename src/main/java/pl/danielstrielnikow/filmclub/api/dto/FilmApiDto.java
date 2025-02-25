package pl.danielstrielnikow.filmclub.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmApiDto {
    @JsonDeserialize(using = CustomIdDeserializer.class)
    private Long id;
    private String title;
    @JsonProperty("originalTitle")
    private String originalTitle;
    private String shortDescription;
    private String description;
    @JsonProperty("url")
    private String youtubeTrailerId;
    @JsonProperty("startYear")
    private Integer releaseYear;
    @JsonProperty("genres")
    private List<String> genres;
    private boolean promoted;
    @JsonProperty("primaryImage")
    private String poster;
    @JsonProperty("averageRating")
    private Double imdbRating;


    public FilmApiDto(Long id, String title, String originalTitle,
                      String shortDescription, String description,
                      String youtubeTrailerId, Integer releaseYear,
                      List<String> genres, boolean promoted,
                      String poster, Double imdbRating) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.shortDescription = shortDescription;
        this.description = description;
        this.youtubeTrailerId = youtubeTrailerId;
        this.releaseYear = releaseYear;
        this.genres = genres;
        this.promoted = promoted;
        this.poster = poster;
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

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }
}

