package fr.diginamic.banque.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
public class AssuranceVie extends AbstractCompte {

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_FIN")
	private Date dateFin;
	
	@Column(name = "TAUX")
	private Double taux;
	
	public AssuranceVie() {
		super();
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "AssuranceVie [dateFin=" + dateFin + ", taux=" + taux + "]";
	}
}
