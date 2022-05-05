package fr.diginamic.banque.entities;

import java.util.Date;
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

	@ManyToOne
	@JoinColumn(name = "BANQUE_ID")
	private Banque banque;

	// ClientB est maître dans la relation ClientB/Compte
	@ManyToMany
	@JoinTable(name = "CLI_CPT", joinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_CPT", referencedColumnName = "ID"))
	private Set<Compte> comptes;

	@Embedded
	private Adresse adresse;

	public Client() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "ClientBanque [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ "]";
	}

}
