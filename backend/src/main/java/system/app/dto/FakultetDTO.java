package system.app.dto;

import java.util.ArrayList;
import java.util.List;

import system.app.model.Fakultet;
import system.app.model.FakultetAdresa;
import system.app.model.StudijskiProgram;

public class FakultetDTO {
	private Long id;
	private String naziv;
	private List<FakultetAdresaDTO> fakultetAdrese = new ArrayList<FakultetAdresaDTO>();
	private UniverzitetDTO univerzitet;
	private List<StudijskiProgramDTO> studijskiProgrami = new ArrayList<StudijskiProgramDTO>();
	private NastavnikDTO dekan;
	
	public FakultetDTO() {
		super();
	}
	
	public FakultetDTO(Fakultet fakultet) {
		super();
		this.id = fakultet.getId();
		this.naziv = fakultet.getNaziv();
		this.univerzitet = new UniverzitetDTO(
				fakultet.getUniverzitet().getId(),
				fakultet.getUniverzitet().getNaziv(),
				null,null,null,null);
		for (FakultetAdresa fa: fakultet.getFakultetAdrese()) {
			fakultetAdrese.add(new FakultetAdresaDTO(
					fa.getId(),
					new AdresaDTO(
							fa.getAdresa().getId(),
							fa.getAdresa().getUlica(),
							fa.getAdresa().getBroj(),
							new MestoDTO(
									fa.getAdresa().getMesto().getId(),
									fa.getAdresa().getMesto().getNaziv(),
									new DrzavaDTO(
											fa.getAdresa().getMesto().getDrzava().getId(),
											fa.getAdresa().getMesto().getDrzava().getNaziv(),
											null),
									null)),
					null));
		}
		for(StudijskiProgram sp : fakultet.getStudijskiProgrami()) {
			studijskiProgrami.add(new StudijskiProgramDTO(
					sp.getId(),
					sp.getNaziv(),
					null,null,
					new NastavnikDTO(
							sp.getRukovodilac().getId(),
							null,null,
							new UserRegistrovaniKorisnikDTO(
									sp.getRukovodilac().getRegistrovaniKorisnik().getId(),
									sp.getRukovodilac().getRegistrovaniKorisnik().getUsername(),
									sp.getRukovodilac().getRegistrovaniKorisnik().getIme(),
									sp.getRukovodilac().getRegistrovaniKorisnik().getPrezime(),
									null,null,null,null,null),
							null,null,null)));
		}
		this.dekan = new NastavnikDTO(
				fakultet.getDekan().getId(),
				null,null,
				new UserRegistrovaniKorisnikDTO(
						fakultet.getDekan().getRegistrovaniKorisnik().getId(),
						fakultet.getDekan().getRegistrovaniKorisnik().getUsername(),
						fakultet.getDekan().getRegistrovaniKorisnik().getIme(),
						fakultet.getDekan().getRegistrovaniKorisnik().getPrezime(),
						null,null,null,null,null),
				null,null,null);
	}

	public FakultetDTO(Long id, String naziv, List<FakultetAdresaDTO> fakultetAdrese, UniverzitetDTO univerzitet,
			List<StudijskiProgramDTO> studijskiProgrami, NastavnikDTO dekan) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.fakultetAdrese = fakultetAdrese;
		this.univerzitet = univerzitet;
		this.studijskiProgrami = studijskiProgrami;
		this.dekan = dekan;
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

	public List<StudijskiProgramDTO> getStudijskiProgrami() {
		return studijskiProgrami;
	}

	public void setStudijskiProgrami(List<StudijskiProgramDTO> studijskiProgrami) {
		this.studijskiProgrami = studijskiProgrami;
	}

	public NastavnikDTO getDekan() {
		return dekan;
	}

	public void setDekan(NastavnikDTO dekan) {
		this.dekan = dekan;
	}

	public List<FakultetAdresaDTO> getFakultetAdrese() {
		return fakultetAdrese;
	}

	public void setFakultetAdrese(List<FakultetAdresaDTO> fakultetAdrese) {
		this.fakultetAdrese = fakultetAdrese;
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
		FakultetDTO other = (FakultetDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
