package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.RegistrovaniKorisnikAdresa;
import system.app.repository.RegistrovaniKorisnikAdresaRepository;

@Service
public class RegistrovaniKorisnikAdresaService {
	@Autowired
	RegistrovaniKorisnikAdresaRepository registrovaniKorisnikAdresaRepository;

	public RegistrovaniKorisnikAdresaService() {
		super();
	}
	
	public Iterable<RegistrovaniKorisnikAdresa> findAll() {
		return registrovaniKorisnikAdresaRepository.findAll();
	}
	
	public RegistrovaniKorisnikAdresa findOne(Long id) {
		return registrovaniKorisnikAdresaRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		registrovaniKorisnikAdresaRepository.deleteById(id);
	}
	
	public RegistrovaniKorisnikAdresa save(RegistrovaniKorisnikAdresa registrovaniKorisnikAdresa) {
		return registrovaniKorisnikAdresaRepository.save(registrovaniKorisnikAdresa);
	}
}
