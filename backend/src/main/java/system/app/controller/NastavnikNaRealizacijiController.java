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

import system.app.dto.NastavnikNaRealizacijiDTO;
import system.app.model.Drzava;
import system.app.model.NastavnikNaRealizaciji;
import system.app.service.NastavnikNaRealizacijiService;

@Controller
@RequestMapping(path = "/api/nastavnikNaRealizaciji")
@CrossOrigin
public class NastavnikNaRealizacijiController {
	@Autowired
	private NastavnikNaRealizacijiService nastavnikNaRealizacijiService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<NastavnikNaRealizacijiDTO>> getAll() {
		List<NastavnikNaRealizacijiDTO> nastavnikNaRealizaciji = new ArrayList<NastavnikNaRealizacijiDTO>();
		for(NastavnikNaRealizaciji f: nastavnikNaRealizacijiService.findAll()) {
			nastavnikNaRealizaciji.add(new NastavnikNaRealizacijiDTO(f));
		}
		return new ResponseEntity<Iterable<NastavnikNaRealizacijiDTO>>(nastavnikNaRealizaciji, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@Secured({"ROLE_ADMIN","ROLE_NASTAVNIK"})
	public ResponseEntity<NastavnikNaRealizacijiDTO> getOne(@PathVariable("id") Long id) {
		NastavnikNaRealizaciji nastavnikNaRealizaciji = nastavnikNaRealizacijiService.findOne(id);
		NastavnikNaRealizacijiDTO nastavnikNaRealizacijiDTO = new NastavnikNaRealizacijiDTO(nastavnikNaRealizaciji);
		if (nastavnikNaRealizacijiDTO != null) {
			return new ResponseEntity<NastavnikNaRealizacijiDTO>(nastavnikNaRealizacijiDTO, HttpStatus.OK);
		}
		return new ResponseEntity<NastavnikNaRealizacijiDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<NastavnikNaRealizaciji> create(@RequestBody NastavnikNaRealizaciji newNastavnikNaRealizaciji) {
		if (nastavnikNaRealizacijiService.findOne(newNastavnikNaRealizaciji.getId()) != null) {
			return new ResponseEntity<NastavnikNaRealizaciji>(HttpStatus.CONFLICT);
		}
		nastavnikNaRealizacijiService.save(newNastavnikNaRealizaciji);
		return new ResponseEntity<NastavnikNaRealizaciji>(newNastavnikNaRealizaciji, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<NastavnikNaRealizaciji> updateNastavnikNaRealizaciji(@PathVariable("id") Long id,
			@RequestBody NastavnikNaRealizaciji editedNastavnikNaRealizaciji) {
		NastavnikNaRealizaciji nastavnikNaRealizaciji = nastavnikNaRealizacijiService.findOne(id);
		if (nastavnikNaRealizaciji == null) {
			return new ResponseEntity<NastavnikNaRealizaciji>(HttpStatus.NOT_FOUND);
		}
		nastavnikNaRealizaciji.setBrojCasova(editedNastavnikNaRealizaciji.getBrojCasova());
		nastavnikNaRealizaciji.setTipNastave(editedNastavnikNaRealizaciji.getTipNastave());
		nastavnikNaRealizaciji.setNastavnik(editedNastavnikNaRealizaciji.getNastavnik());
		nastavnikNaRealizaciji.setRealizacijaPredmeta(editedNastavnikNaRealizaciji.getRealizacijaPredmeta());
		nastavnikNaRealizacijiService.save(nastavnikNaRealizaciji);
		return new ResponseEntity<NastavnikNaRealizaciji>(nastavnikNaRealizaciji, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (nastavnikNaRealizacijiService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		nastavnikNaRealizacijiService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

