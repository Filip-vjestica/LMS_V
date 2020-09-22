package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.FakultetAdresa;
import system.app.repository.FakultetAdresaRepository;

@Service
public class FakultetAdresaService {
	@Autowired
	FakultetAdresaRepository fakultetAdresaRepository;

	public FakultetAdresaService() {
		super();
	}
	
	public Iterable<FakultetAdresa> findAll() {
		return fakultetAdresaRepository.findAll();
	}
	
	public FakultetAdresa findOne(Long id) {
		return fakultetAdresaRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		fakultetAdresaRepository.deleteById(id);
	}
	
	public FakultetAdresa save(FakultetAdresa fakultetAdresa) {
		return fakultetAdresaRepository.save(fakultetAdresa);
	}
}
