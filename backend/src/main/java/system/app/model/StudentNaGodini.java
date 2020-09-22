package system.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StudentNaGodini {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Date godina;
	@Column(nullable = false)
	private String indeks;
	@ManyToOne(optional = false)
	private GodinaStudija godinaStudija;
	@ManyToOne(optional = false)
	private RegistrovaniKorisnik registrovaniKorisnik;
	
	public StudentNaGodini() {
		super();
	}

	public StudentNaGodini(Long id, Date godina, String indeks, GodinaStudija godinaStudija, RegistrovaniKorisnik registrovaniKorisnik) {
		super();
		this.id = id;
		this.godina = godina;
		this.indeks = indeks;
		this.godinaStudija = godinaStudija;
		this.registrovaniKorisnik = registrovaniKorisnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGodina() {
		return godina;
	}

	public void setGodina(Date godina) {
		this.godina = godina;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public GodinaStudija getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
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
		StudentNaGodini other = (StudentNaGodini) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
