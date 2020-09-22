package system.app.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.UserPermission;
import system.app.repository.UserPermissionRepository;

@Service
public class UserPermissionService {
	@Autowired
	private UserPermissionRepository userPermissionRepository;
	
	public Set<UserPermission> getPermissionsByUserId(Long id) {
		return userPermissionRepository.getByUserId(id);
	}
	
	public Iterable<UserPermission> findAll() {
		return userPermissionRepository.findAll();
	}
	
	public UserPermission findOne(Long id) {
		return userPermissionRepository.findById(id).orElse(null);	
	}
	
	public void remove(Long id) {
		userPermissionRepository.deleteById(id);
	}
	
	public UserPermission save(UserPermission userPermission) {
		return userPermissionRepository.save(userPermission);
	}
}
