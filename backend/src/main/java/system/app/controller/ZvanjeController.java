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

import system.app.dto.ZvanjeDTO;
import system.app.model.Drzava;
import system.app.model.Zvanje;
import system.app.service.ZvanjeService;

@Controller
@RequestMapping(path = "/api/zvanje")
@CrossOrigin
public class ZvanjeController {
	@Autowired
	private ZvanjeService zvanjeService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<ZvanjeDTO>> getAll() {
		List<ZvanjeDTO> zvanje = new ArrayList<ZvanjeDTO>();
		for(Zvanje f: zvanjeService.findAll()) {
			zvanje.add(new ZvanjeDTO(f));
		}
		return new ResponseEntity<Iterable<ZvanjeDTO>>(zvanje, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@Secured({"ROLE_ADMIN","ROLE_NASTAVNIK"})
	public ResponseEntity<ZvanjeDTO> getOne(@PathVariable("id") Long id) {
		Zvanje zvanje = zvanjeService.findOne(id);
		ZvanjeDTO zvanjeDTO = new ZvanjeDTO(zvanje);
		if (zvanjeDTO != null) {
			return new ResponseEntity<ZvanjeDTO>(zvanjeDTO, HttpStatus.OK);
		}
		return new ResponseEntity<ZvanjeDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Zvanje> create(@RequestBody Zvanje newZvanje) {
		if (zvanjeService.findOne(newZvanje.getId()) != null) {
			return new ResponseEntity<Zvanje>(HttpStatus.CONFLICT);
		}
		zvanjeService.save(newZvanje);
		return new ResponseEntity<Zvanje>(newZvanje, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Zvanje> updateZvanje(@PathVariable("id") Long id,
			@RequestBody Zvanje editedZvanje) {
		Zvanje zvanje = zvanjeService.findOne(id);
		if (zvanje == null) {
			return new ResponseEntity<Zvanje>(HttpStatus.NOT_FOUND);
		}
		zvanje.setDatumIzbora(editedZvanje.getDatumIzbora());
		zvanje.setDatumPrestanka(editedZvanje.getDatumPrestanka());
		zvanje.setTipZvanja(editedZvanje.getTipZvanja());
		zvanje.setNaucnaOblast(editedZvanje.getNaucnaOblast());
		zvanje.setNastavnici(editedZvanje.getNastavnici());
		zvanjeService.save(zvanje);
		return new ResponseEntity<Zvanje>(zvanje, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (zvanjeService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		zvanjeService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

