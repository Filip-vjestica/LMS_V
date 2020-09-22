package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.TipZvanja;

@Repository
public interface TipZvanjaRepository extends PagingAndSortingRepository<TipZvanja, Long>{

}
