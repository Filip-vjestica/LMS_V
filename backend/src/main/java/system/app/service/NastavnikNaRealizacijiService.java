package system.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.NastavnikNaRealizaciji;
import system.app.repository.NastavnikNaRealizacijiRepository;

@Service
public class NastavnikNaRealizacijiService {
	@Autowired
	NastavnikNaRealizacijiRepository nastavnikNaRealizacijiRepository;

	public NastavnikNaRealizacijiService() {
		super();
	}
	
	public Iterable<NastavnikNaRealizaciji> findAll() {
		return nastavnikNaRealizacijiRepository.findAll();
	}
	
	public NastavnikNaRealizaciji findOne(Long id) {
		return nastavnikNaRealizacijiRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		nastavnikNaRealizacijiRepository.deleteById(id);
	}
	
	public NastavnikNaRealizaciji save(NastavnikNaRealizaciji nastavnikNaRealizaciji) {
		return nastavnikNaRealizacijiRepository.save(nastavnikNaRealizaciji);
	}
}

