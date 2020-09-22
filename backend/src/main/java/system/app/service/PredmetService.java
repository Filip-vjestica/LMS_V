package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.Predmet;
import system.app.repository.PredmetRepository;

@Service
public class PredmetService {
	@Autowired
	PredmetRepository predmetRepository;

	public PredmetService() {
		super();
	}
	
	public Iterable<Predmet> findAll() {
		return predmetRepository.findAll();
	}
	
	public Predmet findOne(Long id) {
		return predmetRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		predmetRepository.deleteById(id);
	}
	
	public Predmet save(Predmet predmet) {
		return predmetRepository.save(predmet);
	}
}
