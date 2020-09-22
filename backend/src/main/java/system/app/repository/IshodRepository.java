package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.Ishod;

@Repository
public interface IshodRepository extends PagingAndSortingRepository<Ishod, Long> {

}
