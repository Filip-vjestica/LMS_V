package system.app.dto;

import system.app.model.PohadjanjePredmeta;

public class PohadjanjePredmetaDTO {
	private Long id;
	private int konacnaOcena;
	private RealizacijaPredmetaDTO realizacijaPredmeta;
	private UserRegistrovaniKorisnikDTO registrovaniKorisnik;
	
	public PohadjanjePredmetaDTO() {
		super();
	}
	
	public PohadjanjePredmetaDTO(PohadjanjePredmeta pohadjanjePredmeta) {
		super();
		this.id = pohadjanjePredmeta.getId();
		this.konacnaOcena = pohadjanjePredmeta.getKonacnaOcena();
		this.realizacijaPredmeta = new RealizacijaPredmetaDTO(
				pohadjanjePredmeta.getRealizacijaPredmeta().getId(),
				new PredmetDTO(
						pohadjanjePredmeta.getRealizacijaPredmeta().getPredmet().getId(),
						pohadjanjePredmeta.getRealizacijaPredmeta().getPredmet().getNaziv(),
						pohadjanjePredmeta.getRealizacijaPredmeta().getPredmet().getEspb(),
						pohadjanjePredmeta.getRealizacijaPredmeta().getPredmet().getObavezan(),
						pohadjanjePredmeta.getRealizacijaPredmeta().getPredmet().getBrojPredavanja(),
						pohadjanjePredmeta.getRealizacijaPredmeta().getPredmet().getBrojVezbi(),
						pohadjanjePredmeta.getRealizacijaPredmeta().getPredmet().getBrojSemestara(),
						pohadjanjePredmeta.getRealizacijaPredmeta().getPredmet().getDrugiObliciNastave(),
						pohadjanjePredmeta.getRealizacijaPredmeta().getPredmet().getIstrazivackiRad(),
						pohadjanjePredmeta.getRealizacijaPredmeta().getPredmet().getOstaliCasovi(),
						null,null
						),
				null
				);
		this.registrovaniKorisnik = new UserRegistrovaniKorisnikDTO(
				pohadjanjePredmeta.getRegistrovaniKorisnik().getId(),
				pohadjanjePredmeta.getRegistrovaniKorisnik().getUsername(),
				pohadjanjePredmeta.getRegistrovaniKorisnik().getIme(),
				pohadjanjePredmeta.getRegistrovaniKorisnik().getPrezime(),
				null,null,null,null,null
				);
	}

	public PohadjanjePredmetaDTO(Long id, int konacnaOcena, RealizacijaPredmetaDTO realizacijaPredmeta, UserRegistrovaniKorisnikDTO registrovaniKorisnik) {
		super();
		this.id = id;
		this.konacnaOcena = konacnaOcena;
		this.realizacijaPredmeta = realizacijaPredmeta;
		this.registrovaniKorisnik = registrovaniKorisnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKonacnaOcena() {
		return konacnaOcena;
	}

	public void setKonacnaOcena(int konacnaOcena) {
		this.konacnaOcena = konacnaOcena;
	}

	public RealizacijaPredmetaDTO getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmetaDTO realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public UserRegistrovaniKorisnikDTO getRegistrovaniKorisnik() {
		return registrovaniKorisnik;
	}

	public void setRegistrovaniKorisnik(UserRegistrovaniKorisnikDTO registrovaniKorisnik) {
		this.registrovaniKorisnik = registrovaniKorisnik;
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
		PohadjanjePredmetaDTO other = (PohadjanjePredmetaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
