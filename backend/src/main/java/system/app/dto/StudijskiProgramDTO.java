package system.app.dto;

import java.util.ArrayList;
import java.util.List;

import system.app.model.GodinaStudija;
import system.app.model.StudijskiProgram;

public class StudijskiProgramDTO {
	private Long id;
	private String naziv;
	private FakultetDTO fakultet;
	private List<GodinaStudijaDTO> godineStudija = new ArrayList<GodinaStudijaDTO>();
	private NastavnikDTO rukovodilac;
	
	public StudijskiProgramDTO() {
		super();
	}
	
	public StudijskiProgramDTO(StudijskiProgram studijskiProgram) {
		super();
		this.id = studijskiProgram.getId();
		this.naziv = studijskiProgram.getNaziv();
		this.fakultet = new FakultetDTO(
				studijskiProgram.getFakultet().getId(),
				studijskiProgram.getFakultet().getNaziv(),
				null,null,null,null);
		for(GodinaStudija gs : studijskiProgram.getGodineStudija()) {
			godineStudija.add(new GodinaStudijaDTO(
					gs.getId(),
					gs.getNaziv(),
					null,null,null));
		}
		this.rukovodilac = new NastavnikDTO(
				studijskiProgram.getRukovodilac().getId(),
				null,null,
				new UserRegistrovaniKorisnikDTO(
						studijskiProgram.getRukovodilac().getRegistrovaniKorisnik().getId(),
						studijskiProgram.getRukovodilac().getRegistrovaniKorisnik().getUsername(),
						studijskiProgram.getRukovodilac().getRegistrovaniKorisnik().getIme(),
						studijskiProgram.getRukovodilac().getRegistrovaniKorisnik().getPrezime(),
						null,null,null,null,null),
				null,null,null);
	}

	public StudijskiProgramDTO(Long id, String naziv, FakultetDTO fakultet, List<GodinaStudijaDTO> godineStudija,
			NastavnikDTO rukovodilac) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.fakultet = fakultet;
		this.godineStudija = godineStudija;
		this.rukovodilac = rukovodilac;
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

	public List<GodinaStudijaDTO> getGodineStudija() {
		return godineStudija;
	}

	public void setGodineStudija(List<GodinaStudijaDTO> godineStudija) {
		this.godineStudija = godineStudija;
	}

	public NastavnikDTO getRukovodilac() {
		return rukovodilac;
	}

	public void setRukovodilac(NastavnikDTO rukovodilac) {
		this.rukovodilac = rukovodilac;
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
		StudijskiProgramDTO other = (StudijskiProgramDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
