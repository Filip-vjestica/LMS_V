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

import system.app.dto.AdresaDTO;
import system.app.model.Adresa;
import system.app.model.Drzava;
import system.app.service.AdresaService;

@Controller
@RequestMapping(path = "/api/adresa")
@CrossOrigin
public class AdresaController {
	@Autowired
	private AdresaService adresaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<AdresaDTO>> getAll() {
		List<AdresaDTO> adresa = new ArrayList<AdresaDTO>();
		for(Adresa f: adresaService.findAll()) {
			adresa.add(new AdresaDTO(f));
		}
		return new ResponseEntity<Iterable<AdresaDTO>>(adresa, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AdresaDTO> getOne(@PathVariable("id") Long id) {
		Adresa adresa = adresaService.findOne(id);
		AdresaDTO adresaDTO = new AdresaDTO(adresa);
		if (adresaDTO != null) {
			return new ResponseEntity<AdresaDTO>(adresaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<AdresaDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Adresa> create(@RequestBody Adresa newAdresa) {
		if (adresaService.findOne(newAdresa.getId()) != null) {
			return new ResponseEntity<Adresa>(HttpStatus.CONFLICT);
		}
		adresaService.save(newAdresa);
		return new ResponseEntity<Adresa>(newAdresa, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Adresa> updateAdresa(@PathVariable("id") Long id,
			@RequestBody Adresa editedAdresa) {
		Adresa adresa = adresaService.findOne(id);
		if (adresa == null) {
			return new ResponseEntity<Adresa>(HttpStatus.NOT_FOUND);
		}
		adresa.setUlica(editedAdresa.getUlica());
		adresa.setBroj(editedAdresa.getBroj());
		adresa.setMesto(editedAdresa.getMesto());
		adresa.setUniverzitetiAdrese(editedAdresa.getUniverzitetiAdrese());
		adresa.setFakultetiAdrese(editedAdresa.getFakultetiAdrese());
		adresa.setRegistrovaniKorisnikAdrese(editedAdresa.getRegistrovaniKorisnikAdrese());
		adresaService.save(adresa);
		return new ResponseEntity<Adresa>(adresa, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (adresaService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		adresaService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

