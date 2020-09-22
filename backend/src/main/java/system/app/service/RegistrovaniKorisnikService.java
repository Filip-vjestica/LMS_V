package system.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import system.app.model.RegistrovaniKorisnik;
import system.app.repository.RegistrovaniKorisnikRepository;

@Service
public class RegistrovaniKorisnikService {
	@Autowired
	RegistrovaniKorisnikRepository registrovaniKorisnikRepository;

	public RegistrovaniKorisnikService() {
		super();
	}
	
	public Iterable<RegistrovaniKorisnik> findAll() {
		return registrovaniKorisnikRepository.findAll();
	}
	
	public RegistrovaniKorisnik findOne(Long id) {
		return registrovaniKorisnikRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		registrovaniKorisnikRepository.deleteById(id);
	}
	
	public RegistrovaniKorisnik save(RegistrovaniKorisnik registrovaniKorisnik) {
		return registrovaniKorisnikRepository.save(registrovaniKorisnik);
	}
}
