package fr.diginamic.banque;

import fr.diginamic.banque.dao.impl.FactoryDao;

public class TestBanque {

	public static FactoryDao BANQUE;

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try {
			TestBanque.BANQUE = new FactoryDao("bddBanque");

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

}
