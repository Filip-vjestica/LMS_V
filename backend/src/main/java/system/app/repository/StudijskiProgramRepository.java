package system.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import system.app.model.StudijskiProgram;

@Repository
public interface StudijskiProgramRepository extends PagingAndSortingRepository<StudijskiProgram, Long>{

}
