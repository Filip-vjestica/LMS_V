package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.Adresa;
import system.app.repository.AdresaRepository;

@Service
public class AdresaService {
	@Autowired
	AdresaRepository adresaRepository;

	public AdresaService() {
		super();
	}
	
	public Iterable<Adresa> findAll() {
		return adresaRepository.findAll();
	}
	
	public Adresa findOne(Long id) {
		return adresaRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		adresaRepository.deleteById(id);
	}
	
	public Adresa save(Adresa adresa) {
		return adresaRepository.save(adresa);
	}
}
