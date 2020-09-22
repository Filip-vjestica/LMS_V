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

import system.app.dto.RealizacijaPredmetaDTO;
import system.app.model.Drzava;
import system.app.model.RealizacijaPredmeta;
import system.app.service.RealizacijaPredmetaService;

@Controller
@RequestMapping(path = "/api/realizacijaPredmeta")
@CrossOrigin
public class RealizacijaPredmetaController {
	@Autowired
	private RealizacijaPredmetaService realizacijaPredmetaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<RealizacijaPredmetaDTO>> getAll() {
		List<RealizacijaPredmetaDTO> realizacijaPredmeta = new ArrayList<RealizacijaPredmetaDTO>();
		for(RealizacijaPredmeta f: realizacijaPredmetaService.findAll()) {
			realizacijaPredmeta.add(new RealizacijaPredmetaDTO(f));
		}
		return new ResponseEntity<Iterable<RealizacijaPredmetaDTO>>(realizacijaPredmeta, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RealizacijaPredmetaDTO> getOne(@PathVariable("id") Long id) {
		RealizacijaPredmeta realizacijaPredmeta = realizacijaPredmetaService.findOne(id);
		RealizacijaPredmetaDTO realizacijaPredmetaDTO = new RealizacijaPredmetaDTO(realizacijaPredmeta);
		if (realizacijaPredmetaDTO != null) {
			return new ResponseEntity<RealizacijaPredmetaDTO>(realizacijaPredmetaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<RealizacijaPredmetaDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<RealizacijaPredmeta> create(@RequestBody RealizacijaPredmeta newRealizacijaPredmeta) {
		if (realizacijaPredmetaService.findOne(newRealizacijaPredmeta.getId()) != null) {
			return new ResponseEntity<RealizacijaPredmeta>(HttpStatus.CONFLICT);
		}
		realizacijaPredmetaService.save(newRealizacijaPredmeta);
		return new ResponseEntity<RealizacijaPredmeta>(newRealizacijaPredmeta, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RealizacijaPredmeta> updateRealizacijaPredmeta(@PathVariable("id") Long id,
			@RequestBody RealizacijaPredmeta editedRealizacijaPredmeta) {
		RealizacijaPredmeta realizacijaPredmeta = realizacijaPredmetaService.findOne(id);
		if (realizacijaPredmeta == null) {
			return new ResponseEntity<RealizacijaPredmeta>(HttpStatus.NOT_FOUND);
		}
		realizacijaPredmeta.setPredmet(editedRealizacijaPredmeta.getPredmet());
		realizacijaPredmeta.setPohadjanjaPredmeta(editedRealizacijaPredmeta.getPohadjanjaPredmeta());
		realizacijaPredmetaService.save(realizacijaPredmeta);
		return new ResponseEntity<RealizacijaPredmeta>(realizacijaPredmeta, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (realizacijaPredmetaService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		realizacijaPredmetaService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

