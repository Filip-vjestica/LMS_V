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

import system.app.dto.NaucnaOblastDTO;
import system.app.model.Drzava;
import system.app.model.NaucnaOblast;
import system.app.service.NaucnaOblastService;

@Controller
@RequestMapping(path = "/api/naucnaOblast")
@CrossOrigin
public class NaucnaOblastController {
	@Autowired
	private NaucnaOblastService naucnaOblastService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<NaucnaOblastDTO>> getAll() {
		List<NaucnaOblastDTO> naucnaOblast = new ArrayList<NaucnaOblastDTO>();
		for(NaucnaOblast f: naucnaOblastService.findAll()) {
			naucnaOblast.add(new NaucnaOblastDTO(f));
		}
		return new ResponseEntity<Iterable<NaucnaOblastDTO>>(naucnaOblast, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@Secured({"ROLE_ADMIN","ROLE_NASTAVNIK"})
	public ResponseEntity<NaucnaOblastDTO> getOne(@PathVariable("id") Long id) {
		NaucnaOblast naucnaOblast = naucnaOblastService.findOne(id);
		NaucnaOblastDTO naucnaOblastDTO = new NaucnaOblastDTO(naucnaOblast);
		if (naucnaOblastDTO != null) {
			return new ResponseEntity<NaucnaOblastDTO>(naucnaOblastDTO, HttpStatus.OK);
		}
		return new ResponseEntity<NaucnaOblastDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<NaucnaOblast> create(@RequestBody NaucnaOblast newNaucnaOblast) {
		if (naucnaOblastService.findOne(newNaucnaOblast.getId()) != null) {
			return new ResponseEntity<NaucnaOblast>(HttpStatus.CONFLICT);
		}
		naucnaOblastService.save(newNaucnaOblast);
		return new ResponseEntity<NaucnaOblast>(newNaucnaOblast, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<NaucnaOblast> updateNaucnaOblast(@PathVariable("id") Long id,
			@RequestBody NaucnaOblast editedNaucnaOblast) {
		NaucnaOblast naucnaOblast = naucnaOblastService.findOne(id);
		if (naucnaOblast == null) {
			return new ResponseEntity<NaucnaOblast>(HttpStatus.NOT_FOUND);
		}
		editedNaucnaOblast.setNaziv(editedNaucnaOblast.getNaziv());
		editedNaucnaOblast.setZvanja(editedNaucnaOblast.getZvanja());
		naucnaOblastService.save(naucnaOblast);
		return new ResponseEntity<NaucnaOblast>(naucnaOblast, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (naucnaOblastService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		naucnaOblastService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

