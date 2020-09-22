package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.RealizacijaPredmeta;

@Repository
public interface RealizacijaPredmetaRepository extends PagingAndSortingRepository<RealizacijaPredmeta, Long> {

}
