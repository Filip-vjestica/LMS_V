package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.NaucnaOblast;
import system.app.repository.NaucnaOblastRepository;

@Service
public class NaucnaOblastService {
	@Autowired
	NaucnaOblastRepository naucnaOblastRepository;

	public NaucnaOblastService() {
		super();
	}
	
	public Iterable<NaucnaOblast> findAll() {
		return naucnaOblastRepository.findAll();
	}
	
	public NaucnaOblast findOne(Long id) {
		return naucnaOblastRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		naucnaOblastRepository.deleteById(id);
	}
	
	public NaucnaOblast save(NaucnaOblast naucnaOblast) {
		return naucnaOblastRepository.save(naucnaOblast);
	}
}
