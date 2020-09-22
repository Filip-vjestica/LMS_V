package system.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class NastavnikNaRealizaciji {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private int brojCasova;
	@Column(nullable = false)
	private String tipNastave;
	@ManyToOne(optional = false)
	private Nastavnik nastavnik;
	@OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "realizacijaPredmetaId")
	private RealizacijaPredmeta realizacijaPredmeta;
	
	public NastavnikNaRealizaciji() {
		super();
	}

	public NastavnikNaRealizaciji(Long id, int brojCasova, String tipNastave, Nastavnik nastavnik,
			RealizacijaPredmeta realizacijaPredmeta) {
		super();
		this.id = id;
		this.brojCasova = brojCasova;
		this.tipNastave = tipNastave;
		this.nastavnik = nastavnik;
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrojCasova() {
		return brojCasova;
	}

	public void setBrojCasova(int brojCasova) {
		this.brojCasova = brojCasova;
	}

	public String getTipNastave() {
		return tipNastave;
	}

	public void setTipNastave(String tipNastave) {
		this.tipNastave = tipNastave;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
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
		NastavnikNaRealizaciji other = (NastavnikNaRealizaciji) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
