package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.NastavnikNaRealizaciji;

@Repository
public interface NastavnikNaRealizacijiRepository extends PagingAndSortingRepository<NastavnikNaRealizaciji, Long> {

}
