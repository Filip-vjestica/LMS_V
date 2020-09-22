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

import system.app.dto.RegistrovaniKorisnikAdresaDTO;
import system.app.model.Drzava;
import system.app.model.RegistrovaniKorisnikAdresa;
import system.app.service.RegistrovaniKorisnikAdresaService;

@Controller
@RequestMapping(path = "/api/registrovaniKorisnikAdresa")
@CrossOrigin
public class RegistrovaniKorisnikAdresaController {
	@Autowired
	private RegistrovaniKorisnikAdresaService registrovaniKorisnikAdresaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured({"ROLE_ADMIN","ROLE_NASTAVNIK","ROLE_ADMINISTRATIVNO_OSOBLJE"})
	public ResponseEntity<Iterable<RegistrovaniKorisnikAdresaDTO>> getAll() {
		List<RegistrovaniKorisnikAdresaDTO> registrovaniKorisnikAdresa = new ArrayList<RegistrovaniKorisnikAdresaDTO>();
		for(RegistrovaniKorisnikAdresa f: registrovaniKorisnikAdresaService.findAll()) {
			registrovaniKorisnikAdresa.add(new RegistrovaniKorisnikAdresaDTO(f));
		}
		return new ResponseEntity<Iterable<RegistrovaniKorisnikAdresaDTO>>(registrovaniKorisnikAdresa, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@Secured({"ROLE_ADMIN","ROLE_NASTAVNIK","ROLE_ADMINISTRATIVNO_OSOBLJE"})
	public ResponseEntity<RegistrovaniKorisnikAdresaDTO> getOne(@PathVariable("id") Long id) {
		RegistrovaniKorisnikAdresa registrovaniKorisnikAdresa = registrovaniKorisnikAdresaService.findOne(id);
		RegistrovaniKorisnikAdresaDTO registrovaniKorisnikAdresaDTO = new RegistrovaniKorisnikAdresaDTO(registrovaniKorisnikAdresa);
		if (registrovaniKorisnikAdresaDTO != null) {
			return new ResponseEntity<RegistrovaniKorisnikAdresaDTO>(registrovaniKorisnikAdresaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<RegistrovaniKorisnikAdresaDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<RegistrovaniKorisnikAdresa> create(@RequestBody RegistrovaniKorisnikAdresa newRegistrovaniKorisnikAdresa) {
		if (registrovaniKorisnikAdresaService.findOne(newRegistrovaniKorisnikAdresa.getId()) != null) {
			return new ResponseEntity<RegistrovaniKorisnikAdresa>(HttpStatus.CONFLICT);
		}
		registrovaniKorisnikAdresaService.save(newRegistrovaniKorisnikAdresa);
		return new ResponseEntity<RegistrovaniKorisnikAdresa>(newRegistrovaniKorisnikAdresa, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RegistrovaniKorisnikAdresa> updateRegistrovaniKorisnikAdresa(@PathVariable("id") Long id,
			@RequestBody RegistrovaniKorisnikAdresa editedRegistrovaniKorisnikAdresa) {
		RegistrovaniKorisnikAdresa registrovaniKorisnikAdresa = registrovaniKorisnikAdresaService.findOne(id);
		if (registrovaniKorisnikAdresa == null) {
			return new ResponseEntity<RegistrovaniKorisnikAdresa>(HttpStatus.NOT_FOUND);
		}
		registrovaniKorisnikAdresa.setAdresa(editedRegistrovaniKorisnikAdresa.getAdresa());
		registrovaniKorisnikAdresa.setRegistrovaniKorisnik(editedRegistrovaniKorisnikAdresa.getRegistrovaniKorisnik());
		registrovaniKorisnikAdresaService.save(registrovaniKorisnikAdresa);
		return new ResponseEntity<RegistrovaniKorisnikAdresa>(registrovaniKorisnikAdresa, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (registrovaniKorisnikAdresaService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		registrovaniKorisnikAdresaService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

