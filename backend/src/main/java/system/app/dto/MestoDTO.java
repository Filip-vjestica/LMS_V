package system.app.dto;

import java.util.ArrayList;
import java.util.List;

import system.app.model.Adresa;
import system.app.model.Mesto;

public class MestoDTO {
	private Long id;
	private String naziv;
	private DrzavaDTO drzava;
	private List<AdresaDTO> adrese = new ArrayList<AdresaDTO>();
	
	public MestoDTO() {
		super();
	}
	
	public MestoDTO(Mesto mesto) {
		super();
		this.id = mesto.getId();
		this.naziv = mesto.getNaziv();
		this.drzava = new DrzavaDTO(
				null,
				mesto.getDrzava().getNaziv(),
				null);
		for(Adresa a : mesto.getAdrese()) {
			adrese.add(new AdresaDTO(
					a.getId(),
					a.getUlica(),
					a.getBroj(),
					null));
		}
	}

	public MestoDTO(Long id, String naziv, DrzavaDTO drzava, List<AdresaDTO> adrese) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.drzava = drzava;
		this.adrese = adrese;
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

	public DrzavaDTO getDrzava() {
		return drzava;
	}

	public void setDrzava(DrzavaDTO drzava) {
		this.drzava = drzava;
	}

	public List<AdresaDTO> getAdrese() {
		return adrese;
	}

	public void setAdrese(List<AdresaDTO> adrese) {
		this.adrese = adrese;
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
		MestoDTO other = (MestoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
