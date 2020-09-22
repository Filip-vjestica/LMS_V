package system.app.dto;

import system.app.model.FakultetAdresa;

public class FakultetAdresaDTO {
	private Long id;
	private AdresaDTO adresa;
	private FakultetDTO fakultet;
	
	public FakultetAdresaDTO() {
		super();
	}
	
	public FakultetAdresaDTO(FakultetAdresa fakultetAdresa) {
		super();
		this.id = fakultetAdresa.getId();
		this.adresa = new AdresaDTO(
				fakultetAdresa.getAdresa().getId(),
				fakultetAdresa.getAdresa().getUlica(),
				fakultetAdresa.getAdresa().getBroj(),
				new MestoDTO(
						fakultetAdresa.getAdresa().getMesto()));
		this.fakultet = new FakultetDTO(
				fakultetAdresa.getFakultet().getId(),
				fakultetAdresa.getFakultet().getNaziv(),
				null,null,null,null);
	}

	public FakultetAdresaDTO(Long id, AdresaDTO adresa, FakultetDTO fakultet) {
		super();
		this.id = id;
		this.adresa = adresa;
		this.fakultet = fakultet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}

	public FakultetDTO getFakultet() {
		return fakultet;
	}

	public void setFakultet(FakultetDTO fakultet) {
		this.fakultet = fakultet;
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
		FakultetAdresaDTO other = (FakultetAdresaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
