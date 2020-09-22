package system.app.dto;

import system.app.model.Fakultet;

public class TabelaFakultetDTO {
	private Long id;
	private String naziv;
	private UniverzitetDTO univerzitet;
	
	public TabelaFakultetDTO() {
		super();
	}
	
	public TabelaFakultetDTO(Fakultet fakultet) {
		super();
		this.id = fakultet.getId();
		this.naziv = fakultet.getNaziv();
		this.univerzitet = new UniverzitetDTO(
				fakultet.getUniverzitet().getId(),
				fakultet.getUniverzitet().getNaziv(),
				null,null,null,null);
		}

	public TabelaFakultetDTO(Long id, String naziv, UniverzitetDTO univerzitet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.univerzitet = univerzitet;
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
		TabelaFakultetDTO other = (TabelaFakultetDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
