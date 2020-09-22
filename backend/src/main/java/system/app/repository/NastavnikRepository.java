package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.Nastavnik;

@Repository
public interface NastavnikRepository extends PagingAndSortingRepository<Nastavnik, Long> {

}
