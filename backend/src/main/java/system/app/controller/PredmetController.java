package system.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import system.app.dto.PredmetDTO;
import system.app.dto.TabelaPredmetDTO;
import system.app.model.Drzava;
import system.app.model.Predmet;
import system.app.service.PredmetService;

@Controller
@RequestMapping(path = "/api/predmet")
@CrossOrigin
public class PredmetController {
	@Autowired
	private PredmetService predmetService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<TabelaPredmetDTO>> getAll() {
		List<TabelaPredmetDTO> predmet = new ArrayList<TabelaPredmetDTO>();
		for(Predmet f: predmetService.findAll()) {
			predmet.add(new TabelaPredmetDTO(f));
		}
		return new ResponseEntity<Iterable<TabelaPredmetDTO>>(predmet, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PredmetDTO> getOne(@PathVariable("id") Long id) {
		Predmet predmet = predmetService.findOne(id);
		PredmetDTO predmetDTO = new PredmetDTO(predmet);
		if (predmetDTO != null) {
			return new ResponseEntity<PredmetDTO>(predmetDTO, HttpStatus.OK);
		}
		return new ResponseEntity<PredmetDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Predmet> create(@RequestBody Predmet newPredmet) {
		if (predmetService.findOne(newPredmet.getId()) != null) {
			return new ResponseEntity<Predmet>(HttpStatus.CONFLICT);
		}
		predmetService.save(newPredmet);
		return new ResponseEntity<Predmet>(newPredmet, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Predmet> updatePredmet(@PathVariable("id") Long id,
			@RequestBody Predmet editedPredmet) {
		Predmet predmet = predmetService.findOne(id);
		if (predmet == null) {
			return new ResponseEntity<Predmet>(HttpStatus.NOT_FOUND);
		}
		predmet.setNaziv(editedPredmet.getNaziv());
		predmet.setEspb(editedPredmet.getEspb());
		predmet.setObavezan(editedPredmet.getObavezan());
		predmet.setBrojPredavanja(editedPredmet.getBrojPredavanja());
		predmet.setBrojVezbi(editedPredmet.getBrojVezbi());
		predmet.setBrojSemestara(editedPredmet.getBrojSemestara());
		predmet.setDrugiObliciNastave(editedPredmet.getDrugiObliciNastave());
		predmet.setIstrazivackiRad(editedPredmet.getIstrazivackiRad());
		predmet.setOstaliCasovi(editedPredmet.getOstaliCasovi());
		predmet.setGodinaStudija(editedPredmet.getGodinaStudija());
		predmet.setIshodi(editedPredmet.getIshodi());
		predmetService.save(predmet);
		return new ResponseEntity<Predmet>(predmet, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (predmetService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		predmetService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

