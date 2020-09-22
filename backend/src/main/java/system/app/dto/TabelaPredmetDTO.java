package system.app.dto;

import system.app.model.Predmet;

public class TabelaPredmetDTO {
	private Long id;
	private String naziv;
	private Long espb;
	private int obavezan;
	private GodinaStudijaDTO godinaStudija;
	
	public TabelaPredmetDTO() {
		super();
	}
	
	public TabelaPredmetDTO(Predmet predmet) {
		super();
		this.id = predmet.getId();
		this.naziv = predmet.getNaziv();
		this.espb = predmet.getEspb();
		this.obavezan = predmet.getObavezan();
		this.godinaStudija = new GodinaStudijaDTO(
				predmet.getGodinaStudija().getId(),
				predmet.getGodinaStudija().getNaziv(),
				null,null,null);
	}

	public TabelaPredmetDTO(Long id, String naziv, Long espb, int obavezan,GodinaStudijaDTO godinaStudija) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.obavezan = obavezan;
		this.godinaStudija = godinaStudija;
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

	public GodinaStudijaDTO getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudijaDTO godinaStudija) {
		this.godinaStudija = godinaStudija;
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
		TabelaPredmetDTO other = (TabelaPredmetDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
