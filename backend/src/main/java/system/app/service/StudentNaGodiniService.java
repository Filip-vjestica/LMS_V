package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.StudentNaGodini;
import system.app.repository.StudentNaGodiniRepository;

@Service
public class StudentNaGodiniService {
	@Autowired
	StudentNaGodiniRepository studentNaGodiniRepository;

	public StudentNaGodiniService() {
		super();
	}
	
	public Iterable<StudentNaGodini> findAll() {
		return studentNaGodiniRepository.findAll();
	}
	
	public StudentNaGodini findOne(Long id) {
		return studentNaGodiniRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		studentNaGodiniRepository.deleteById(id);
	}
	
	public StudentNaGodini save(StudentNaGodini studentNaGodini) {
		return studentNaGodiniRepository.save(studentNaGodini);
	}
}
