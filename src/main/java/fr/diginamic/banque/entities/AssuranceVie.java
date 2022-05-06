package fr.diginamic.banque.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@DiscriminatorValue("AssuranceVie")
public class AssuranceVie extends AbstractCompte {

	@Column(name = "DATE_FIN")
	private LocalDate dateFin;

	@Column(name = "TAUX")
	private Double taux;

	public AssuranceVie() {
		super();
	}

	public AssuranceVie(String numero, Double solde, LocalDate dateFin, Double taux) {
		super(numero, solde);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	@Override
	public String getType() {
		return "AssuranceVie";
	}

	@Override
	public String toString() {
		return "AssuranceVie id=" + getId() + ", numero=" + getNumero() + ", solde=" + getSolde() + "€ dateFin="
				+ dateFin + ", taux=" + taux + "%";
	}

}
