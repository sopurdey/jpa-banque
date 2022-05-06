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

	/**
	 * Constructor avec champs
	 * @param numero Integer
	 * @param rue String
	 * @param codePostal Integer
	 * @param ville String
	 */
	public Adresse(Integer numero, String rue, Integer codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

}
