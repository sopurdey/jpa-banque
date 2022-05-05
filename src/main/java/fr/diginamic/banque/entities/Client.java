package fr.diginamic.banque.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;

	@Column(name = "PRENOM", length = 50, nullable = false)
	private String prenom;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_NAISSANCE", nullable = false)
	private Date dateNaissance;

	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "BANQUE_ID")
	private Banque banque;

	// Client est maître dans la relation Client/Compte
	@ManyToMany
	@JoinTable(name = "CLI_CPT", joinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_CPT", referencedColumnName = "ID"))
	private Set<AbstractCompte> abstractComptes;

	public Client() {
		// TODO Auto-generated constructor stub
		this.abstractComptes = new HashSet<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Set<AbstractCompte> getComptes() {
		return abstractComptes;
	}

	public void setComptes(Set<AbstractCompte> abstractComptes) {
		this.abstractComptes = abstractComptes;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + "]";
	}

}
