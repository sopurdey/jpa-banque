package fr.diginamic.banque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.dao.Idao;
import fr.diginamic.banque.entities.AssuranceVie;

public class AssuranceVieDao extends Dao implements Idao<AssuranceVie> {

	public AssuranceVieDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(AssuranceVie e) throws Exception {
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
	public boolean update(AssuranceVie e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			AssuranceVie etrans = em.find(AssuranceVie.class, e.getId());
			if (etrans != null) {
				etrans.setNumero(e.getNumero());
				etrans.setSolde(e.getSolde());
				etrans.setClients(e.getClients());
				etrans.setOperations(e.getOperations());
				etrans.setDateFin(e.getDateFin());
				etrans.setTaux(e.getTaux());
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
	public boolean delete(AssuranceVie e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			e = em.find(AssuranceVie.class, e.getId());
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
	public AssuranceVie getOne(AssuranceVie e) throws Exception {
		// TODO Auto-generated method stub
		TypedQuery<AssuranceVie> tqb = fd.getEm().createQuery("SELECT av FROM AssuranceVie av WHERE av.id = :id",
				AssuranceVie.class);
		tqb.setParameter("id", e.getId());

		return tqb.getResultList().get(0);
	}

	@Override
	public List<AssuranceVie> getAll() throws Exception {
		// TODO Auto-generated method stub
		TypedQuery<AssuranceVie> tqb = fd.getEm().createQuery("SELECT av FROM AssuranceVie av", AssuranceVie.class);

		return tqb.getResultList();
	}

}
