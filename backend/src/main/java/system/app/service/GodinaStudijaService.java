package system.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.GodinaStudija;
import system.app.repository.GodinaStudijaRepository;

@Service
public class GodinaStudijaService {
	@Autowired
	GodinaStudijaRepository godinaStudijaRepository;

	public GodinaStudijaService() {
		super();
	}
	
	public Iterable<GodinaStudija> findAll(){
		return godinaStudijaRepository.findAll();
	}
	
	public GodinaStudija findOne(Long id) {
		return godinaStudijaRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		godinaStudijaRepository.deleteById(id);
	}
	
	public GodinaStudija save(GodinaStudija godinaStudija) {
		return godinaStudijaRepository.save(godinaStudija);
	}
}
