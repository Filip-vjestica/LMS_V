package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.Drzava;
import system.app.repository.DrzavaRepository;

@Service
public class DrzavaService {
	@Autowired
	DrzavaRepository drzavaRepository;

	public DrzavaService() {
		super();
	}
	
	public Iterable<Drzava> findAll() {
		return drzavaRepository.findAll();
	}
	
	public Drzava findOne(Long id) {
		return drzavaRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		drzavaRepository.deleteById(id);
	}
	
	public Drzava save(Drzava drzava) {
		return drzavaRepository.save(drzava);
	}
}
