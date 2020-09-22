package system.app.dto;

import system.app.model.GodinaStudija;

public class TabelaGodinaStudijaDTO {
	private Long id;
	private String naziv;
	private StudijskiProgramDTO studijskiProgram;
	
	public TabelaGodinaStudijaDTO() {
		super();
	}
	
	public TabelaGodinaStudijaDTO(GodinaStudija godinaStudija) {
		super();
		this.id = godinaStudija.getId();
		this.naziv = godinaStudija.getNaziv();
		this.studijskiProgram = new StudijskiProgramDTO(
				godinaStudija.getStudijskiProgram().getId(),
				godinaStudija.getStudijskiProgram().getNaziv(),
				new FakultetDTO(
						godinaStudija.getStudijskiProgram().getFakultet().getId(),
						godinaStudija.getStudijskiProgram().getFakultet().getNaziv(),
						null,null,null,null),
				null,null);
	}

	public TabelaGodinaStudijaDTO(Long id, String naziv, StudijskiProgramDTO studijskiProgram) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.studijskiProgram = studijskiProgram;
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

	public StudijskiProgramDTO getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgramDTO studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
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
		TabelaGodinaStudijaDTO other = (TabelaGodinaStudijaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
