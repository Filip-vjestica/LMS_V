package system.app.dto;

import java.util.Date;
import system.app.model.StudentNaGodini;

public class StudentNaGodiniDTO {
	private Long id;
	private Date godina;
	private String indeks;
	private GodinaStudijaDTO godinaStudija;
	private UserRegistrovaniKorisnikDTO registrovaniKorisnik;
	
	public StudentNaGodiniDTO() {
		super();
	}
	
	public StudentNaGodiniDTO(StudentNaGodini studentNaGodini) {
		super();
		this.id = studentNaGodini.getId();
		this.godina = studentNaGodini.getGodina();
		this.indeks = studentNaGodini.getIndeks();
		this.godinaStudija = new GodinaStudijaDTO(
				studentNaGodini.getGodinaStudija().getId(),
				studentNaGodini.getGodinaStudija().getNaziv(),
				null,null,null);
		this.registrovaniKorisnik = new UserRegistrovaniKorisnikDTO(
				studentNaGodini.getRegistrovaniKorisnik().getId(),
				studentNaGodini.getRegistrovaniKorisnik().getUsername(),
				studentNaGodini.getRegistrovaniKorisnik().getIme(),
				studentNaGodini.getRegistrovaniKorisnik().getPrezime(),
				studentNaGodini.getRegistrovaniKorisnik().getJmbg(),
				null,null,null,null
				);
	}

	public StudentNaGodiniDTO(Long id, Date godina, String indeks, GodinaStudijaDTO godinaStudija, UserRegistrovaniKorisnikDTO registrovaniKorisnik) {
		super();
		this.id = id;
		this.godina = godina;
		this.indeks = indeks;
		this.godinaStudija = godinaStudija;
		this.registrovaniKorisnik = registrovaniKorisnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGodina() {
		return godina;
	}

	public void setGodina(Date godina) {
		this.godina = godina;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public GodinaStudijaDTO getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudijaDTO godinaStudija) {
		this.godinaStudija = godinaStudija;
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
		StudentNaGodiniDTO other = (StudentNaGodiniDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
