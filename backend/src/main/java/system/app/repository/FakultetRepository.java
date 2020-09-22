package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.Fakultet;

@Repository
public interface FakultetRepository extends PagingAndSortingRepository<Fakultet, Long> {

}
