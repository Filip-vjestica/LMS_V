package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.StudijskiProgram;
import system.app.repository.StudijskiProgramRepository;

@Service
public class StudijskiProgramService {
	@Autowired
	StudijskiProgramRepository studijskiProgramRepository;

	public StudijskiProgramService() {
		super();
	}
	
	public Iterable<StudijskiProgram> findAll() {
		return studijskiProgramRepository.findAll();
	}
	
	public StudijskiProgram findOne(Long id) {
		return studijskiProgramRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		studijskiProgramRepository.deleteById(id);
	}
	
	public StudijskiProgram save(StudijskiProgram studijskiProgram) {
		return studijskiProgramRepository.save(studijskiProgram);
	}
}
