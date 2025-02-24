package pl.danielstrielnikow.filmclub.domain.genre;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Optional<Genre> findByNameIgnoreCase(String name);
    Genre findByName(String name);
}
