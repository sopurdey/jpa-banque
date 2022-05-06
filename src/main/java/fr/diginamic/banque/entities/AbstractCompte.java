package fr.diginamic.banque.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@Table(name = "compte")
public abstract class AbstractCompte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NUMERO", length = 20, nullable = false)
	private String numero;

	@Column(name = "SOLDE", nullable = false)
	private Double solde;

	@ManyToMany(mappedBy = "abstractComptes", cascade = CascadeType.PERSIST)
	private Set<Client> clients;
	/*
	 * @OneToMany(mappedBy = "compte") private Set<Operation> operations;
	 */

	public AbstractCompte() {
		// TODO Auto-generated constructor stub
		this.clients = new HashSet<>();
		// this.operations = new HashSet<>();
	}

	public AbstractCompte(String numero, Double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
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

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	/*
	 * public Set<Operation> getOperations() { return operations; }
	 * 
	 * public void setOperations(Set<Operation> operations) { this.operations =
	 * operations; }
	 */

	public abstract String getType();

}
