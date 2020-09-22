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

import system.app.dto.StudijskiProgramDTO;
import system.app.dto.TabelaStudijskiProgramDTO;
import system.app.model.Drzava;
import system.app.model.StudijskiProgram;
import system.app.service.StudijskiProgramService;

@Controller
@RequestMapping(path = "/api/studijskiProgram")
@CrossOrigin
public class StudijskiProgramController {
	@Autowired
	private StudijskiProgramService studijskiProgramService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<TabelaStudijskiProgramDTO>> getAll() {
		List<TabelaStudijskiProgramDTO> studijskiProgram = new ArrayList<TabelaStudijskiProgramDTO>();
		for(StudijskiProgram f: studijskiProgramService.findAll()) {
			studijskiProgram.add(new TabelaStudijskiProgramDTO(f));
		}
		return new ResponseEntity<Iterable<TabelaStudijskiProgramDTO>>(studijskiProgram, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudijskiProgramDTO> getOne(@PathVariable("id") Long id) {
		StudijskiProgram studijskiProgram = studijskiProgramService.findOne(id);
		StudijskiProgramDTO studijskiProgramDTO = new StudijskiProgramDTO(studijskiProgram);
		if (studijskiProgramDTO != null) {
			return new ResponseEntity<StudijskiProgramDTO>(studijskiProgramDTO, HttpStatus.OK);
		}
		return new ResponseEntity<StudijskiProgramDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<StudijskiProgram> create(@RequestBody StudijskiProgram newStudijskiProgram) {
		if (studijskiProgramService.findOne(newStudijskiProgram.getId()) != null) {
			return new ResponseEntity<StudijskiProgram>(HttpStatus.CONFLICT);
		}
		studijskiProgramService.save(newStudijskiProgram);
		return new ResponseEntity<StudijskiProgram>(newStudijskiProgram, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StudijskiProgram> updateStudijskiProgram(@PathVariable("id") Long id,
			@RequestBody StudijskiProgram editedStudijskiProgram) {
		StudijskiProgram studijskiProgram = studijskiProgramService.findOne(id);
		if (studijskiProgram == null) {
			return new ResponseEntity<StudijskiProgram>(HttpStatus.NOT_FOUND);
		}
		studijskiProgram.setNaziv(editedStudijskiProgram.getNaziv());
		studijskiProgram.setFakultet(editedStudijskiProgram.getFakultet());
		studijskiProgram.setGodineStudija(editedStudijskiProgram.getGodineStudija());
		studijskiProgram.setRukovodilac(editedStudijskiProgram.getRukovodilac());
		studijskiProgramService.save(studijskiProgram);
		return new ResponseEntity<StudijskiProgram>(studijskiProgram, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (studijskiProgramService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		studijskiProgramService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

