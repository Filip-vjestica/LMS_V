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

import system.app.dto.GodinaStudijaDTO;
import system.app.model.Drzava;
import system.app.model.GodinaStudija;
import system.app.service.GodinaStudijaService;

@Controller
@RequestMapping(path = "/api/godinaStudija")
@CrossOrigin
public class GodinaStudijaController {
	@Autowired
	private GodinaStudijaService godinaStudijaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<GodinaStudijaDTO>> getAll() {
		List<GodinaStudijaDTO> godinaStudija = new ArrayList<GodinaStudijaDTO>();
		for(GodinaStudija f: godinaStudijaService.findAll()) {
			godinaStudija.add(new GodinaStudijaDTO(f));
		}
		return new ResponseEntity<Iterable<GodinaStudijaDTO>>(godinaStudija, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<GodinaStudijaDTO> getOne(@PathVariable("id") Long id) {
		GodinaStudija godinaStudija = godinaStudijaService.findOne(id);
		GodinaStudijaDTO godinaStudijaDTO = new GodinaStudijaDTO(godinaStudija);
		if (godinaStudijaDTO != null) {
			return new ResponseEntity<GodinaStudijaDTO>(godinaStudijaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<GodinaStudijaDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<GodinaStudija> create(@RequestBody GodinaStudija newGodinaStudija) {
		if (godinaStudijaService.findOne(newGodinaStudija.getId()) != null) {
			return new ResponseEntity<GodinaStudija>(HttpStatus.CONFLICT);
		}
		godinaStudijaService.save(newGodinaStudija);
		return new ResponseEntity<GodinaStudija>(newGodinaStudija, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<GodinaStudija> updateGodinaStudija(@PathVariable("id") Long id,
			@RequestBody GodinaStudija editedGodinaStudija) {
		GodinaStudija godinaStudija = godinaStudijaService.findOne(id);
		if (godinaStudija == null) {
			return new ResponseEntity<GodinaStudija>(HttpStatus.NOT_FOUND);
		}
		godinaStudija.setNaziv(editedGodinaStudija.getNaziv());
		godinaStudija.setStudijskiProgram(editedGodinaStudija.getStudijskiProgram());
		godinaStudija.setStudentiNaGodini(editedGodinaStudija.getStudentiNaGodini());
		godinaStudija.setPredmeti(editedGodinaStudija.getPredmeti());
		godinaStudijaService.save(godinaStudija);
		return new ResponseEntity<GodinaStudija>(godinaStudija, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (godinaStudijaService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		godinaStudijaService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

