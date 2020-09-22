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

import system.app.dto.UniverzitetAdresaDTO;
import system.app.model.Drzava;
import system.app.model.UniverzitetAdresa;
import system.app.service.UniverzitetAdresaService;

@Controller
@RequestMapping(path = "/api/univerzitetAdresa")
@CrossOrigin
public class UniverzitetAdresaController {
	@Autowired
	private UniverzitetAdresaService univerzitetAdresaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<UniverzitetAdresaDTO>> getAll() {
		List<UniverzitetAdresaDTO> univerzitetAdresa = new ArrayList<UniverzitetAdresaDTO>();
		for(UniverzitetAdresa f: univerzitetAdresaService.findAll()) {
			univerzitetAdresa.add(new UniverzitetAdresaDTO(f));
		}
		return new ResponseEntity<Iterable<UniverzitetAdresaDTO>>(univerzitetAdresa, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<UniverzitetAdresaDTO> getOne(@PathVariable("id") Long id) {
		UniverzitetAdresa univerzitetAdresa = univerzitetAdresaService.findOne(id);
		UniverzitetAdresaDTO univerzitetAdresaDTO = new UniverzitetAdresaDTO(univerzitetAdresa);
		if (univerzitetAdresaDTO != null) {
			return new ResponseEntity<UniverzitetAdresaDTO>(univerzitetAdresaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<UniverzitetAdresaDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<UniverzitetAdresa> create(@RequestBody UniverzitetAdresa newUniverzitetAdresa) {
		if (univerzitetAdresaService.findOne(newUniverzitetAdresa.getId()) != null) {
			return new ResponseEntity<UniverzitetAdresa>(HttpStatus.CONFLICT);
		}
		univerzitetAdresaService.save(newUniverzitetAdresa);
		return new ResponseEntity<UniverzitetAdresa>(newUniverzitetAdresa, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UniverzitetAdresa> updateUniverzitetAdresa(@PathVariable("id") Long id,
			@RequestBody UniverzitetAdresa editedUniverzitetAdresa) {
		UniverzitetAdresa univerzitetAdresa = univerzitetAdresaService.findOne(id);
		if (univerzitetAdresa == null) {
			return new ResponseEntity<UniverzitetAdresa>(HttpStatus.NOT_FOUND);
		}
		univerzitetAdresa.setAdresaId(editedUniverzitetAdresa.getAdresa());
		univerzitetAdresa.setUniverzitet(editedUniverzitetAdresa.getUniverzitet());
		univerzitetAdresaService.save(univerzitetAdresa);
		return new ResponseEntity<UniverzitetAdresa>(univerzitetAdresa, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (univerzitetAdresaService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		univerzitetAdresaService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

