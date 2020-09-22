package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.UniverzitetAdresa;

@Repository
public interface UniverzitetAdresaRepository extends PagingAndSortingRepository<UniverzitetAdresa, Long> {

}
