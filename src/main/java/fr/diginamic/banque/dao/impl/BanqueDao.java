package fr.diginamic.banque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.dao.Idao;
import fr.diginamic.banque.entities.Banque;

public class BanqueDao extends Dao implements Idao<Banque> {

	public BanqueDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Banque e) throws Exception {
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
	public boolean update(Banque e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			Banque etrans = em.find(Banque.class, e.getId());
			if (etrans != null) {
				etrans.setNom(e.getNom());
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
	public boolean delete(Banque e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			e = em.find(Banque.class, e.getId());
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
	public Banque getOne(Banque e) throws Exception {
		// TODO Auto-generated method stub
		TypedQuery<Banque> tqb = fd.getEm().createQuery("SELECT b FROM Banque b WHERE b.id = :id", Banque.class);
		tqb.setParameter("id", e.getId());

		return tqb.getResultList().get(0);
	}

	@Override
	public List<Banque> getAll() throws Exception {
		// TODO Auto-generated method stub
		TypedQuery<Banque> tqb = fd.getEm().createQuery("SELECT b FROM Banque b", Banque.class);

		return tqb.getResultList();
	}

}
