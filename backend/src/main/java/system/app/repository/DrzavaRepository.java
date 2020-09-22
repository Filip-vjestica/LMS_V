package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.Drzava;

@Repository
public interface DrzavaRepository extends PagingAndSortingRepository<Drzava, Long> {

}
