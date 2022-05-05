package fr.diginamic.banque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.dao.Idao;
import fr.diginamic.banque.entities.Virement;

public class VirementDao extends Dao implements Idao<Virement> {

	public VirementDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Virement e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		} finally {
			fd.close(em);
		}
	}

	@Override
	public boolean update(Virement e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			Virement etrans = em.find(Virement.class, e.getId());
			if (etrans != null) {
				etrans.setDate(e.getDate());
				etrans.setMontant(e.getMontant());
				etrans.setMotif(e.getMotif());
				etrans.setAbstractCompte(e.getAbstractCompte());
				etrans.setBeneficiaire(e.getBeneficiaire());
				em.merge(etrans);
				em.getTransaction().commit();
				return true;
			}
			return false;
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		} finally {
			fd.close(em);
		}
	}

	@Override
	public boolean delete(Virement e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			e = em.find(Virement.class, e.getId());
			if (e != null) {
				em.remove(e);
				em.getTransaction().commit();
				return true;
			}
			return false;

		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		} finally {
			fd.close(em);
		}
	}

	@Override
	public Virement getOne(Virement e) throws Exception {
		// TODO Auto-generated method stub
		TypedQuery<Virement> tqb = fd.getEm().createQuery("SELECT v FROM Virement v WHERE v.id = :id",
				Virement.class);
		tqb.setParameter("id", e.getId());

		return tqb.getResultList().get(0);
	}

	@Override
	public List<Virement> getAll() throws Exception {
		// TODO Auto-generated method stub
		TypedQuery<Virement> tqb = fd.getEm().createQuery("SELECT v FROM Virement v", Virement.class);

		return tqb.getResultList();
	}

}
