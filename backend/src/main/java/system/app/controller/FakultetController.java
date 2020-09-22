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

import system.app.dto.FakultetDTO;
import system.app.dto.TabelaFakultetDTO;
import system.app.model.Fakultet;
import system.app.service.FakultetService;

@Controller
@RequestMapping(path = "/api/fakultet")
@CrossOrigin
public class FakultetController {
	@Autowired
	private FakultetService fakultetService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<TabelaFakultetDTO>> getAll(){
		List<TabelaFakultetDTO> fakultet = new ArrayList<TabelaFakultetDTO>();
		for(Fakultet f: fakultetService.findAll()) {
			fakultet.add(new TabelaFakultetDTO(f));
		}
		return new ResponseEntity<Iterable<TabelaFakultetDTO>>(fakultet, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FakultetDTO> getOne(@PathVariable("id") Long id) {
		Fakultet fakultet = fakultetService.findOne(id);
		FakultetDTO fakultetDTO = new FakultetDTO(fakultet);
		if (fakultetDTO != null) {
			return new ResponseEntity<FakultetDTO>(fakultetDTO, HttpStatus.OK);
		}
		return new ResponseEntity<FakultetDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Fakultet> create(@RequestBody Fakultet newFakultet) {
		if (fakultetService.findOne(newFakultet.getId()) != null) {
			return new ResponseEntity<Fakultet>(HttpStatus.CONFLICT);
		}
		fakultetService.save(newFakultet);
		return new ResponseEntity<Fakultet>(newFakultet, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Fakultet> update(@PathVariable("id") Long id,
			@RequestBody Fakultet detailsFakultet) {
		Fakultet fakultet = fakultetService.findOne(id);
		if (fakultet == null) {
			return new ResponseEntity<Fakultet>(HttpStatus.NOT_FOUND);
		}
		fakultet.setNaziv(detailsFakultet.getNaziv());
		fakultet.setUniverzitet(detailsFakultet.getUniverzitet());
		fakultet.setStudijskiProgrami(detailsFakultet.getStudijskiProgrami());
		fakultet.setDekan(detailsFakultet.getDekan());
		fakultetService.save(fakultet);
		return new ResponseEntity<Fakultet>(fakultet, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (fakultetService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		fakultetService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
