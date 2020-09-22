package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.FakultetAdresa;

@Repository
public interface FakultetAdresaRepository extends PagingAndSortingRepository<FakultetAdresa, Long> {

}
