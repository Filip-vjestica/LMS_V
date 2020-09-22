package system.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import system.app.dto.UserPermissionDTO;
import system.app.model.Drzava;
import system.app.model.UserPermission;
import system.app.service.UserPermissionService;

@Controller
@RequestMapping(path = "/api/userPermission")
@CrossOrigin
public class UserPermissionController {
	@Autowired
	private UserPermissionService userPermissionService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<UserPermissionDTO>> getAll() {
		List<UserPermissionDTO> userPermission = new ArrayList<UserPermissionDTO>();
		for(UserPermission f: userPermissionService.findAll()) {
			userPermission.add(new UserPermissionDTO(f));
		}
		return new ResponseEntity<Iterable<UserPermissionDTO>>(userPermission, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserPermissionDTO> getOne(@PathVariable("id") Long id) {
		UserPermission userPermission = userPermissionService.findOne(id);
		UserPermissionDTO userPermissionDTO = new UserPermissionDTO(userPermission);
		if (userPermissionDTO != null) {
			return new ResponseEntity<UserPermissionDTO>(userPermissionDTO, HttpStatus.OK);
		}
		return new ResponseEntity<UserPermissionDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<UserPermission> create(@RequestBody UserPermission newUserPermission) {
		if (userPermissionService.findOne(newUserPermission.getId()) != null) {
			return new ResponseEntity<UserPermission>(HttpStatus.CONFLICT);
		}
		userPermissionService.save(newUserPermission);
		return new ResponseEntity<UserPermission>(newUserPermission, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserPermission> updateUserPermission(@PathVariable("id") Long id,
			@RequestBody UserPermission editedUserPermission) {
		UserPermission userPermission = userPermissionService.findOne(id);
		if (userPermission == null) {
			return new ResponseEntity<UserPermission>(HttpStatus.NOT_FOUND);
		}
		userPermission.setUser(editedUserPermission.getUser());
		userPermission.setPermission(editedUserPermission.getPermission());
		userPermissionService.save(userPermission);
		return new ResponseEntity<UserPermission>(userPermission, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (userPermissionService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		userPermissionService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

