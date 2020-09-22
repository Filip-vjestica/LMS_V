package system.app.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import system.app.model.PohadjanjePredmeta;
import system.app.model.RegistrovaniKorisnik;
import system.app.model.RegistrovaniKorisnikAdresa;
import system.app.model.StudentNaGodini;
import system.app.model.UserPermission;

public class UserRegistrovaniKorisnikDTO {
	private Long id;
	private String username;
	private String ime;
	private String prezime;
	private String jmbg;
	private List<StudentNaGodiniDTO> studentNaGodinama = new ArrayList<StudentNaGodiniDTO>();
	private List<PohadjanjePredmetaDTO> pohadjanjePredmeta = new ArrayList<PohadjanjePredmetaDTO>();
	private List<RegistrovaniKorisnikAdresaDTO> registrovaniKorisnikAdrese = new ArrayList<RegistrovaniKorisnikAdresaDTO>();
	private String email;
	private Set<UserPermissionDTO> userPermissions = new HashSet<UserPermissionDTO>();
	
	public UserRegistrovaniKorisnikDTO() {
		super();
	}

	public UserRegistrovaniKorisnikDTO(RegistrovaniKorisnik registrovaniKorisnik) {
		super();
		this.id = registrovaniKorisnik.getId();
		this.username = registrovaniKorisnik.getUsername();
		this.ime = registrovaniKorisnik.getIme();
		this.prezime = registrovaniKorisnik.getPrezime();
		this.jmbg = registrovaniKorisnik.getJmbg();
		for (RegistrovaniKorisnikAdresa rka: registrovaniKorisnik.getRegistrovaniKorisnikAdrese()) {
			registrovaniKorisnikAdrese.add(new RegistrovaniKorisnikAdresaDTO(
					rka.getId(),
					new AdresaDTO(
							rka.getAdresa().getId(),
							rka.getAdresa().getUlica(),
							rka.getAdresa().getBroj(),
							new MestoDTO(
									rka.getAdresa().getMesto().getId(),
									rka.getAdresa().getMesto().getNaziv(),
									new DrzavaDTO(
											rka.getAdresa().getMesto().getDrzava().getId(),
											rka.getAdresa().getMesto().getDrzava().getNaziv(),
											null
											),
									null
									)),
					null));
		}
		for (StudentNaGodini sng : registrovaniKorisnik.getStudentNaGodinama()) {
			this.studentNaGodinama.add(
						new StudentNaGodiniDTO(
									sng.getId(),
									sng.getGodina(),
									sng.getIndeks(),
									null,null
								));
		}
		for (PohadjanjePredmeta pp : registrovaniKorisnik.getPohadjanjePredmeta()) {
			this.pohadjanjePredmeta.add(
					new PohadjanjePredmetaDTO(
							pp.getId(),
							pp.getKonacnaOcena(),
							null,null
							));
		}
		this.email = registrovaniKorisnik.getEmail();
		for (UserPermission up : registrovaniKorisnik.getUserPermissions()) {
			userPermissions.add(
						new UserPermissionDTO(
									up.getId(),
									null,
									new PermissionDTO(
											up.getPermission().getId(),
											up.getPermission().getTitle(),
											null
											)
								)
					);
		}
	}

	public UserRegistrovaniKorisnikDTO(Long id, String username, String ime, String prezime, String jmbg,
			List<RegistrovaniKorisnikAdresaDTO> registrovaniKorisnikAdrese, String email,
			List<StudentNaGodiniDTO> studentNaGodinama, Set<UserPermissionDTO> userPermissions) {
		super();
		this.id = id;
		this.username = username;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.registrovaniKorisnikAdrese = registrovaniKorisnikAdrese;
		this.email = email;
		this.studentNaGodinama = studentNaGodinama;
		this.userPermissions = userPermissions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public List<RegistrovaniKorisnikAdresaDTO> getRegistrovaniKorisnikAdrese() {
		return registrovaniKorisnikAdrese;
	}

	public void setRegistrovaniKorisnikAdrese(List<RegistrovaniKorisnikAdresaDTO> registrovaniKorisnikAdrese) {
		this.registrovaniKorisnikAdrese = registrovaniKorisnikAdrese;
	}

	public List<PohadjanjePredmetaDTO> getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}

	public void setPohadjanjePredmeta(List<PohadjanjePredmetaDTO> pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<StudentNaGodiniDTO> getStudentNaGodinama() {
		return studentNaGodinama;
	}

	public void setStudentNaGodinama(List<StudentNaGodiniDTO> studentNaGodinama) {
		this.studentNaGodinama = studentNaGodinama;
	}

	public Set<UserPermissionDTO> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(Set<UserPermissionDTO> userPermissions) {
		this.userPermissions = userPermissions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRegistrovaniKorisnikDTO other = (UserRegistrovaniKorisnikDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
