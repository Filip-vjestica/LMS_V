package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.Univerzitet;

@Repository
public interface UniverzitetRepository extends PagingAndSortingRepository<Univerzitet, Long> {

}
