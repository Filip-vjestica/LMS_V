package system.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Adresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String ulica;
	@Column(nullable = false)
	private String broj;
	@ManyToOne(optional = false)
	private Mesto mesto;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "adresa")
	private List<UniverzitetAdresa> univerzitetiAdrese = new ArrayList<UniverzitetAdresa>();
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "adresa")
	private List<FakultetAdresa> fakultetiAdrese = new ArrayList<FakultetAdresa>();
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "adresa")
	private List<RegistrovaniKorisnikAdresa> registrovaniKorisnikAdrese = new ArrayList<RegistrovaniKorisnikAdresa>();
	
	public Adresa() {
		super();
	}

	public Adresa(Long id, String ulica, String broj, Mesto mesto, List<UniverzitetAdresa> univerzitetiAdrese,
			List<FakultetAdresa> fakultetiAdrese, List<RegistrovaniKorisnikAdresa> registrovaniKorisnikAdrese) {
		super();
		this.id = id;
		this.ulica = ulica;
		this.broj = broj;
		this.mesto = mesto;
		this.univerzitetiAdrese = univerzitetiAdrese;
		this.fakultetiAdrese = fakultetiAdrese;
		this.registrovaniKorisnikAdrese = registrovaniKorisnikAdrese;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public Mesto getMesto() {
		return mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

	public List<UniverzitetAdresa> getUniverzitetiAdrese() {
		return univerzitetiAdrese;
	}

	public void setUniverzitetiAdrese(List<UniverzitetAdresa> univerzitetiAdrese) {
		this.univerzitetiAdrese = univerzitetiAdrese;
	}

	public List<FakultetAdresa> getFakultetiAdrese() {
		return fakultetiAdrese;
	}

	public void setFakultetiAdrese(List<FakultetAdresa> fakultetiAdrese) {
		this.fakultetiAdrese = fakultetiAdrese;
	}

	public List<RegistrovaniKorisnikAdresa> getRegistrovaniKorisnikAdrese() {
		return registrovaniKorisnikAdrese;
	}

	public void setRegistrovaniKorisnikAdrese(List<RegistrovaniKorisnikAdresa> registrovaniKorisnikAdrese) {
		this.registrovaniKorisnikAdrese = registrovaniKorisnikAdrese;
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
		Adresa other = (Adresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
