package system.app.dto;

import system.app.model.NastavnikNaRealizaciji;

public class NastavnikNaRealizacijiDTO {
	private Long id;
	private int brojCasova;
	private String tipNastave;
	private NastavnikDTO nastavnik;
	private RealizacijaPredmetaDTO realizacijaPredmeta;
	
	public NastavnikNaRealizacijiDTO() {
		super();
	}
	
	public NastavnikNaRealizacijiDTO(NastavnikNaRealizaciji nastavnikNaRealizaciji) {
		super();
		this.id = nastavnikNaRealizaciji.getId();
		this.brojCasova = nastavnikNaRealizaciji.getBrojCasova();
		this.tipNastave = nastavnikNaRealizaciji.getTipNastave();
		this.nastavnik = new NastavnikDTO(
				nastavnikNaRealizaciji.getNastavnik().getId(),
				null,null,
				new UserRegistrovaniKorisnikDTO(
						nastavnikNaRealizaciji.getNastavnik().getRegistrovaniKorisnik().getId(),
						nastavnikNaRealizaciji.getNastavnik().getRegistrovaniKorisnik().getUsername(),
						nastavnikNaRealizaciji.getNastavnik().getRegistrovaniKorisnik().getIme(),
						nastavnikNaRealizaciji.getNastavnik().getRegistrovaniKorisnik().getPrezime(),
						null,null,null,null,null),
				null,null,null);
		this.realizacijaPredmeta = new RealizacijaPredmetaDTO(
				nastavnikNaRealizaciji.getRealizacijaPredmeta().getId(),
				new PredmetDTO(nastavnikNaRealizaciji.getRealizacijaPredmeta().getPredmet().getId(),
						nastavnikNaRealizaciji.getRealizacijaPredmeta().getPredmet().getNaziv(),
						nastavnikNaRealizaciji.getRealizacijaPredmeta().getPredmet().getEspb(),
						nastavnikNaRealizaciji.getRealizacijaPredmeta().getPredmet().getObavezan(),
						nastavnikNaRealizaciji.getRealizacijaPredmeta().getPredmet().getBrojPredavanja(),
						nastavnikNaRealizaciji.getRealizacijaPredmeta().getPredmet().getBrojVezbi(),
						nastavnikNaRealizaciji.getRealizacijaPredmeta().getPredmet().getBrojSemestara(),
						nastavnikNaRealizaciji.getRealizacijaPredmeta().getPredmet().getDrugiObliciNastave(),
						nastavnikNaRealizaciji.getRealizacijaPredmeta().getPredmet().getIstrazivackiRad(),
						nastavnikNaRealizaciji.getRealizacijaPredmeta().getPredmet().getOstaliCasovi(),
						null,null),
				null);
	}

	public NastavnikNaRealizacijiDTO(Long id, int brojCasova, String tipNastave, NastavnikDTO nastavnik,
			RealizacijaPredmetaDTO realizacijaPredmeta) {
		super();
		this.id = id;
		this.brojCasova = brojCasova;
		this.tipNastave = tipNastave;
		this.nastavnik = nastavnik;
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrojCasova() {
		return brojCasova;
	}

	public void setBrojCasova(int brojCasova) {
		this.brojCasova = brojCasova;
	}

	public String getTipNastave() {
		return tipNastave;
	}

	public void setTipNastave(String tipNastave) {
		this.tipNastave = tipNastave;
	}

	public NastavnikDTO getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(NastavnikDTO nastavnik) {
		this.nastavnik = nastavnik;
	}

	public RealizacijaPredmetaDTO getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmetaDTO realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
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
		NastavnikNaRealizacijiDTO other = (NastavnikNaRealizacijiDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
