package system.app.dto;

import java.util.ArrayList;
import java.util.List;

import system.app.model.Fakultet;
import system.app.model.Nastavnik;
import system.app.model.NastavnikNaRealizaciji;
import system.app.model.StudijskiProgram;

public class NastavnikDTO {
	private Long id;
	private String biografija;
	private ZvanjeDTO zvanje;
	private UserRegistrovaniKorisnikDTO registrovaniKorisnik;
	private List<NastavnikNaRealizacijiDTO> nastavnikNaRealizacijama = new ArrayList<NastavnikNaRealizacijiDTO>();
	private List<StudijskiProgramDTO> rukovodilacStudijskimProgramima = new ArrayList<StudijskiProgramDTO>();
	private List<FakultetDTO> dekanNaFakultetima = new ArrayList<FakultetDTO>();
	
	public NastavnikDTO() {
		super();
	}
	
	public NastavnikDTO(Nastavnik nastavnik) {
		super();
		this.id = nastavnik.getId(); 
		this.biografija = nastavnik.getBiografija();
		this.zvanje = new ZvanjeDTO(
				nastavnik.getZvanje().getId(),
				nastavnik.getZvanje().getDatumIzbora(),
				nastavnik.getZvanje().getDatumPrestanka(),
				new TipZvanjaDTO(
						nastavnik.getZvanje().getTipZvanja().getId(),
						nastavnik.getZvanje().getTipZvanja().getNaziv(),
						null),
				new NaucnaOblastDTO(
						nastavnik.getZvanje().getNaucnaOblast().getId(),
						nastavnik.getZvanje().getNaucnaOblast().getNaziv(),
						null),
				null);
		this.registrovaniKorisnik = new UserRegistrovaniKorisnikDTO(
				nastavnik.getRegistrovaniKorisnik().getId(),
				nastavnik.getRegistrovaniKorisnik().getUsername(),
				nastavnik.getRegistrovaniKorisnik().getIme(),
				nastavnik.getRegistrovaniKorisnik().getPrezime(),
				nastavnik.getRegistrovaniKorisnik().getJmbg(),
				null,
				nastavnik.getRegistrovaniKorisnik().getEmail(),
				null,null);
		for(NastavnikNaRealizaciji nnz: nastavnik.getNastavnikNaRealizacijama()) {
			nastavnikNaRealizacijama.add(new NastavnikNaRealizacijiDTO(
					nnz.getId(),
					nnz.getBrojCasova(),
					nnz.getTipNastave(),
					null,
					new RealizacijaPredmetaDTO(
							nnz.getRealizacijaPredmeta().getId(),
							new PredmetDTO(
									nnz.getRealizacijaPredmeta().getPredmet().getId(),
									nnz.getRealizacijaPredmeta().getPredmet().getNaziv(),
									nnz.getRealizacijaPredmeta().getPredmet().getEspb(),
									nnz.getRealizacijaPredmeta().getPredmet().getObavezan(),
									nnz.getRealizacijaPredmeta().getPredmet().getBrojPredavanja(),
									nnz.getRealizacijaPredmeta().getPredmet().getBrojVezbi(),
									nnz.getRealizacijaPredmeta().getPredmet().getBrojSemestara(),
									nnz.getRealizacijaPredmeta().getPredmet().getDrugiObliciNastave(),
									nnz.getRealizacijaPredmeta().getPredmet().getIstrazivackiRad(),
									nnz.getRealizacijaPredmeta().getPredmet().getOstaliCasovi(),
									null,null
									),
							null
							)
					));
		}
		for(StudijskiProgram sp: nastavnik.getRukovodilacStudijskimProgramima()) {
			rukovodilacStudijskimProgramima.add(new StudijskiProgramDTO(
					sp.getId(),
					sp.getNaziv(),
					new FakultetDTO(
							sp.getFakultet().getId(),
							sp.getFakultet().getNaziv(),
							null,null,null,null
							),
					null,null
					));
		}
		for(Fakultet f: nastavnik.getDekanNaFakultetima()) {
			dekanNaFakultetima.add(new FakultetDTO(
					f.getId(),
					f.getNaziv(),
					null,
					new UniverzitetDTO(
							f.getUniverzitet().getId(),
							f.getUniverzitet().getNaziv(),
							null,null,null,null
							),
					null,null
					));
		}
	}

	public NastavnikDTO(Long id, String biografija, ZvanjeDTO zvanje, UserRegistrovaniKorisnikDTO registrovaniKorisnik,
			List<NastavnikNaRealizacijiDTO> nastavnikNaRealizacijama,
			List<StudijskiProgramDTO> rukovodilacStudijskimProgramima, List<FakultetDTO> dekanNaFakultetima) {
		super();
		this.id = id;
		this.biografija = biografija;
		this.zvanje = zvanje;
		this.registrovaniKorisnik = registrovaniKorisnik;
		this.nastavnikNaRealizacijama = nastavnikNaRealizacijama;
		this.rukovodilacStudijskimProgramima = rukovodilacStudijskimProgramima;
		this.dekanNaFakultetima = dekanNaFakultetima;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

	public ZvanjeDTO getZvanje() {
		return zvanje;
	}

	public void setZvanje(ZvanjeDTO zvanje) {
		this.zvanje = zvanje;
	}

	public UserRegistrovaniKorisnikDTO getRegistrovaniKorisnik() {
		return registrovaniKorisnik;
	}

	public void setRegistrovaniKorisnik(UserRegistrovaniKorisnikDTO registrovaniKorisnik) {
		this.registrovaniKorisnik = registrovaniKorisnik;
	}

	public List<NastavnikNaRealizacijiDTO> getNastavnikNaRealizacijama() {
		return nastavnikNaRealizacijama;
	}

	public void setNastavnikNaRealizacijama(List<NastavnikNaRealizacijiDTO> nastavnikNaRealizacijama) {
		this.nastavnikNaRealizacijama = nastavnikNaRealizacijama;
	}

	public List<StudijskiProgramDTO> getRukovodilacStudijskimProgramima() {
		return rukovodilacStudijskimProgramima;
	}

	public void setRukovodilacStudijskimProgramima(List<StudijskiProgramDTO> rukovodilacStudijskimProgramima) {
		this.rukovodilacStudijskimProgramima = rukovodilacStudijskimProgramima;
	}

	public List<FakultetDTO> getDekanNaFakultetima() {
		return dekanNaFakultetima;
	}

	public void setDekanNaFakultetima(List<FakultetDTO> dekanNaFakultetima) {
		this.dekanNaFakultetima = dekanNaFakultetima;
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
		NastavnikDTO other = (NastavnikDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
