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

import system.app.dto.IshodDTO;
import system.app.dto.TabelaIshodDTO;
import system.app.model.Drzava;
import system.app.model.Ishod;
import system.app.service.IshodService;

@Controller
@RequestMapping(path = "/api/ishod")
@CrossOrigin
public class IshodController {
	@Autowired
	private IshodService ishodService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<TabelaIshodDTO>> getAll() {
		List<TabelaIshodDTO> ishod = new ArrayList<TabelaIshodDTO>();
		for(Ishod f: ishodService.findAll()) {
			ishod.add(new TabelaIshodDTO(f));
		}
		return new ResponseEntity<Iterable<TabelaIshodDTO>>(ishod, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<IshodDTO> getOne(@PathVariable("id") Long id) {
		Ishod ishod = ishodService.findOne(id);
		IshodDTO ishodDTO = new IshodDTO(ishod);
		if (ishodDTO != null) {
			return new ResponseEntity<IshodDTO>(ishodDTO, HttpStatus.OK);
		}
		return new ResponseEntity<IshodDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured({"ROLE_ADMIN","ROLE_NASTAVNIK"})
	public ResponseEntity<Ishod> create(@RequestBody Ishod newIshod) {
		if (ishodService.findOne(newIshod.getId()) != null) {
			return new ResponseEntity<Ishod>(HttpStatus.CONFLICT);
		}
		ishodService.save(newIshod);
		return new ResponseEntity<Ishod>(newIshod, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Ishod> updateIshod(@PathVariable("id") Long id,
			@RequestBody Ishod editedIshod) {
		Ishod ishod = ishodService.findOne(id);
		if (ishod == null) {
			return new ResponseEntity<Ishod>(HttpStatus.NOT_FOUND);
		}
		ishod.setDatum(editedIshod.getDatum());
		ishod.setNaslov(editedIshod.getNaslov());
		ishod.setOpis(editedIshod.getOpis());
		ishod.setPredmet(editedIshod.getPredmet());
		ishodService.save(ishod);
		return new ResponseEntity<Ishod>(ishod, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured({"ROLE_ADMIN","ROLE_NASTAVNIK"})
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (ishodService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		ishodService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

