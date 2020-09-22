package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.Mesto;
import system.app.repository.MestoRepository;

@Service
public class MestoService {
	@Autowired
	MestoRepository mestoRepository;

	public MestoService() {
		super();
	}
	
	public Iterable<Mesto> findAll() {
		return mestoRepository.findAll();
	}
	
	public Mesto findOne(Long id) {
		return mestoRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		mestoRepository.deleteById(id);
	}
	
	public Mesto save(Mesto mesto) {
		return mestoRepository.save(mesto);
	}
}
