package system.app.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import system.app.model.Fakultet;
import system.app.model.Univerzitet;
import system.app.model.UniverzitetAdresa;

public class UniverzitetDTO {
	private Long id;
	private String naziv;
	private Date datumOsnivanja;
	private List<UniverzitetAdresaDTO> univerzitetAdrese = new ArrayList<UniverzitetAdresaDTO>();
	private List<FakultetDTO> fakulteti = new ArrayList<FakultetDTO>();
	private NastavnikDTO rektor;
	
	public UniverzitetDTO() {
		super();
	}
	
	public UniverzitetDTO(Univerzitet univerzitet) {
		super();
		this.id = univerzitet.getId();
		this.naziv = univerzitet.getNaziv();
		this.datumOsnivanja = univerzitet.getDatumOsnivanja();
		for (UniverzitetAdresa ua: univerzitet.getUniverzitetiAdrese()) {
			univerzitetAdrese.add(new UniverzitetAdresaDTO(
					ua.getId(),
					new AdresaDTO(
							ua.getAdresa().getId(),
							ua.getAdresa().getUlica(),
							ua.getAdresa().getBroj(),
							new MestoDTO(
									ua.getAdresa().getMesto().getId(),
									ua.getAdresa().getMesto().getNaziv(),
									new DrzavaDTO(
											ua.getAdresa().getMesto().getDrzava().getId(),
											ua.getAdresa().getMesto().getDrzava().getNaziv(),
											null),
									null)),
					null));
		}
		for (Fakultet f : univerzitet.getFakulteti()) {
			fakulteti.add(new FakultetDTO(
					f.getId(),
					f.getNaziv(),
					null,null,null,
					new NastavnikDTO(
							f.getDekan().getId(),
							null,null,
							new UserRegistrovaniKorisnikDTO(
									f.getDekan().getRegistrovaniKorisnik().getId(),
									f.getDekan().getRegistrovaniKorisnik().getUsername(),
									f.getDekan().getRegistrovaniKorisnik().getIme(),
									f.getDekan().getRegistrovaniKorisnik().getPrezime(),
									null,null,null,null,null),
							null,null,null)));
		}
		this.rektor = new NastavnikDTO(
				univerzitet.getRektor().getId(),
				null,null,
				new UserRegistrovaniKorisnikDTO(
						univerzitet.getRektor().getRegistrovaniKorisnik().getId(),
						univerzitet.getRektor().getRegistrovaniKorisnik().getUsername(),
						univerzitet.getRektor().getRegistrovaniKorisnik().getIme(),
						univerzitet.getRektor().getRegistrovaniKorisnik().getPrezime(),
						null,null,null,null,null),
				null,null,null);
	}

	public UniverzitetDTO(Long id, String naziv, Date datumOsnivanja, List<UniverzitetAdresaDTO> univerzitetAdrese,
			List<FakultetDTO> fakulteti, NastavnikDTO rektor) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.univerzitetAdrese = univerzitetAdrese;
		this.fakulteti = fakulteti;
		this.rektor = rektor;
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

	public List<UniverzitetAdresaDTO> getUniverzitetAdrese() {
		return univerzitetAdrese;
	}

	public void setUniverzitetAdrese(List<UniverzitetAdresaDTO> univerzitetAdrese) {
		this.univerzitetAdrese = univerzitetAdrese;
	}

	public List<FakultetDTO> getFakulteti() {
		return fakulteti;
	}

	public void setFakulteti(List<FakultetDTO> fakulteti) {
		this.fakulteti = fakulteti;
	}

	public NastavnikDTO getRektor() {
		return rektor;
	}

	public void setRektor(NastavnikDTO rektor) {
		this.rektor = rektor;
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
		UniverzitetDTO other = (UniverzitetDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
