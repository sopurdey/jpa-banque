package fr.diginamic.banque;

import java.time.LocalDate;

import fr.diginamic.banque.dao.impl.AssuranceVieDao;
import fr.diginamic.banque.dao.impl.BanqueDao;
import fr.diginamic.banque.dao.impl.ClientDao;
import fr.diginamic.banque.dao.impl.FactoryDao;
import fr.diginamic.banque.dao.impl.LivretADao;
import fr.diginamic.banque.entities.Adresse;
import fr.diginamic.banque.entities.AssuranceVie;
import fr.diginamic.banque.entities.Banque;
import fr.diginamic.banque.entities.Client;
import fr.diginamic.banque.entities.LivretA;

public class TestBanque {

	public static FactoryDao BANQUE;

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try {
			TestBanque.BANQUE = new FactoryDao("bddBanque");

			BanqueDao bdo = new BanqueDao(TestBanque.BANQUE);
			ClientDao cdo = new ClientDao(TestBanque.BANQUE);
			LivretADao lado = new LivretADao(TestBanque.BANQUE);
			AssuranceVieDao avdo = new AssuranceVieDao(TestBanque.BANQUE);

			// Création d'une banque
			Banque boe = new Banque("Bank of England");
			Banque boa = new Banque("Bank of America");
			Banque ca = new Banque("Crédit Agricole");
			bdo.add(boe);
			bdo.add(boa);
			bdo.add(ca);

			// Création de clients
			Client bob = new Client("DYLAN", "Bob", LocalDate.of(1941, 5, 24),
					new Adresse(1, "High Street", 12345, "Londres"), boe);
			Client joe = new Client("BLOGGS", "Joe", LocalDate.of(1977, 3, 15),
					new Adresse(1, "Main Street", 97531, "New York"), boa);

			// Persistence des données
			cdo.add(bob);
			cdo.add(joe);
			// System.out.println(bob);
			// System.out.println(joe);
			cdo.getAll().forEach(coi -> System.out.println(coi + " - " + coi.getAdresse()));

			/* Insérer un compte associé à 2 clients */
			LivretA cpt1 = new LivretA("LA123", 1000.23, 0.5);
			lado.add(cpt1);
			System.out.println(cpt1);
			bob.getComptes().add(cpt1);
			joe.getComptes().add(cpt1);
			cdo.update(bob);
			cdo.update(joe);

			System.out.println(bob + " - " + bob.getComptes());
			System.out.println(joe + " - " + joe.getComptes());
			System.out.println(lado.getOne(cpt1).getClients());

			/*
			 * Insérer un client avec plusieurs comptes : 1 compte de type assurance vie & 1
			 * compte de type livret A
			 */
			Client pierre = new Client("DUPONT", "Pierre", LocalDate.of(1984, 8, 6),
					new Adresse(91, "rue de Rivoli", 75001, "Paris"), ca);
			cdo.add(pierre);
			LivretA la = new LivretA("LA456", 650.91, 0.75);
			AssuranceVie av = new AssuranceVie("AV123", 2370.59, LocalDate.of(2045, 5, 26), 1.5);
			lado.add(la);
			avdo.add(av);

			pierre.getComptes().add(la);
			pierre.getComptes().add(av);
			cdo.update(pierre);

			System.out.println(pierre + " - " + pierre.getComptes());

			/* Insérer des opérations de type virements sur un compte */
			
			/* Insérer des opérations de type opérations sur un compte*/

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

}
