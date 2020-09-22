package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.Zvanje;

@Repository
public interface ZvanjeRepository extends PagingAndSortingRepository<Zvanje, Long>{

}
