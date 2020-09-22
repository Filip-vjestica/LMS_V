package system.app.dto;

import java.util.ArrayList;
import java.util.List;

import system.app.model.Ishod;
import system.app.model.Predmet;

public class PredmetDTO {
	private Long id;
	private String naziv;
	private Long espb;
	private int obavezan;
	private int brojPredavanja;
	private int brojVezbi;
	private int brojSemestara;
	private int drugiObliciNastave;
	private int istrazivackiRad;
	private int ostaliCasovi;
	private GodinaStudijaDTO godinaStudija;
	private List<IshodDTO> ishodi = new ArrayList<IshodDTO>();
	
	public PredmetDTO() {
		super();
	}
	
	public PredmetDTO(Predmet predmet) {
		super();
		this.id = predmet.getId();
		this.naziv = predmet.getNaziv();
		this.espb = predmet.getEspb();
		this.obavezan = predmet.getObavezan();
		this.brojPredavanja = predmet.getBrojPredavanja();
		this.brojVezbi = predmet.getBrojVezbi();
		this.brojSemestara = predmet.getBrojSemestara();
		this.drugiObliciNastave = predmet.getDrugiObliciNastave();
		this.istrazivackiRad = predmet.getIstrazivackiRad();
		this.ostaliCasovi = predmet.getOstaliCasovi();
		this.godinaStudija = new GodinaStudijaDTO(
				predmet.getGodinaStudija().getId(),
				predmet.getGodinaStudija().getNaziv(),
				null,null,null);
		for (Ishod i : predmet.getIshodi()) {
			ishodi.add(new IshodDTO(
					i.getId(),
					i.getDatum(),
					i.getNaslov(),
					i.getOpis(),
					null));
		}
	}

	public PredmetDTO(Long id, String naziv, Long espb, int obavezan, int brojPredavanja, int brojVezbi,
			int brojSemestara, int drugiObliciNastave, int istrazivackiRad, int ostaliCasovi,
			GodinaStudijaDTO godinaStudija, List<IshodDTO> ishodi) {
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

	public Long getEspb() {
		return espb;
	}

	public void setEspb(Long espb) {
		this.espb = espb;
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

	public GodinaStudijaDTO getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudijaDTO godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public List<IshodDTO> getIshodi() {
		return ishodi;
	}

	public void setIshodi(List<IshodDTO> ishodi) {
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
		PredmetDTO other = (PredmetDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
