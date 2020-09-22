package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.Adresa;

@Repository
public interface AdresaRepository extends PagingAndSortingRepository<Adresa, Long> {

}
