package system.app.dto;

import java.util.Date;

import system.app.model.Univerzitet;

public class TabelaUniverzitetDTO {
	private Long id;
	private String naziv;
	private Date datumOsnivanja;
	
	public TabelaUniverzitetDTO() {
		super();
	}
	
	public TabelaUniverzitetDTO(Univerzitet univerzitet) {
		super();
		this.id = univerzitet.getId();
		this.naziv = univerzitet.getNaziv();
		this.datumOsnivanja = univerzitet.getDatumOsnivanja();
	}
		
	public TabelaUniverzitetDTO(Long id, String naziv, Date datumOsnivanja) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
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

	public Date getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(Date datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
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
		TabelaUniverzitetDTO other = (TabelaUniverzitetDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
