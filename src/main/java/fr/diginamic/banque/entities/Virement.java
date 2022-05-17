package fr.diginamic.banque.entities;


import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Virement")
public class Virement extends Operation {

	@Column(name = "BENEFICIAIRE")
	private String beneficiaire;

	public Virement() {
		super();
	}

	public Virement(LocalDateTime date, Double montant, String motif, LivretA livretA, String beneficiaire) {
		super(date, montant, motif, livretA);
		this.beneficiaire = beneficiaire;
	}
	
	public Virement(LocalDateTime date, Double montant, String motif, AssuranceVie assuranceVie, String beneficiaire) {
		super(date, montant, motif, assuranceVie);
		this.beneficiaire = beneficiaire;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	@Override
	public String toString() {
		return "Virement [beneficiaire=" + beneficiaire + "]";
	}

}
