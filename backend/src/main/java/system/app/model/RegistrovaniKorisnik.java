package system.app.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class RegistrovaniKorisnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false,unique=true)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String ime;
	@Column(nullable = false)
	private String prezime;
	@Column(nullable = false)
	private String jmbg;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String roles;
	
	
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@OneToMany(mappedBy = "registrovaniKorisnik", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
	private List<StudentNaGodini> studentNaGodinama = new ArrayList<StudentNaGodini>();
	
	@OneToMany(mappedBy = "registrovaniKorisnik", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
	private List<PohadjanjePredmeta> pohadjanjePredmeta = new ArrayList<PohadjanjePredmeta>();
	
	@OneToOne(mappedBy = "registrovaniKorisnik", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
	private Nastavnik nastavnik;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "registrovaniKorisnik")
	private List<RegistrovaniKorisnikAdresa> registrovaniKorisnikAdrese = new ArrayList<RegistrovaniKorisnikAdresa>();
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
	private Set<UserPermission> userPermissions = new HashSet<UserPermission>();
	
	public RegistrovaniKorisnik() {
		super();
	}

	public RegistrovaniKorisnik(Long id, String username, String password, String ime, String prezime, String jmbg,
			String email, List<StudentNaGodini> studentNaGodinama, List<PohadjanjePredmeta> pohadjanjePredmeta,
			Nastavnik nastavnik, List<RegistrovaniKorisnikAdresa> registrovaniKorisnikAdrese,String roles,
			Set<UserPermission> userPermissions) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.email = email;
		this.studentNaGodinama = studentNaGodinama;
		this.pohadjanjePredmeta = pohadjanjePredmeta;
		this.nastavnik = nastavnik;
		this.registrovaniKorisnikAdrese = registrovaniKorisnikAdrese;
		this.userPermissions = userPermissions;
		this.roles = roles;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<StudentNaGodini> getStudentNaGodinama() {
		return studentNaGodinama;
	}

	public void setStudentNaGodinama(List<StudentNaGodini> studentNaGodinama) {
		this.studentNaGodinama = studentNaGodinama;
	}

	public List<PohadjanjePredmeta> getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}

	public void setPohadjanjePredmeta(List<PohadjanjePredmeta> pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public List<RegistrovaniKorisnikAdresa> getRegistrovaniKorisnikAdrese() {
		return registrovaniKorisnikAdrese;
	}

	public void setRegistrovaniKorisnikAdrese(List<RegistrovaniKorisnikAdresa> registrovaniKorisnikAdrese) {
		this.registrovaniKorisnikAdrese = registrovaniKorisnikAdrese;
	}

	public Set<UserPermission> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(Set<UserPermission> userPermissions) {
		this.userPermissions = userPermissions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		RegistrovaniKorisnik other = (RegistrovaniKorisnik) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
