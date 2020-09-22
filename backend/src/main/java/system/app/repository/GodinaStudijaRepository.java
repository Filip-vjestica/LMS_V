package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.GodinaStudija;

@Repository
public interface GodinaStudijaRepository extends PagingAndSortingRepository<GodinaStudija, Long> {

}
