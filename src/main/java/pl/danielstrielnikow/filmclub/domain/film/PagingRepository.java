package pl.danielstrielnikow.filmclub.domain.film;

import org.springframework.data.repository.PagingAndSortingRepository;

interface PagingRepository extends PagingAndSortingRepository<Film, Long> {
}
