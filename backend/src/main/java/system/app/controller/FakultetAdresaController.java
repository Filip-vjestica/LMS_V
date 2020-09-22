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

import system.app.dto.FakultetAdresaDTO;
import system.app.model.Drzava;
import system.app.model.FakultetAdresa;
import system.app.service.FakultetAdresaService;

@Controller
@RequestMapping(path = "/api/fakultetAdresa")
@CrossOrigin
public class FakultetAdresaController {
	@Autowired
	private FakultetAdresaService fakultetAdresaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<FakultetAdresaDTO>> getAll() {
		List<FakultetAdresaDTO> fakultetAdresa = new ArrayList<FakultetAdresaDTO>();
		for(FakultetAdresa f: fakultetAdresaService.findAll()) {
			fakultetAdresa.add(new FakultetAdresaDTO(f));
		}
		return new ResponseEntity<Iterable<FakultetAdresaDTO>>(fakultetAdresa, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<FakultetAdresaDTO> getOne(@PathVariable("id") Long id) {
		FakultetAdresa fakultetAdresa = fakultetAdresaService.findOne(id);
		FakultetAdresaDTO fakultetAdresaDTO = new FakultetAdresaDTO(fakultetAdresa);
		if (fakultetAdresaDTO != null) {
			return new ResponseEntity<FakultetAdresaDTO>(fakultetAdresaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<FakultetAdresaDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<FakultetAdresa> create(@RequestBody FakultetAdresa newFakultetAdresa) {
		if (fakultetAdresaService.findOne(newFakultetAdresa.getId()) != null) {
			return new ResponseEntity<FakultetAdresa>(HttpStatus.CONFLICT);
		}
		fakultetAdresaService.save(newFakultetAdresa);
		return new ResponseEntity<FakultetAdresa>(newFakultetAdresa, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<FakultetAdresa> updateFakultetAdresa(@PathVariable("id") Long id,
			@RequestBody FakultetAdresa editedFakultetAdresa) {
		FakultetAdresa fakultetAdresa = fakultetAdresaService.findOne(id);
		if (fakultetAdresa == null) {
			return new ResponseEntity<FakultetAdresa>(HttpStatus.NOT_FOUND);
		}
		fakultetAdresa.setAdresa(editedFakultetAdresa.getAdresa());
		fakultetAdresa.setFakultet(editedFakultetAdresa.getFakultet());
		fakultetAdresaService.save(fakultetAdresa);
		return new ResponseEntity<FakultetAdresa>(fakultetAdresa, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (fakultetAdresaService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		fakultetAdresaService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

