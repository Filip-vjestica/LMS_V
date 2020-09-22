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

import system.app.dto.TipZvanjaDTO;
import system.app.model.Drzava;
import system.app.model.TipZvanja;
import system.app.service.TipZvanjaService;

@Controller
@RequestMapping(path = "/api/tipZvanja")
@CrossOrigin
public class TipZvanjaController {
	@Autowired
	private TipZvanjaService tipZvanjaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<TipZvanjaDTO>> getAll() {
		List<TipZvanjaDTO> tipZvanja = new ArrayList<TipZvanjaDTO>();
		for(TipZvanja f: tipZvanjaService.findAll()) {
			tipZvanja.add(new TipZvanjaDTO(f));
		}
		return new ResponseEntity<Iterable<TipZvanjaDTO>>(tipZvanja, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@Secured({"ROLE_ADMIN","ROLE_NASTAVNIK"})
	public ResponseEntity<TipZvanjaDTO> getOne(@PathVariable("id") Long id) {
		TipZvanja tipZvanja = tipZvanjaService.findOne(id);
		TipZvanjaDTO tipZvanjaDTO = new TipZvanjaDTO(tipZvanja);
		if (tipZvanjaDTO != null) {
			return new ResponseEntity<TipZvanjaDTO>(tipZvanjaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<TipZvanjaDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<TipZvanja> create(@RequestBody TipZvanja newTipZvanja) {
		if (tipZvanjaService.findOne(newTipZvanja.getId()) != null) {
			return new ResponseEntity<TipZvanja>(HttpStatus.CONFLICT);
		}
		tipZvanjaService.save(newTipZvanja);
		return new ResponseEntity<TipZvanja>(newTipZvanja, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TipZvanja> updateTipZvanja(@PathVariable("id") Long id,
			@RequestBody TipZvanja editedTipZvanja) {
		TipZvanja tipZvanja = tipZvanjaService.findOne(id);
		if (tipZvanja == null) {
			return new ResponseEntity<TipZvanja>(HttpStatus.NOT_FOUND);
		}
		tipZvanja.setNaziv(editedTipZvanja.getNaziv());
		tipZvanja.setZvanja(editedTipZvanja.getZvanja());
		tipZvanjaService.save(tipZvanja);
		return new ResponseEntity<TipZvanja>(tipZvanja, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (tipZvanjaService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		tipZvanjaService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

