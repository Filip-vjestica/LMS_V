package system.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class RealizacijaPredmeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(optional = false)
    @JoinColumn(name = "predmetId")
	private Predmet predmet;
	@OneToMany(mappedBy = "realizacijaPredmeta")
	private List<PohadjanjePredmeta> pohadjanjaPredmeta = new ArrayList<PohadjanjePredmeta>();
	
	public RealizacijaPredmeta() {
		super();
	}

	public RealizacijaPredmeta(Long id, Predmet predmet, List<PohadjanjePredmeta> pohadjanjaPredmeta) {
		super();
		this.id = id;
		this.predmet = predmet;
		this.pohadjanjaPredmeta = pohadjanjaPredmeta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public List<PohadjanjePredmeta> getPohadjanjaPredmeta() {
		return pohadjanjaPredmeta;
	}

	public void setPohadjanjaPredmeta(List<PohadjanjePredmeta> pohadjanjaPredmeta) {
		this.pohadjanjaPredmeta = pohadjanjaPredmeta;
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
		RealizacijaPredmeta other = (RealizacijaPredmeta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
