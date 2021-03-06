package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.RegistrovaniKorisnikAdresa;

@Repository
public interface RegistrovaniKorisnikAdresaRepository extends PagingAndSortingRepository<RegistrovaniKorisnikAdresa, Long> {

}
