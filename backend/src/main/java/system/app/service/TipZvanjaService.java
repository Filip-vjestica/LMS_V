package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.TipZvanja;
import system.app.repository.TipZvanjaRepository;

@Service
public class TipZvanjaService {
	@Autowired
	TipZvanjaRepository tipZvanjaRepository;

	public TipZvanjaService() {
		super();
	}
	
	public Iterable<TipZvanja> findAll() {
		return tipZvanjaRepository.findAll();
	}
	
	public TipZvanja findOne(Long id) {
		return tipZvanjaRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		tipZvanjaRepository.deleteById(id);
	}
	
	public TipZvanja save(TipZvanja tipZvanja) {
		return tipZvanjaRepository.save(tipZvanja);
	}
}
