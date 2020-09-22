package system.app.dto;

import system.app.model.Adresa;

public class AdresaDTO {
	private Long id;
	private String ulica;
	private String broj;
	private MestoDTO mesto;
	
	public AdresaDTO() {
		super();
	}
	
	public AdresaDTO(Adresa adresa) {
		super();
		this.id = adresa.getId();
		this.ulica = adresa.getUlica();
		this.broj = adresa.getBroj();
		this.mesto = new MestoDTO(
				null, 
				adresa.getMesto().getNaziv(),
				new DrzavaDTO(
						adresa.getMesto().getDrzava().getId(),
						adresa.getMesto().getDrzava().getNaziv(),
						null),
				null);
	}

	public AdresaDTO(Long id, String ulica, String broj, MestoDTO mesto) {
		super();
		this.id = id;
		this.ulica = ulica;
		this.broj = broj;
		this.mesto = mesto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public MestoDTO getMesto() {
		return mesto;
	}

	public void setMesto(MestoDTO mesto) {
		this.mesto = mesto;
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
		AdresaDTO other = (AdresaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
