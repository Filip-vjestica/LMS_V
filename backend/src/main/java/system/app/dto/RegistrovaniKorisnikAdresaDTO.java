package system.app.dto;

import system.app.model.RegistrovaniKorisnikAdresa;

public class RegistrovaniKorisnikAdresaDTO {
	private Long id;
	private AdresaDTO adresa;
	private UserRegistrovaniKorisnikDTO registrovaniKorisnik;
	
	public RegistrovaniKorisnikAdresaDTO() {
		super();
	}
	
	public RegistrovaniKorisnikAdresaDTO(RegistrovaniKorisnikAdresa registrovaniKorisnikAdresa) {
		super();
		this.id = registrovaniKorisnikAdresa.getId();
		this.adresa = new AdresaDTO(registrovaniKorisnikAdresa.getAdresa().getId(),
				registrovaniKorisnikAdresa.getAdresa().getUlica(),
				registrovaniKorisnikAdresa.getAdresa().getBroj(),
				new MestoDTO(
						registrovaniKorisnikAdresa.getAdresa().getMesto().getId(),
						registrovaniKorisnikAdresa.getAdresa().getMesto().getNaziv(),
						new DrzavaDTO(
								registrovaniKorisnikAdresa.getAdresa().getMesto().getDrzava().getId(),
								registrovaniKorisnikAdresa.getAdresa().getMesto().getDrzava().getNaziv(),
								null
								),
						null
						));
		this.registrovaniKorisnik = new UserRegistrovaniKorisnikDTO(registrovaniKorisnikAdresa.getRegistrovaniKorisnik().getId(),
				registrovaniKorisnikAdresa.getRegistrovaniKorisnik().getUsername(),
				registrovaniKorisnikAdresa.getRegistrovaniKorisnik().getIme(),
				registrovaniKorisnikAdresa.getRegistrovaniKorisnik().getPrezime(),
				null,null,null,null,null);
	}

	public RegistrovaniKorisnikAdresaDTO(Long id, AdresaDTO adresa, UserRegistrovaniKorisnikDTO registrovaniKorisnik) {
		super();
		this.id = id;
		this.adresa = adresa;
		this.registrovaniKorisnik = registrovaniKorisnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
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
		RegistrovaniKorisnikAdresaDTO other = (RegistrovaniKorisnikAdresaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
