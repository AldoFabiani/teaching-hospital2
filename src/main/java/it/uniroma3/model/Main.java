package it.uniroma3.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import it.uniroma3.model.Medico;
import it.uniroma3.model.Norma;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.Prenotazione;
import it.uniroma3.model.TipologiaEsame;

public class Main {
	public static void main(String[] args) {
		// TipologiaEsame t = new TipologiaEsame("tipo1","una tipologia",5F);
		// TipologiaEsameDaoJPA dao = new TipologiaEsameDaoJPA();
		// dao.save(t);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Norma n = new Norma("no-pregnant", "descrizione");
		entityManager.persist(n);

		Paziente paziente = new Paziente("Aldo", "Fabiani", "fbnlda", "via Bengasi", new Date(1994 - 04 - 24), "465787",
				"aldo@test.it");
		entityManager.persist(paziente);


		Medico medico = new Medico("Davide", "Orlando", "ginecologia");
		entityManager.persist(medico);
		TipologiaEsame tipologiaEsameCorrente = new TipologiaEsame("Ginecologica", "visita", new Float(30));
		entityManager.persist(tipologiaEsameCorrente);

		Prenotazione prenotazione = new Prenotazione(new Date(1994,12,11), medico, paziente, tipologiaEsameCorrente);
		Prenotazione prenotazione2 = new Prenotazione(new Date(2100,2,1), medico, paziente, tipologiaEsameCorrente);
		paziente.addPrenotazione(prenotazione);
		entityManager.merge(paziente);
		paziente.addPrenotazione(prenotazione2);
		Set<Prenotazione> prenotazioni = paziente.getPrenotazioni();
		prenotazioni.remove(prenotazione);
		entityManager.merge(paziente);

		transaction.commit();
		
		entityManager.close();
		emf.close();
	}
}
