package fr.diginamic.banque.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("LivretA")
public class LivretA extends AbstractCompte {

	@Column(name = "TAUX")
	private Double taux;

	public LivretA() {
		super();
	}

	public LivretA(String numero, Double solde, Double taux) {
		super(numero, solde);
		this.taux = taux;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	@Override
	public String getType() {
		return "LivretA";
	}

	@Override
	public String toString() {
		return "LivretA id=" + getId() + ", numero=" + getNumero() + ", solde=" + getSolde() + "€" + ", taux=" + taux
				+ "%";
	}

}
