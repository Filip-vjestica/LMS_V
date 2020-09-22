package system.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Nastavnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String biografija;
	@ManyToOne(optional = false)
	private Zvanje zvanje;
	@OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "registrovaniKorisnikId")
	private RegistrovaniKorisnik registrovaniKorisnik;
	@OneToMany(mappedBy = "nastavnik")
	private List<NastavnikNaRealizaciji> nastavnikNaRealizacijama = new ArrayList<NastavnikNaRealizaciji>();
	@OneToMany(mappedBy = "rukovodilac")
	private List<StudijskiProgram> rukovodilacStudijskimProgramima = new ArrayList<StudijskiProgram>();
	@OneToMany(mappedBy = "dekan")
	private List<Fakultet> dekanNaFakultetima = new ArrayList<Fakultet>();
	
	public Nastavnik() {
		super();
	}

	public Nastavnik(Long id, String biografija, Zvanje zvanje, RegistrovaniKorisnik registrovaniKorisnik,
			List<NastavnikNaRealizaciji> nastavnikNaRealizacijama,
			List<StudijskiProgram> rukovodilacStudijskimProgramima, List<Fakultet> dekanNaFakultetima) {
		super();
		this.id = id;
		this.biografija = biografija;
		this.zvanje = zvanje;
		this.registrovaniKorisnik = registrovaniKorisnik;
		this.nastavnikNaRealizacijama = nastavnikNaRealizacijama;
		this.rukovodilacStudijskimProgramima = rukovodilacStudijskimProgramima;
		this.dekanNaFakultetima = dekanNaFakultetima;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	public RegistrovaniKorisnik getRegistrovaniKorisnik() {
		return registrovaniKorisnik;
	}

	public void setRegistrovaniKorisnik(RegistrovaniKorisnik registrovaniKorisnik) {
		this.registrovaniKorisnik = registrovaniKorisnik;
	}

	public List<NastavnikNaRealizaciji> getNastavnikNaRealizacijama() {
		return nastavnikNaRealizacijama;
	}

	public void setNastavnikNaRealizacijama(List<NastavnikNaRealizaciji> nastavnikNaRealizacijama) {
		this.nastavnikNaRealizacijama = nastavnikNaRealizacijama;
	}

	public List<StudijskiProgram> getRukovodilacStudijskimProgramima() {
		return rukovodilacStudijskimProgramima;
	}

	public void setRukovodilacStudijskimProgramima(List<StudijskiProgram> rukovodilacStudijskimProgramima) {
		this.rukovodilacStudijskimProgramima = rukovodilacStudijskimProgramima;
	}

	public List<Fakultet> getDekanNaFakultetima() {
		return dekanNaFakultetima;
	}

	public void setDekanNaFakultetima(List<Fakultet> dekanNaFakultetima) {
		this.dekanNaFakultetima = dekanNaFakultetima;
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
		Nastavnik other = (Nastavnik) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
