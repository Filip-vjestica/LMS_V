package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.NaucnaOblast;

@Repository
public interface NaucnaOblastRepository extends PagingAndSortingRepository<NaucnaOblast, Long> {

}
