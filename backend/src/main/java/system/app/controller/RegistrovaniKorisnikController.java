package system.app.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import system.app.dto.UserRegistrovaniKorisnikDTO;
import system.app.dto.AdminRegistrovaniKorisnikDTO;
import system.app.dto.TabelaRegistrovaniKorisnikDTO;
import system.app.model.Drzava;
import system.app.model.RegistrovaniKorisnik;
import system.app.service.RegistrovaniKorisnikService;

@Controller
@RequestMapping(path = "/api/registrovaniKorisnik")
@CrossOrigin
public class RegistrovaniKorisnikController {
	@Autowired
	private RegistrovaniKorisnikService registrovaniKorisnikService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<TabelaRegistrovaniKorisnikDTO>> getAll() {
		List<TabelaRegistrovaniKorisnikDTO> registrovaniKorisnik = new ArrayList<TabelaRegistrovaniKorisnikDTO>();
		for(RegistrovaniKorisnik f: registrovaniKorisnikService.findAll()) {
			registrovaniKorisnik.add(new TabelaRegistrovaniKorisnikDTO(f));
		}
		return new ResponseEntity<Iterable<TabelaRegistrovaniKorisnikDTO>>(registrovaniKorisnik, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
	@Secured({"ROLE_ADMIN","ROLE_USER","ROLE_NASTAVNIK","ROLE_ADMINISTRATIVNO_OSOBLJE"})
	public ResponseEntity<UserRegistrovaniKorisnikDTO> userGetOne(@PathVariable("id") Long id) {
		RegistrovaniKorisnik registrovaniKorisnik = registrovaniKorisnikService.findOne(id);
		UserRegistrovaniKorisnikDTO registrovaniKorisnikDTO = new UserRegistrovaniKorisnikDTO(registrovaniKorisnik);
		if (registrovaniKorisnikDTO != null) {
			return new ResponseEntity<UserRegistrovaniKorisnikDTO>(registrovaniKorisnikDTO, HttpStatus.OK);
		}
		return new ResponseEntity<UserRegistrovaniKorisnikDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/admin/{id}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<AdminRegistrovaniKorisnikDTO> adminGetOne(@PathVariable("id") Long id) {
		RegistrovaniKorisnik registrovaniKorisnik = registrovaniKorisnikService.findOne(id);
		AdminRegistrovaniKorisnikDTO registrovaniKorisnikDTO = new AdminRegistrovaniKorisnikDTO(registrovaniKorisnik);
		if (registrovaniKorisnikDTO != null) {
			return new ResponseEntity<AdminRegistrovaniKorisnikDTO>(registrovaniKorisnikDTO, HttpStatus.OK);
		}
		return new ResponseEntity<AdminRegistrovaniKorisnikDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<RegistrovaniKorisnik> create(@RequestBody RegistrovaniKorisnik newRegistrovaniKorisnik) {
		if (registrovaniKorisnikService.findOne(newRegistrovaniKorisnik.getId()) != null) {
			return new ResponseEntity<RegistrovaniKorisnik>(HttpStatus.CONFLICT);
		}
		newRegistrovaniKorisnik.setPassword(passwordEncoder.encode(newRegistrovaniKorisnik.getPassword()));
		registrovaniKorisnikService.save(newRegistrovaniKorisnik);
		return new ResponseEntity<RegistrovaniKorisnik>(newRegistrovaniKorisnik, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RegistrovaniKorisnik> updateRegistrovaniKorisnik(@PathVariable("id") Long id,
			@RequestBody RegistrovaniKorisnik editedRegistrovaniKorisnik) {
		RegistrovaniKorisnik registrovaniKorisnik = registrovaniKorisnikService.findOne(id);
		if (registrovaniKorisnik == null) {
			return new ResponseEntity<RegistrovaniKorisnik>(HttpStatus.NOT_FOUND);
		}
		registrovaniKorisnik.setUsername(editedRegistrovaniKorisnik.getUsername());
		registrovaniKorisnik.setPassword(editedRegistrovaniKorisnik.getPassword());
		registrovaniKorisnik.setEmail(editedRegistrovaniKorisnik.getEmail());
		registrovaniKorisnikService.save(registrovaniKorisnik);
		return new ResponseEntity<RegistrovaniKorisnik>(registrovaniKorisnik, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (registrovaniKorisnikService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		registrovaniKorisnikService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

