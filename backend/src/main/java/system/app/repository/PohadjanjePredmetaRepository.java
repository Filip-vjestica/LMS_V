package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.PohadjanjePredmeta;

@Repository
public interface PohadjanjePredmetaRepository extends PagingAndSortingRepository<PohadjanjePredmeta, Long>{

}
