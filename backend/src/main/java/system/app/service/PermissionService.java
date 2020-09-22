package system.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.Permission;
import system.app.repository.PermissionRepository;

@Service
public class PermissionService {
	@Autowired
	PermissionRepository permissionRepository;

	public PermissionService() {
		super();
	}
	
	public Iterable<Permission> findAll() {
		return permissionRepository.findAll();
	}
	
	public Permission findOne(Long id) {
		return permissionRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		permissionRepository.deleteById(id);
	}
	
	public Permission save(Permission permission) {
		return permissionRepository.save(permission);
	}
}
