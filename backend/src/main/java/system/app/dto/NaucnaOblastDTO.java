package system.app.dto;

import java.util.ArrayList;
import java.util.List;

import system.app.model.NaucnaOblast;
import system.app.model.Zvanje;

public class NaucnaOblastDTO {
	private Long id;
	private String naziv;
	private List<ZvanjeDTO> zvanja = new ArrayList<ZvanjeDTO>();
	
	public NaucnaOblastDTO() {
		super();	
	}
	
	public NaucnaOblastDTO(NaucnaOblast naucnaOblast) {
		super();
		this.id = naucnaOblast.getId();
		this.naziv = naucnaOblast.getNaziv();
		for(Zvanje z: naucnaOblast.getZvanja()) {
			zvanja.add(new ZvanjeDTO(
					z.getId(),
					z.getDatumIzbora(),
					z.getDatumPrestanka(),
					null,null,null));
		}
	}

	public NaucnaOblastDTO(Long id, String naziv, List<ZvanjeDTO> zvanja) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.zvanja = zvanja;
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

	public List<ZvanjeDTO> getZvanja() {
		return zvanja;
	}

	public void setZvanja(List<ZvanjeDTO> zvanja) {
		this.zvanja = zvanja;
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
		NaucnaOblastDTO other = (NaucnaOblastDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
