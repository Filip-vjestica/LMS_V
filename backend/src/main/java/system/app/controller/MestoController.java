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

import system.app.dto.MestoDTO;
import system.app.model.Drzava;
import system.app.model.Mesto;
import system.app.service.MestoService;

@Controller
@RequestMapping(path = "/api/mesto")
@CrossOrigin
public class MestoController {
	@Autowired
	private MestoService mestoService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<MestoDTO>> getAll() {
		List<MestoDTO> mesto = new ArrayList<MestoDTO>();
		for(Mesto f: mestoService.findAll()) {
			mesto.add(new MestoDTO(f));
		}
		return new ResponseEntity<Iterable<MestoDTO>>(mesto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MestoDTO> getOne(@PathVariable("id") Long id) {
		Mesto mesto = mestoService.findOne(id);
		MestoDTO mestoDTO = new MestoDTO(mesto);
		if (mestoDTO != null) {
			return new ResponseEntity<MestoDTO>(mestoDTO, HttpStatus.OK);
		}
		return new ResponseEntity<MestoDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Mesto> create(@RequestBody Mesto newMesto) {
		if (mestoService.findOne(newMesto.getId()) != null) {
			return new ResponseEntity<Mesto>(HttpStatus.CONFLICT);
		}
		mestoService.save(newMesto);
		return new ResponseEntity<Mesto>(newMesto, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Mesto> updateMesto(@PathVariable("id") Long id,
			@RequestBody Mesto editedMesto) {
		Mesto mesto = mestoService.findOne(id);
		if (mesto == null) {
			return new ResponseEntity<Mesto>(HttpStatus.NOT_FOUND);
		}
		mesto.setNaziv(editedMesto.getNaziv());
		mesto.setDrzava(editedMesto.getDrzava());
		mesto.setAdrese(editedMesto.getAdrese());
		mestoService.save(mesto);
		return new ResponseEntity<Mesto>(mesto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (mestoService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		mestoService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

