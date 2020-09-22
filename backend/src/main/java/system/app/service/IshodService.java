package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.Ishod;
import system.app.repository.IshodRepository;

@Service
public class IshodService {
	@Autowired
	IshodRepository ishodRepository;

	public IshodService() {
		super();
	}
	
	public Iterable<Ishod> findAll() {
		return ishodRepository.findAll();
	}
	
	public Ishod findOne(Long id) {
		return ishodRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		ishodRepository.deleteById(id);
	}
	
	public Ishod save(Ishod ishod) {
		return ishodRepository.save(ishod);
	}
}
