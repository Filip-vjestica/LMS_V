package system.app.dto;

import system.app.model.UserPermission;

public class UserPermissionDTO {
	private Long id;
	private UserRegistrovaniKorisnikDTO registrovaniKorisnik;
	private PermissionDTO permission;
	
	public UserPermissionDTO() {
		super();
	}
	
	public UserPermissionDTO(UserPermission userPermission) {
		super();
		this.id = userPermission.getId();
		this.registrovaniKorisnik = new UserRegistrovaniKorisnikDTO(
				userPermission.getUser().getId(),
				userPermission.getUser().getUsername(),
				userPermission.getUser().getIme(),
				userPermission.getUser().getPrezime(),
				null,null,null,null,null
				);
		this.permission = new PermissionDTO(
				userPermission.getPermission().getId(),
				userPermission.getPermission().getTitle(),
				null
				);
	}

	public UserPermissionDTO(Long id, UserRegistrovaniKorisnikDTO registrovaniKorisnik, PermissionDTO permission) {
		super();
		this.id = id;
		this.registrovaniKorisnik = registrovaniKorisnik;
		this.permission = permission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserRegistrovaniKorisnikDTO getRegistrovaniKorisnik() {
		return registrovaniKorisnik;
	}

	public void setRegistrovaniKorisnik(UserRegistrovaniKorisnikDTO registrovaniKorisnik) {
		this.registrovaniKorisnik = registrovaniKorisnik;
	}

	public PermissionDTO getPermission() {
		return permission;
	}

	public void setPermission(PermissionDTO permission) {
		this.permission = permission;
	}
}
