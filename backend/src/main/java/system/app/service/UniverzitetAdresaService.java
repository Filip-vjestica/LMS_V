package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.UniverzitetAdresa;
import system.app.repository.UniverzitetAdresaRepository;

@Service
public class UniverzitetAdresaService {
	@Autowired
	UniverzitetAdresaRepository univerzitetAdresaRepository;

	public UniverzitetAdresaService() {
		super();
	}
	
	public Iterable<UniverzitetAdresa> findAll() {
		return univerzitetAdresaRepository.findAll();
	}
	
	public UniverzitetAdresa findOne(Long id) {
		return univerzitetAdresaRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		univerzitetAdresaRepository.deleteById(id);
	}
	
	public UniverzitetAdresa save(UniverzitetAdresa univerzitetAdresa) {
		return univerzitetAdresaRepository.save(univerzitetAdresa);
	}
}
