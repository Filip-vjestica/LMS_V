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
public class GodinaStudija {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String naziv;
	@ManyToOne(optional = false)
	private StudijskiProgram studijskiProgram;
	@OneToMany(mappedBy = "godinaStudija")
	private List<StudentNaGodini> studentiNaGodini = new ArrayList<StudentNaGodini>();
	@OneToMany(mappedBy = "godinaStudija")
	private List<Predmet> predmeti = new ArrayList<Predmet>();
	
	public GodinaStudija() {
		super();
	}

	public GodinaStudija(Long id, String naziv, StudijskiProgram studijskiProgram,
			List<StudentNaGodini> studentiNaGodini, List<Predmet> predmeti) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.studijskiProgram = studijskiProgram;
		this.studentiNaGodini = studentiNaGodini;
		this.predmeti = predmeti;
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

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public List<StudentNaGodini> getStudentiNaGodini() {
		return studentiNaGodini;
	}

	public void setStudentiNaGodini(List<StudentNaGodini> studentiNaGodini) {
		this.studentiNaGodini = studentiNaGodini;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
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
		GodinaStudija other = (GodinaStudija) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
