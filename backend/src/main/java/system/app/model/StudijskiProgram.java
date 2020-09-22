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
public class StudijskiProgram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String naziv;
	@ManyToOne(optional = false)
	private Fakultet fakultet;
	@OneToMany(mappedBy = "studijskiProgram")
	private List<GodinaStudija> godineStudija = new ArrayList<GodinaStudija>();
	@ManyToOne(optional = false)
	private Nastavnik rukovodilac;
	
	public StudijskiProgram() {
		super();
	}

	public StudijskiProgram(Long id, String naziv, Fakultet fakultet, List<GodinaStudija> godineStudija,
			Nastavnik rukovodilac) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.fakultet = fakultet;
		this.godineStudija = godineStudija;
		this.rukovodilac = rukovodilac;
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

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public List<GodinaStudija> getGodineStudija() {
		return godineStudija;
	}

	public void setGodineStudija(List<GodinaStudija> godineStudija) {
		this.godineStudija = godineStudija;
	}

	public Nastavnik getRukovodilac() {
		return rukovodilac;
	}

	public void setRukovodilac(Nastavnik rukovodilac) {
		this.rukovodilac = rukovodilac;
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
		StudijskiProgram other = (StudijskiProgram) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
