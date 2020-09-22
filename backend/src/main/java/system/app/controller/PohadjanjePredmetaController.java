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

import system.app.dto.PohadjanjePredmetaDTO;
import system.app.model.Drzava;
import system.app.model.PohadjanjePredmeta;
import system.app.service.PohadjanjePredmetaService;

@Controller
@RequestMapping(path = "/api/pohadjanjePredmeta")
@CrossOrigin
public class PohadjanjePredmetaController {
	@Autowired
	private PohadjanjePredmetaService pohadjanjePredmetaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<PohadjanjePredmetaDTO>> getAll() {
		List<PohadjanjePredmetaDTO> pohadjanjePredmeta = new ArrayList<PohadjanjePredmetaDTO>();
		for(PohadjanjePredmeta f: pohadjanjePredmetaService.findAll()) {
			pohadjanjePredmeta.add(new PohadjanjePredmetaDTO(f));
		}
		return new ResponseEntity<Iterable<PohadjanjePredmetaDTO>>(pohadjanjePredmeta, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PohadjanjePredmetaDTO> getOne(@PathVariable("id") Long id) {
		PohadjanjePredmeta pohadjanjePredmeta = pohadjanjePredmetaService.findOne(id);
		PohadjanjePredmetaDTO pohadjanjePredmetaDTO = new PohadjanjePredmetaDTO(pohadjanjePredmeta);
		if (pohadjanjePredmetaDTO != null) {
			return new ResponseEntity<PohadjanjePredmetaDTO>(pohadjanjePredmetaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<PohadjanjePredmetaDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<PohadjanjePredmeta> create(@RequestBody PohadjanjePredmeta newPohadjanjePredmeta) {
		if (pohadjanjePredmetaService.findOne(newPohadjanjePredmeta.getId()) != null) {
			return new ResponseEntity<PohadjanjePredmeta>(HttpStatus.CONFLICT);
		}
		pohadjanjePredmetaService.save(newPohadjanjePredmeta);
		return new ResponseEntity<PohadjanjePredmeta>(newPohadjanjePredmeta, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PohadjanjePredmeta> updatePohadjanjePredmeta(@PathVariable("id") Long id,
			@RequestBody PohadjanjePredmeta editedPohadjanjePredmeta) {
		PohadjanjePredmeta pohadjanjePredmeta = pohadjanjePredmetaService.findOne(id);
		if (pohadjanjePredmeta == null) {
			return new ResponseEntity<PohadjanjePredmeta>(HttpStatus.NOT_FOUND);
		}
		pohadjanjePredmeta.setKonacnaOcena(editedPohadjanjePredmeta.getKonacnaOcena());
		pohadjanjePredmeta.setRealizacijaPredmeta(editedPohadjanjePredmeta.getRealizacijaPredmeta());
		pohadjanjePredmeta.setRegistrovaniKorisnik(editedPohadjanjePredmeta.getRegistrovaniKorisnik());
		pohadjanjePredmetaService.save(pohadjanjePredmeta);
		return new ResponseEntity<PohadjanjePredmeta>(pohadjanjePredmeta, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (pohadjanjePredmetaService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		pohadjanjePredmetaService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

