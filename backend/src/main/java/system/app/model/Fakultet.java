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
public class Fakultet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String naziv;
	@ManyToOne(optional = false)
	private Univerzitet univerzitet;
	@OneToMany(mappedBy = "fakultet")
	private List<StudijskiProgram> studijskiProgrami = new ArrayList<StudijskiProgram>();
	@ManyToOne(optional = false)
	private Nastavnik dekan;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "fakultet")
	private List<FakultetAdresa> fakultetAdrese = new ArrayList<FakultetAdresa>();
	
	public Fakultet() {
		super();
	}

	public Fakultet(Long id, String naziv, Univerzitet univerzitet,
			List<StudijskiProgram> studijskiProgrami, Nastavnik dekan, List<FakultetAdresa> fakultetAdrese) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.univerzitet = univerzitet;
		this.studijskiProgrami = studijskiProgrami;
		this.dekan = dekan;
		this.fakultetAdrese = fakultetAdrese;
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

	public Univerzitet getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet) {
		this.univerzitet = univerzitet;
	}

	public List<StudijskiProgram> getStudijskiProgrami() {
		return studijskiProgrami;
	}

	public void setStudijskiProgrami(List<StudijskiProgram> studijskiProgrami) {
		this.studijskiProgrami = studijskiProgrami;
	}

	public Nastavnik getDekan() {
		return dekan;
	}

	public void setDekan(Nastavnik dekan) {
		this.dekan = dekan;
	}

	public List<FakultetAdresa> getFakultetAdrese() {
		return fakultetAdrese;
	}

	public void setFakultetAdrese(List<FakultetAdresa> fakultetAdrese) {
		this.fakultetAdrese = fakultetAdrese;
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
		Fakultet other = (Fakultet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
