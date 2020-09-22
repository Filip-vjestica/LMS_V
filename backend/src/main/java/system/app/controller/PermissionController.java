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

import system.app.dto.PermissionDTO;
import system.app.model.Drzava;
import system.app.model.Permission;
import system.app.service.PermissionService;

@Controller
@RequestMapping(path = "/api/permission")
@CrossOrigin
public class PermissionController {
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<PermissionDTO>> getAll() {
		List<PermissionDTO> permission = new ArrayList<PermissionDTO>();
		for(Permission f: permissionService.findAll()) {
			permission.add(new PermissionDTO(f));
		}
		return new ResponseEntity<Iterable<PermissionDTO>>(permission, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<PermissionDTO> getOne(@PathVariable("id") Long id) {
		Permission permission = permissionService.findOne(id);
		PermissionDTO permissionDTO = new PermissionDTO(permission);
		if (permissionDTO != null) {
			return new ResponseEntity<PermissionDTO>(permissionDTO, HttpStatus.OK);
		}
		return new ResponseEntity<PermissionDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Permission> create(@RequestBody Permission newPermission) {
		if (permissionService.findOne(newPermission.getId()) != null) {
			return new ResponseEntity<Permission>(HttpStatus.CONFLICT);
		}
		permissionService.save(newPermission);
		return new ResponseEntity<Permission>(newPermission, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Permission> updatePermission(@PathVariable("id") Long id,
			@RequestBody Permission editedPermission) {
		Permission permission = permissionService.findOne(id);
		if (permission == null) {
			return new ResponseEntity<Permission>(HttpStatus.NOT_FOUND);
		}
		permission.setTitle(editedPermission.getTitle());
		permission.setUserPermissions(editedPermission.getUserPermissions());
		permissionService.save(permission);
		return new ResponseEntity<Permission>(permission, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (permissionService.findOne(id) == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		permissionService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

