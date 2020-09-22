package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.Univerzitet;
import system.app.repository.UniverzitetRepository;

@Service
public class UniverzitetService {
	@Autowired
	UniverzitetRepository univerzitetRepository;

	public UniverzitetService() {
		super();
	}
	
	public Iterable<Univerzitet> findAll() {
		return univerzitetRepository.findAll();
	}
	
	public Univerzitet findOne(Long id) {
		return univerzitetRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		univerzitetRepository.deleteById(id);
	}
	
	public Univerzitet save(Univerzitet univerzitet) {
		return univerzitetRepository.save(univerzitet);
	}
}
