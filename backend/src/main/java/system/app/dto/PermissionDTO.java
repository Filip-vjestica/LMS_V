package system.app.dto;

import java.util.ArrayList;
import java.util.List;

import system.app.model.Permission;
import system.app.model.UserPermission;

public class PermissionDTO {
	private Long id;
	private String title;
	private List<UserPermissionDTO> userPermissions = new ArrayList<UserPermissionDTO>();
	
	public PermissionDTO() {
		super();
	}
	
	public PermissionDTO(Permission permission) {
		super();
		this.id = permission.getId();
		this.title = permission.getTitle();
		for (UserPermission up : permission.getUserPermissions()) {
			userPermissions.add(
						new UserPermissionDTO(
								up.getId(),
								new UserRegistrovaniKorisnikDTO(
										up.getUser().getId(),
										up.getUser().getUsername(),
										up.getUser().getIme(),
										up.getUser().getPrezime(),
										null,null,null,null,null
										),
								null
								)
					);
		}
	}

	public PermissionDTO(Long id, String title, List<UserPermissionDTO> userPermissions) {
		super();
		this.id = id;
		this.title = title;
		this.userPermissions = userPermissions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<UserPermissionDTO> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(List<UserPermissionDTO> userPermissions) {
		this.userPermissions = userPermissions;
	}	
}
