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

import system.app.dto.TabelaUniverzitetDTO;
import system.app.dto.UniverzitetDTO;
import system.app.model.Drzava;
import system.app.model.Univerzitet;
import system.app.service.UniverzitetService;

@Controller
@RequestMapping(path = "/api/univerzitet")
@CrossOrigin
public class UniverzitetController {
	@Autowired
	private UniverzitetService univerzitetService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<TabelaUniverzitetDTO>> getAll() {
		List<TabelaUniverzitetDTO> univerzitet = new ArrayList<TabelaUniverzitetDTO>();
		for(Univerzitet f: univerzitetService.findAll()) {
			univerzitet.add(new TabelaUniverzitetDTO(f));
		}
		return new ResponseEntity<Iterable<TabelaUniverzitetDTO>>(univerzitet, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UniverzitetDTO> getOne(@PathVariable("id") Long id) {
		Univerzitet univerzitet = univerzitetService.findOne(id);
		UniverzitetDTO univerzitetDTO = new UniverzitetDTO(univerzitet);
		if (univerzitetDTO != null) {
			return new ResponseEntity<UniverzitetDTO>(univerzitetDTO, HttpStatus.OK);
		}
		return new ResponseEntity<UniverzitetDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Univerzitet> create(@RequestBody Univerzitet newUniverzitet) {
		if (univerzitetService.findOne(newUniverzitet.getId()) != null) {
			return new ResponseEntity<Univerzitet>(HttpStatus.CONFLICT);
		}
		univerzitetService.save(newUniverzitet);
		return new ResponseEntity<Univerzitet>(newUniverzitet, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Univerzitet> updateUniverzitet(@PathVariable("id") Long id,
			@RequestBody Univerzitet editedUniverzitet) {
		Univerzitet univerzitet = univerzitetService.findOne(id);
		if (univerzitet == null) {
			return new ResponseEntity<Univerzitet>(HttpStatus.NOT_FOUND);
		}
		univerzitet.setNaziv(editedUniverzitet.getNaziv());
		univerzitet.setFakulteti(editedUniverzitet.getFakulteti());
		univerzitet.setRektor(editedUniverzitet.getRektor());
		univerzitet.setUniverzitetiAdrese(editedUniverzitet.getUniverzitetiAdrese());
		univerzitetService.save(univerzitet);
		return new ResponseEntity<Univerzitet>(univerzitet, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (univerzitetService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		univerzitetService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

