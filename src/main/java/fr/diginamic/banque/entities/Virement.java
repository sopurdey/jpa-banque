package fr.diginamic.banque.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Virement")
public class Virement extends Operation {

	@Column(name = "BENEFICIAIRE")
	private String beneficiaire;

	public Virement() {
		super();
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
