package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.RealizacijaPredmeta;
import system.app.repository.RealizacijaPredmetaRepository;

@Service
public class RealizacijaPredmetaService {
	@Autowired
	RealizacijaPredmetaRepository realizacijaPredmetaRepository;

	public RealizacijaPredmetaService() {
		super();
	}
	
	public Iterable<RealizacijaPredmeta> findAll() {
		return realizacijaPredmetaRepository.findAll();
	}
	
	public RealizacijaPredmeta findOne(Long id) {
		return realizacijaPredmetaRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		realizacijaPredmetaRepository.deleteById(id);
	}
	
	public RealizacijaPredmeta save(RealizacijaPredmeta realizacijaPredmeta) {
		return realizacijaPredmetaRepository.save(realizacijaPredmeta);
	}
}
