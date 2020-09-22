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

import system.app.dto.StudentNaGodiniDTO;
import system.app.model.Drzava;
import system.app.model.StudentNaGodini;
import system.app.service.StudentNaGodiniService;

@Controller
@RequestMapping(path = "/api/studentNaGodini")
@CrossOrigin
public class StudentNaGodiniController {
	@Autowired
	private StudentNaGodiniService studentNaGodiniService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured({"ROLE_ADMIN","ROLE_NASTAVNIK","ROLE_ADMINISTRATIVNO_OSOBLJE"})
	public ResponseEntity<Iterable<StudentNaGodiniDTO>> getAll() {
		List<StudentNaGodiniDTO> studentNaGodini = new ArrayList<StudentNaGodiniDTO>();
		for(StudentNaGodini f: studentNaGodiniService.findAll()) {
			studentNaGodini.add(new StudentNaGodiniDTO(f));
		}
		return new ResponseEntity<Iterable<StudentNaGodiniDTO>>(studentNaGodini, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@Secured({"ROLE_ADMIN","ROLE_NASTAVNIK","ROLE_ADMINISTRATIVNO_OSOBLJE"})
	public ResponseEntity<StudentNaGodiniDTO> getOne(@PathVariable("id") Long id) {
		StudentNaGodini studentNaGodini = studentNaGodiniService.findOne(id);
		StudentNaGodiniDTO studentNaGodiniDTO = new StudentNaGodiniDTO(studentNaGodini);
		if (studentNaGodiniDTO != null) {
			return new ResponseEntity<StudentNaGodiniDTO>(studentNaGodiniDTO, HttpStatus.OK);
		}
		return new ResponseEntity<StudentNaGodiniDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<StudentNaGodini> create(@RequestBody StudentNaGodini newStudentNaGodini) {
		if (studentNaGodiniService.findOne(newStudentNaGodini.getId()) != null) {
			return new ResponseEntity<StudentNaGodini>(HttpStatus.CONFLICT);
		}
		studentNaGodiniService.save(newStudentNaGodini);
		return new ResponseEntity<StudentNaGodini>(newStudentNaGodini, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StudentNaGodini> updateStudentNaGodini(@PathVariable("id") Long id,
			@RequestBody StudentNaGodini editedStudentNaGodini) {
		StudentNaGodini studentNaGodini = studentNaGodiniService.findOne(id);
		if (studentNaGodini == null) {
			return new ResponseEntity<StudentNaGodini>(HttpStatus.NOT_FOUND);
		}
		studentNaGodini.setGodina(editedStudentNaGodini.getGodina());
		studentNaGodini.setIndeks(editedStudentNaGodini.getIndeks());
		studentNaGodini.setGodinaStudija(editedStudentNaGodini.getGodinaStudija());
		studentNaGodini.setRegistrovaniKorisnik(editedStudentNaGodini.getRegistrovaniKorisnik());
		studentNaGodiniService.save(studentNaGodini);
		return new ResponseEntity<StudentNaGodini>(studentNaGodini, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (studentNaGodiniService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		studentNaGodiniService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

