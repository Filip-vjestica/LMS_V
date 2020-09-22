package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.RegistrovaniKorisnik;

@Repository
public interface RegistrovaniKorisnikRepository extends  PagingAndSortingRepository<RegistrovaniKorisnik, Long> {

}