package system.app.dto;

import java.util.ArrayList;
import java.util.List;

import system.app.model.Drzava;
import system.app.model.Mesto;

public class DrzavaDTO {
	private Long id;
	private String naziv;
	private List<MestoDTO> mesta = new ArrayList<MestoDTO>();
	
	public DrzavaDTO() {
		super();
	}
	
	public DrzavaDTO(Drzava drzava) {
		super();
		this.id = drzava.getId();
		this.naziv = drzava.getNaziv();
		for(Mesto m : drzava.getMesta()) {
			mesta.add(new MestoDTO(
					m.getId(),
					m.getNaziv(),
					null,null));
		}
	}

	public DrzavaDTO(Long id, String naziv, List<MestoDTO> mesta) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.mesta = mesta;
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

	public List<MestoDTO> getMesta() {
		return mesta;
	}

	public void setMesta(List<MestoDTO> mesta) {
		this.mesta = mesta;
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
		DrzavaDTO other = (DrzavaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
