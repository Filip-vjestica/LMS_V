package system.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.Nastavnik;
import system.app.repository.NastavnikRepository;

@Service
public class NastavnikService {
	@Autowired
	NastavnikRepository nastavnikRepository;

	public NastavnikService() {
		super();
	}
	
	public Iterable<Nastavnik> findAll(){
		return nastavnikRepository.findAll();
	}
	
	public Nastavnik findOne(Long id) {
		return nastavnikRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		nastavnikRepository.deleteById(id);
	}
	
	public Nastavnik save(Nastavnik nastavnik) {
		return nastavnikRepository.save(nastavnik);
	}
}
