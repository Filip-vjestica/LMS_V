package system.app.dto;

import java.util.ArrayList;
import java.util.List;

import system.app.model.PohadjanjePredmeta;
import system.app.model.RealizacijaPredmeta;

public class RealizacijaPredmetaDTO {
	private Long id;
	private PredmetDTO predmet;
	private List<PohadjanjePredmetaDTO> pohadjanjaPredmeta = new ArrayList<PohadjanjePredmetaDTO>();
	
	public RealizacijaPredmetaDTO() {
		super();
	}
	
	public RealizacijaPredmetaDTO(RealizacijaPredmeta realizacijaPredmeta) {
		super();
		this.id =realizacijaPredmeta.getId();
		this.predmet = new PredmetDTO(realizacijaPredmeta.getPredmet().getId(),
				realizacijaPredmeta.getPredmet().getNaziv(),
				realizacijaPredmeta.getPredmet().getEspb(),
				realizacijaPredmeta.getPredmet().getObavezan(),
				realizacijaPredmeta.getPredmet().getBrojPredavanja(),
				realizacijaPredmeta.getPredmet().getBrojVezbi(),
				realizacijaPredmeta.getPredmet().getBrojSemestara(),
				realizacijaPredmeta.getPredmet().getDrugiObliciNastave(),
				realizacijaPredmeta.getPredmet().getIstrazivackiRad(),
				realizacijaPredmeta.getPredmet().getOstaliCasovi(),
				null,null
				);
		for(PohadjanjePredmeta pp : realizacijaPredmeta.getPohadjanjaPredmeta()) {
			pohadjanjaPredmeta.add(new PohadjanjePredmetaDTO(pp.getId(),
					pp.getKonacnaOcena(),
					null,null));
		}
	}

	public RealizacijaPredmetaDTO(Long id, PredmetDTO predmet, List<PohadjanjePredmetaDTO> pohadjanjaPredmeta) {
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

	public PredmetDTO getPredmet() {
		return predmet;
	}

	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}

	public List<PohadjanjePredmetaDTO> getPohadjanjaPredmeta() {
		return pohadjanjaPredmeta;
	}

	public void setPohadjanjaPredmeta(List<PohadjanjePredmetaDTO> pohadjanjaPredmeta) {
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
		RealizacijaPredmetaDTO other = (RealizacijaPredmetaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
