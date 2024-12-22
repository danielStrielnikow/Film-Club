package pl.danielstrielnikow.filmclub.domain.film;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends CrudRepository<Film, Long> {
    List<Film> findAllByPromotedIsTrue();
    List<Film> findAllByGenre_NameIgnoreCase(String name);
    @Query("select m from Film m join m.ratings r group by m order by avg(r.rating) desc")
    List<Film> findTopByRating(Pageable page);
    Optional<Film> findByTitleIgnoreCase(String title);

}
