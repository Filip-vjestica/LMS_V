package system.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Zvanje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Date datumIzbora;
	@Column(nullable = false)
	private Date datumPrestanka;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private TipZvanja tipZvanja;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private NaucnaOblast naucnaOblast;
	@OneToMany(mappedBy = "zvanje")
	private List<Nastavnik> nastavnici = new ArrayList<Nastavnik>();
	
	public Zvanje() {
		super();
	}

	public Zvanje(Long id, Date datumIzbora, Date datumPrestanka, TipZvanja tipZvanja, NaucnaOblast naucnaOblast,
			List<Nastavnik> nastavnici) {
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

	public TipZvanja getTipZvanja() {
		return tipZvanja;
	}

	public void setTipZvanja(TipZvanja tipZvanja) {
		this.tipZvanja = tipZvanja;
	}

	public NaucnaOblast getNaucnaOblast() {
		return naucnaOblast;
	}

	public void setNaucnaOblast(NaucnaOblast naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}

	public List<Nastavnik> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(List<Nastavnik> nastavnici) {
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
		Zvanje other = (Zvanje) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
