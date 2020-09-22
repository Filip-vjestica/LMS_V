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
public class Predmet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String naziv;
	@Column(nullable = false)
	private Long espb;
	@Column(nullable = false)
	private int obavezan;
	@Column(nullable = false)
	private int brojPredavanja;
	@Column(nullable = false)
	private int brojVezbi;
	@Column(nullable = false)
	private int brojSemestara;
	@Column(nullable = false)
	private int drugiObliciNastave;
	@Column(nullable = false)
	private int istrazivackiRad;
	@Column(nullable = false)
	private int ostaliCasovi;
	@ManyToOne(optional = false)
	private GodinaStudija godinaStudija;
	@OneToMany(mappedBy = "predmet")
	private List<Ishod> ishodi = new ArrayList<Ishod>();
	
	public Predmet() {
		super();
	}

	public Predmet(Long id, String naziv, Long espb, int obavezan, int brojPredavanja, int brojVezbi, int brojSemestara,
			int drugiObliciNastave, int istrazivackiRad, int ostaliCasovi, GodinaStudija godinaStudija,
			List<Ishod> ishodi) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.obavezan = obavezan;
		this.brojPredavanja = brojPredavanja;
		this.brojVezbi = brojVezbi;
		this.brojSemestara = brojSemestara;
		this.drugiObliciNastave = drugiObliciNastave;
		this.istrazivackiRad = istrazivackiRad;
		this.ostaliCasovi = ostaliCasovi;
		this.godinaStudija = godinaStudija;
		this.ishodi = ishodi;
	}

	public Long getEspb() {
		return espb;
	}

	public void setEspb(Long espb) {
		this.espb = espb;
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

	public int getObavezan() {
		return obavezan;
	}

	public void setObavezan(int obavezan) {
		this.obavezan = obavezan;
	}

	public int getBrojPredavanja() {
		return brojPredavanja;
	}

	public void setBrojPredavanja(int brojPredavanja) {
		this.brojPredavanja = brojPredavanja;
	}

	public int getBrojVezbi() {
		return brojVezbi;
	}

	public void setBrojVezbi(int brojVezbi) {
		this.brojVezbi = brojVezbi;
	}

	public int getBrojSemestara() {
		return brojSemestara;
	}

	public void setBrojSemestara(int brojSemestara) {
		this.brojSemestara = brojSemestara;
	}

	public int getDrugiObliciNastave() {
		return drugiObliciNastave;
	}

	public void setDrugiObliciNastave(int drugiObliciNastave) {
		this.drugiObliciNastave = drugiObliciNastave;
	}

	public int getIstrazivackiRad() {
		return istrazivackiRad;
	}

	public void setIstrazivackiRad(int istrazivackiRad) {
		this.istrazivackiRad = istrazivackiRad;
	}

	public int getOstaliCasovi() {
		return ostaliCasovi;
	}

	public void setOstaliCasovi(int ostaliCasovi) {
		this.ostaliCasovi = ostaliCasovi;
	}

	public GodinaStudija getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public List<Ishod> getIshodi() {
		return ishodi;
	}

	public void setIshodi(List<Ishod> ishodi) {
		this.ishodi = ishodi;
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
		Predmet other = (Predmet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
