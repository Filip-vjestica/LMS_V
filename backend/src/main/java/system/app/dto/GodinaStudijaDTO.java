package system.app.dto;

import java.util.ArrayList;
import java.util.List;

import system.app.model.GodinaStudija;
import system.app.model.Predmet;
import system.app.model.StudentNaGodini;

public class GodinaStudijaDTO {
	private Long id;
	private String naziv;
	private StudijskiProgramDTO studijskiProgram;
	private List<StudentNaGodiniDTO> studentiNaGodini = new ArrayList<StudentNaGodiniDTO>();
	private List<PredmetDTO> predmeti = new ArrayList<PredmetDTO>();
	
	public GodinaStudijaDTO() {
		super();
	}
	
	public GodinaStudijaDTO(GodinaStudija godinaStudija) {
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
		for(StudentNaGodini sng : godinaStudija.getStudentiNaGodini()) {
			studentiNaGodini.add(new StudentNaGodiniDTO(
					sng.getId(),
					sng.getGodina(),
					sng.getIndeks(),
					null,null));
		}
		for(Predmet p : godinaStudija.getPredmeti()) {
			predmeti.add(new PredmetDTO(
					p.getId(),
					p.getNaziv(),
					p.getEspb(),
					p.getObavezan(),
					p.getBrojPredavanja(),
					p.getBrojVezbi(),
					p.getBrojSemestara(),
					p.getDrugiObliciNastave(),
					p.getIstrazivackiRad(),
					p.getOstaliCasovi(),
					null,null));
		}
	}

	public GodinaStudijaDTO(Long id, String naziv, StudijskiProgramDTO studijskiProgram, List<StudentNaGodiniDTO> studentiNaGodini,
			List<PredmetDTO> predmeti) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.studijskiProgram = studijskiProgram;
		this.studentiNaGodini = studentiNaGodini;
		this.predmeti = predmeti;
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

	public List<StudentNaGodiniDTO> getStudentiNaGodini() {
		return studentiNaGodini;
	}

	public void setStudentiNaGodini(List<StudentNaGodiniDTO> studentiNaGodini) {
		this.studentiNaGodini = studentiNaGodini;
	}

	public List<PredmetDTO> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<PredmetDTO> predmeti) {
		this.predmeti = predmeti;
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
		GodinaStudijaDTO other = (GodinaStudijaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
