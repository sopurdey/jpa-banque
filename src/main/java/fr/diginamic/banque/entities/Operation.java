package fr.diginamic.banque.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@Table(name = "operation")
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE", nullable = false)
	private Date date;

	@Column(name = "MONTANT")
	private Double montant;

	@Column(name = "MOTIF", length = 100, nullable = false)
	private String motif;
	
	@ManyToOne
	@JoinColumn(name = "ID_CPT")
	private AbstractCompte abstractCompte;

	public Operation() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public AbstractCompte getAbstractCompte() {
		return abstractCompte;
	}

	public void setAbstractCompte(AbstractCompte abstractCompte) {
		this.abstractCompte = abstractCompte;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", motif=" + motif + "]";
	}

}
