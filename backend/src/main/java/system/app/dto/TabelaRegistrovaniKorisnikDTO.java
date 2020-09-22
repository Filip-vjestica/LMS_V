package system.app.dto;

import java.util.List;

import system.app.model.RegistrovaniKorisnik;


public class TabelaRegistrovaniKorisnikDTO {
	private Long id;
	private String username;
	private String password;
	private String ime;
	private String prezime;
	private String email;
	private String roles;
	
	public TabelaRegistrovaniKorisnikDTO() {
		super();
	}

	public TabelaRegistrovaniKorisnikDTO(RegistrovaniKorisnik registrovaniKorisnik) {
		super();
		this.id = registrovaniKorisnik.getId();
		this.username = registrovaniKorisnik.getUsername();
		this.password = registrovaniKorisnik.getPassword();
		this.ime = registrovaniKorisnik.getIme();
		this.prezime = registrovaniKorisnik.getPrezime();
		this.email = registrovaniKorisnik.getEmail();
		this.roles = registrovaniKorisnik.getRoles();
	}

	public TabelaRegistrovaniKorisnikDTO(Long id, String username,String password, String ime, String prezime, String email, String roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
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
		TabelaRegistrovaniKorisnikDTO other = (TabelaRegistrovaniKorisnikDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
