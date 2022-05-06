package fr.diginamic.banque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.dao.Idao;
import fr.diginamic.banque.entities.Client;
import fr.diginamic.banque.entities.LivretA;
import fr.diginamic.banque.entities.Operation;

public class LivretADao extends Dao implements Idao<LivretA> {

	public LivretADao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(LivretA e) throws Exception {
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
	public boolean update(LivretA e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			LivretA etrans = em.find(LivretA.class, e.getId());
			if (etrans != null) {
				etrans.setNumero(e.getNumero());
				etrans.setSolde(e.getSolde());
				etrans.setClients(e.getClients());
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
	public boolean delete(LivretA e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			e = em.find(LivretA.class, e.getId());
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
	public LivretA getOne(LivretA e) throws Exception {
		// TODO Auto-generated method stub
		TypedQuery<LivretA> tqb = fd.getEm().createQuery("SELECT la FROM LivretA la WHERE la.id = :id", LivretA.class);
		tqb.setParameter("id", e.getId());

		return tqb.getResultList().get(0);
	}

	@Override
	public List<LivretA> getAll() throws Exception {
		// TODO Auto-generated method stub
		TypedQuery<LivretA> tqb = fd.getEm().createQuery("SELECT la FROM LivretA la", LivretA.class);

		return tqb.getResultList();
	}



}
