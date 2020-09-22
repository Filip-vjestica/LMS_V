package system.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.Fakultet;
import system.app.repository.FakultetRepository;

@Service
public class FakultetService {
	@Autowired
	FakultetRepository fakultetRepository;

	public FakultetService() {
		super();
	}
	
	public Iterable<Fakultet> findAll(){
		return fakultetRepository.findAll();
	}
	
	public Fakultet findOne(Long id) {
		return fakultetRepository.findById(id).orElse(null);
	}
	
	public void remove(Long id) {
		fakultetRepository.deleteById(id);
	}
	
	public Fakultet save(Fakultet fakultet) {
		return fakultetRepository.save(fakultet);
	}
}
