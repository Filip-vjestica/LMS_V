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

import system.app.dto.DrzavaDTO;
import system.app.model.Drzava;
import system.app.service.DrzavaService;

@Controller
@RequestMapping(path = "/api/drzava")
@CrossOrigin
public class DrzavaController {
	@Autowired
	private DrzavaService drzavaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<DrzavaDTO>> getAll() {
		List<DrzavaDTO> drzava = new ArrayList<DrzavaDTO>();
		for(Drzava f: drzavaService.findAll()) {
			drzava.add(new DrzavaDTO(f));
		}
		return new ResponseEntity<Iterable<DrzavaDTO>>(drzava, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DrzavaDTO> getOne(@PathVariable("id") Long id) {
		Drzava drzava = drzavaService.findOne(id);
		DrzavaDTO drzavaDTO = new DrzavaDTO(drzava);
		if (drzavaDTO != null) {
			return new ResponseEntity<DrzavaDTO>(drzavaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<DrzavaDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Drzava> create(@RequestBody Drzava newDrzava) {
		if (drzavaService.findOne(newDrzava.getId()) != null) {
			return new ResponseEntity<Drzava>(HttpStatus.CONFLICT);
		}
		drzavaService.save(newDrzava);
		return new ResponseEntity<Drzava>(newDrzava, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Drzava> updateDrzava(@PathVariable("id") Long id,
			@RequestBody Drzava editedDrzava) {
		Drzava drzava = drzavaService.findOne(id);
		if (drzava == null) {
			return new ResponseEntity<Drzava>(HttpStatus.NOT_FOUND);
		}
		drzava.setNaziv(editedDrzava.getNaziv());
		drzava.setMesta(editedDrzava.getMesta());
		drzavaService.save(drzava);
		return new ResponseEntity<Drzava>(drzava, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (drzavaService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		drzavaService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

