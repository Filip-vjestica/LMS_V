package system.app.dto;

import java.util.Date;

import system.app.model.Ishod;

public class TabelaIshodDTO {
	private Long id;
	private Date datum;
	private String naslov;
	private PredmetDTO predmet;
	
	public TabelaIshodDTO() {
		super();
	}
	
	public TabelaIshodDTO(Ishod ishod) {
		super();
		this.id = ishod.getId();
		this.datum = ishod.getDatum();
		this.naslov = ishod.getNaslov();
		this.predmet = new PredmetDTO(
				ishod.getPredmet().getId(),
				ishod.getPredmet().getNaziv(),
				ishod.getPredmet().getEspb(),
				ishod.getPredmet().getObavezan(),
				ishod.getPredmet().getBrojPredavanja(),
				ishod.getPredmet().getBrojVezbi(),
				ishod.getPredmet().getBrojSemestara(),
				ishod.getPredmet().getDrugiObliciNastave(),
				ishod.getPredmet().getIstrazivackiRad(),
				ishod.getPredmet().getOstaliCasovi(),
				null,null);
	}

	public TabelaIshodDTO(Long id, Date datum, String naslov, PredmetDTO predmet) {
		super();
		this.id = id;
		this.datum = datum;
		this.naslov = naslov;
		this.predmet = predmet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public PredmetDTO getPredmet() {
		return predmet;
	}

	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
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
		TabelaIshodDTO other = (TabelaIshodDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
