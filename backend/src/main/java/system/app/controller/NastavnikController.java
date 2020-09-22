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

import system.app.dto.NastavnikDTO;
import system.app.model.Mesto;
import system.app.model.Nastavnik;
import system.app.service.NastavnikService;

@Controller
@RequestMapping(path = "/api/nastavnik")
@CrossOrigin
public class NastavnikController {
	@Autowired
	private NastavnikService nastavnikService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<NastavnikDTO>> getAll() {
		List<NastavnikDTO> nastavnik = new ArrayList<NastavnikDTO>();
		for(Nastavnik f: nastavnikService.findAll()) {
			nastavnik.add(new NastavnikDTO(f));
		}
		return new ResponseEntity<Iterable<NastavnikDTO>>(nastavnik, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@Secured({"ROLE_ADMIN","ROLE_NASTAVNIK"})
	public ResponseEntity<NastavnikDTO> getOne(@PathVariable("id") Long id) {
		Nastavnik nastavnik = nastavnikService.findOne(id);
		NastavnikDTO nastavnikDTO = new NastavnikDTO(nastavnik);
		if (nastavnikDTO != null) {
			return new ResponseEntity<NastavnikDTO>(nastavnikDTO, HttpStatus.OK);
		}
		return new ResponseEntity<NastavnikDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Nastavnik> create(@RequestBody Nastavnik newNastavnik) {
		if (nastavnikService.findOne(newNastavnik.getId()) != null) {
			return new ResponseEntity<Nastavnik>(HttpStatus.CONFLICT);
		}
		nastavnikService.save(newNastavnik);
		return new ResponseEntity<Nastavnik>(newNastavnik, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Nastavnik> updateNastavnik(@PathVariable("id") Long id,
			@RequestBody Nastavnik editedNastavnik) {
		Nastavnik nastavnik = nastavnikService.findOne(id);
		if (nastavnik == null) {
			return new ResponseEntity<Nastavnik>(HttpStatus.NOT_FOUND);
		}
		nastavnik.setBiografija(editedNastavnik.getBiografija());
		nastavnik.setZvanje(editedNastavnik.getZvanje());
		nastavnik.setRegistrovaniKorisnik(editedNastavnik.getRegistrovaniKorisnik());
		nastavnik.setNastavnikNaRealizacijama(editedNastavnik.getNastavnikNaRealizacijama());
		nastavnik.setRukovodilacStudijskimProgramima(editedNastavnik.getRukovodilacStudijskimProgramima());
		nastavnik.setDekanNaFakultetima(editedNastavnik.getDekanNaFakultetima());
		nastavnikService.save(nastavnik);
		return new ResponseEntity<Nastavnik>(nastavnik, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (nastavnikService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		nastavnikService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

