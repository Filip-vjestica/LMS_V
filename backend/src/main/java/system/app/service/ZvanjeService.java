package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.Zvanje;
import system.app.repository.ZvanjeRepository;

@Service
public class ZvanjeService {
	@Autowired
	ZvanjeRepository zvanjeRepository;

	public ZvanjeService() {
		super();
	}
	
	public Iterable<Zvanje> findAll() {
		return zvanjeRepository.findAll();
	}
	
	public Zvanje findOne(Long id) {
		return zvanjeRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		zvanjeRepository.deleteById(id);
	}
	
	public Zvanje save(Zvanje zvanje) {
		return zvanjeRepository.save(zvanje);
	}
}
