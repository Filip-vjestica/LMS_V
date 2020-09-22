 package system.app.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import system.app.model.Nastavnik;
import system.app.model.Zvanje;

public class ZvanjeDTO {
	private Long id;
	private Date datumIzbora;
	private Date datumPrestanka;
	private TipZvanjaDTO tipZvanja;
	private NaucnaOblastDTO naucnaOblast;
	private List<NastavnikDTO> nastavnici = new ArrayList<NastavnikDTO>();
	
	public ZvanjeDTO() {
		super();
	}
	
	public ZvanjeDTO(Zvanje zvanje) {
		super();
		this.id = zvanje.getId();
		this.datumIzbora = zvanje.getDatumIzbora();
		this.datumPrestanka = zvanje.getDatumPrestanka();
		this.tipZvanja = new TipZvanjaDTO(
				zvanje.getTipZvanja().getId(),
				zvanje.getTipZvanja().getNaziv(),
				null);
		this.naucnaOblast = new NaucnaOblastDTO(
				zvanje.getNaucnaOblast().getId(),
				zvanje.getNaucnaOblast().getNaziv(),
				null);
		for(Nastavnik n: zvanje.getNastavnici()) {
			nastavnici.add(new NastavnikDTO(
					n.getId(),
					n.getBiografija(),
					null,
					new UserRegistrovaniKorisnikDTO(
							n.getRegistrovaniKorisnik().getId(),
							n.getRegistrovaniKorisnik().getUsername(),
							n.getRegistrovaniKorisnik().getIme(),
							n.getRegistrovaniKorisnik().getPrezime(),
							null,null,null,null,null),
					null,null,null));
		}
	}

	public ZvanjeDTO(Long id, Date datumIzbora, Date datumPrestanka, TipZvanjaDTO tipZvanja, NaucnaOblastDTO naucnaOblast,
			List<NastavnikDTO> nastavnici) {
		super();
		this.id = id;
		this.datumIzbora = datumIzbora;
		this.datumPrestanka = datumPrestanka;
		this.tipZvanja = tipZvanja;
		this.naucnaOblast = naucnaOblast;
		this.nastavnici = nastavnici;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumIzbora() {
		return datumIzbora;
	}

	public void setDatumIzbora(Date datumIzbora) {
		this.datumIzbora = datumIzbora;
	}

	public Date getDatumPrestanka() {
		return datumPrestanka;
	}

	public void setDatumPrestanka(Date datumPrestanka) {
		this.datumPrestanka = datumPrestanka;
	}

	public TipZvanjaDTO getTipZvanja() {
		return tipZvanja;
	}

	public void setTipZvanja(TipZvanjaDTO tipZvanja) {
		this.tipZvanja = tipZvanja;
	}

	public NaucnaOblastDTO getNaucnaOblast() {
		return naucnaOblast;
	}

	public void setNaucnaOblast(NaucnaOblastDTO naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}

	public List<NastavnikDTO> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(List<NastavnikDTO> nastavnici) {
		this.nastavnici = nastavnici;
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
		ZvanjeDTO other = (ZvanjeDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
