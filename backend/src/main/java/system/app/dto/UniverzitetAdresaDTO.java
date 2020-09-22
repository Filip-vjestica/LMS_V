package system.app.dto;

import system.app.model.UniverzitetAdresa;

public class UniverzitetAdresaDTO {
	private Long id;
	private AdresaDTO adresa;
	private UniverzitetDTO univerzitet;
	
	public UniverzitetAdresaDTO() {
		super();
	}
	
	public UniverzitetAdresaDTO(UniverzitetAdresa univerzitetAdresa) {
		super();
		this.id = univerzitetAdresa.getId();
		this.adresa = new AdresaDTO(
				univerzitetAdresa.getAdresa().getId(),
				univerzitetAdresa.getAdresa().getUlica(),
				univerzitetAdresa.getAdresa().getBroj(),
				new MestoDTO(
						univerzitetAdresa.getAdresa().getMesto()));
		this.univerzitet = new UniverzitetDTO(
				univerzitetAdresa.getUniverzitet().getId(),
				univerzitetAdresa.getUniverzitet().getNaziv(),
				univerzitetAdresa.getUniverzitet().getDatumOsnivanja(),
				null,null,null);
	}

	public UniverzitetAdresaDTO(Long id, AdresaDTO adresa, UniverzitetDTO univerzitet) {
		super();
		this.id = id;
		this.adresa = adresa;
		this.univerzitet = univerzitet;
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

	public UniverzitetDTO getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(UniverzitetDTO univerzitet) {
		this.univerzitet = univerzitet;
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
		UniverzitetAdresaDTO other = (UniverzitetAdresaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
