package system.app.dto;

import system.app.model.StudijskiProgram;

public class TabelaStudijskiProgramDTO {
	private Long id;
	private String naziv;
	private FakultetDTO fakultet;
	
	public TabelaStudijskiProgramDTO() {
		super();
	}
	
	public TabelaStudijskiProgramDTO(StudijskiProgram studijskiProgram) {
		super();
		this.id = studijskiProgram.getId();
		this.naziv = studijskiProgram.getNaziv();
		this.fakultet = new FakultetDTO(
				studijskiProgram.getFakultet().getId(),
				studijskiProgram.getFakultet().getNaziv(),
				null,null,null,null);
	}

	public TabelaStudijskiProgramDTO(Long id, String naziv, FakultetDTO fakultet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.fakultet = fakultet;
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
		TabelaStudijskiProgramDTO other = (TabelaStudijskiProgramDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
