package system.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PohadjanjePredmeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private int konacnaOcena;
	@ManyToOne(optional = false)
	private RealizacijaPredmeta realizacijaPredmeta;
	@ManyToOne(optional = false)
	private RegistrovaniKorisnik registrovaniKorisnik;
	
	public PohadjanjePredmeta() {
		super();
	}

	public PohadjanjePredmeta(Long id, int konacnaOcena, RealizacijaPredmeta realizacijaPredmeta, RegistrovaniKorisnik registrovaniKorisnik) {
		super();
		this.id = id;
		this.konacnaOcena = konacnaOcena;
		this.realizacijaPredmeta = realizacijaPredmeta;
		this.registrovaniKorisnik = registrovaniKorisnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKonacnaOcena() {
		return konacnaOcena;
	}

	public void setKonacnaOcena(int konacnaOcena) {
		this.konacnaOcena = konacnaOcena;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public RegistrovaniKorisnik getRegistrovaniKorisnik() {
		return registrovaniKorisnik;
	}

	public void setRegistrovaniKorisnik(RegistrovaniKorisnik registrovaniKorisnik) {
		this.registrovaniKorisnik = registrovaniKorisnik;
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
		PohadjanjePredmeta other = (PohadjanjePredmeta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
