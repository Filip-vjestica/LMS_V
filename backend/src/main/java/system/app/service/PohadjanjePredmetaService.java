package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.PohadjanjePredmeta;
import system.app.repository.PohadjanjePredmetaRepository;

@Service
public class PohadjanjePredmetaService {
	@Autowired
	PohadjanjePredmetaRepository pohadjanjePredmetaRepository;

	public PohadjanjePredmetaService() {
		super();
	}
	
	public Iterable<PohadjanjePredmeta> findAll() {
		return pohadjanjePredmetaRepository.findAll();
	}
	
	public PohadjanjePredmeta findOne(Long id) {
		return pohadjanjePredmetaRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		pohadjanjePredmetaRepository.deleteById(id);
	}
	
	public PohadjanjePredmeta save(PohadjanjePredmeta pohadjanjePredmeta) {
		return pohadjanjePredmetaRepository.save(pohadjanjePredmeta);
	}
}
