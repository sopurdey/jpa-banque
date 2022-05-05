package fr.diginamic.banque.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	@Column(name = "NUMERO")
	private Integer numero;
	
	@Column(name = "RUE")
	private String rue;
	
	@Column(name = "CODE_POSTAL")
	private Integer codePostal;

	@Column(name = "VILLE")
	private String ville;

	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

}
