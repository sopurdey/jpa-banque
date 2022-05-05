package fr.diginamic.banque.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "compte")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NUMERO", length = 20, nullable = false)
	private String numero;

	@Column(name = "SOLDE", nullable = false)
	private Double solde;
	
	@ManyToMany(mappedBy = "comptes")
	private Set<Client> clients;
	
	@OneToMany(mappedBy = "compte")
	private Set<Operation> operations;

	public Compte() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + "]";
	}

}
