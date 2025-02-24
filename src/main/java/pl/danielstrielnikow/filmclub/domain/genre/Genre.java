package pl.danielstrielnikow.filmclub.domain.genre;

import jakarta.persistence.*;
import pl.danielstrielnikow.filmclub.domain.film.Film;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<Film> films = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public Genre() {
    }

    public Genre(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}