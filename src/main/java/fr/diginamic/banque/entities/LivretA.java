package fr.diginamic.banque.entities;

import javax.persistence.*;

@Entity
public class LivretA extends AbstractCompte {

	@Column(name = "TAUX")
	private Double taux;
	
	public LivretA() {
		super();
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "LivretA [taux=" + taux + "]";
	}
	
}
