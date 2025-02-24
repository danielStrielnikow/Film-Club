package pl.danielstrielnikow.filmclub.domain.film;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findAllByPromotedIsTrue();
    List<Film> findAllByGenres_NameIgnoreCase(String name);
    @Query("select m from Film m join m.ratings r group by m order by avg(r.rating) desc")
    List<Film> findTopByRating(Pageable page);
    Optional<Film> findByTitleIgnoreCase(String title);
}
