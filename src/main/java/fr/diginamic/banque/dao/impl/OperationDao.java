package fr.diginamic.banque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.dao.Idao;
import fr.diginamic.banque.entities.Operation;

public class OperationDao extends Dao implements Idao<Operation> {

	public OperationDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Operation e) throws Exception {
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
	public boolean update(Operation e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			Operation etrans = em.find(Operation.class, e.getId());
			if (etrans != null) {
				etrans.setDate(e.getDate());
				etrans.setMontant(e.getMontant());
				etrans.setMotif(e.getMotif());
				etrans.setAbstractCompte(e.getAbstractCompte());
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
	public boolean delete(Operation e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			e = em.find(Operation.class, e.getId());
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
	public Operation getOne(Operation e) throws Exception {
		// TODO Auto-generated method stub
		TypedQuery<Operation> tqb = fd.getEm().createQuery("SELECT o FROM Operation o WHERE o.id = :id",
				Operation.class);
		tqb.setParameter("id", e.getId());

		return tqb.getResultList().get(0);
	}

	@Override
	public List<Operation> getAll() throws Exception {
		// TODO Auto-generated method stub
		TypedQuery<Operation> tqb = fd.getEm().createQuery("SELECT o FROM Operation o", Operation.class);

		return tqb.getResultList();
	}

}
