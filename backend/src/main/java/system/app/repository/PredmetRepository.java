package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.Predmet;

@Repository
public interface PredmetRepository extends PagingAndSortingRepository<Predmet, Long> {

}
