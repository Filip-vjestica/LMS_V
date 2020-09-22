package system.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Univerzitet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String naziv;
	@Column(nullable = false)
	private Date datumOsnivanja;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "univerzitet")
	private List<Fakultet> fakulteti = new ArrayList<Fakultet>();
	@OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "rektorId")
	private Nastavnik rektor;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "univerzitet")
	private List<UniverzitetAdresa> univerzitetiAdrese = new ArrayList<UniverzitetAdresa>();
	
	public Univerzitet() {
		super();
	}

	public Univerzitet(Long id, String naziv, Date datumOsnivanja, List<Fakultet> fakulteti,
			Nastavnik rektor, List<UniverzitetAdresa> univerzitetiAdrese) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.fakulteti = fakulteti;
		this.rektor = rektor;
		this.univerzitetiAdrese = univerzitetiAdrese;
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

	public Date getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(Date datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public List<Fakultet> getFakulteti() {
		return fakulteti;
	}

	public void setFakulteti(List<Fakultet> fakulteti) {
		this.fakulteti = fakulteti;
	}

	public Nastavnik getRektor() {
		return rektor;
	}

	public void setRektor(Nastavnik rektor) {
		this.rektor = rektor;
	}

	public List<UniverzitetAdresa> getUniverzitetiAdrese() {
		return univerzitetiAdrese;
	}

	public void setUniverzitetiAdrese(List<UniverzitetAdresa> univerzitetiAdrese) {
		this.univerzitetiAdrese = univerzitetiAdrese;
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
		Univerzitet other = (Univerzitet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
