package system.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Mesto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String naziv;
	@ManyToOne(optional = false)
	private Drzava drzava;
	@OneToMany(mappedBy = "mesto")
	private List<Adresa> adrese = new ArrayList<Adresa>();
	
	public Mesto() {
		super();
	}

	public Mesto(Long id, String naziv, Drzava drzava, List<Adresa> adrese) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.drzava = drzava;
		this.adrese = adrese;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}

	public List<Adresa> getAdrese() {
		return adrese;
	}

	public void setAdrese(List<Adresa> adrese) {
		this.adrese = adrese;
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
		Mesto other = (Mesto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
