package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.Mesto;

@Repository
public interface MestoRepository extends PagingAndSortingRepository<Mesto, Long> {

}
