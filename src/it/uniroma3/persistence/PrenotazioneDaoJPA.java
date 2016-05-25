package it.uniroma3.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.uniroma3.model.Prenotazione;

@NamedQuery(name = "findAll", query = "SELECT p FROM Prenotazione p")
public class PrenotazioneDaoJPA extends DaoJPA implements PrenotazioneDao {

	public PrenotazioneDaoJPA() {
		this.factory = Persistence.createEntityManagerFactory("teaching-hospital-web-unit");
		this.entityManager = factory.createEntityManager();
	}

	@Override
	public void save(Prenotazione prenotazione) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.persist(prenotazione);
		tx.commit();
		this.closeEntityManagerAndFactory();

	}

	@Override
	public Prenotazione findByPrimaryKey(Long id) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		Prenotazione prenotazione = entityManager.find(Prenotazione.class, id);
		tx.commit();
		this.closeEntityManagerAndFactory();

		return prenotazione;
	}

	public Prenotazione findByCodice(String codicePrenotazione) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		Query queryFindByCodice = entityManager
				.createQuery("SELECT p FROM Prenotazione p WHERE p.codice = :codicePrenotazione");
		queryFindByCodice.setParameter("codicePrenotazione", codicePrenotazione);
		Prenotazione prenotazione = (Prenotazione) queryFindByCodice.getSingleResult();
		tx.commit();
		this.closeEntityManagerAndFactory();

		return prenotazione;
	}

	@Override
	public List<Prenotazione> findAll() {
		List<Prenotazione> resultList = this.entityManager.createNamedQuery("findAll").getResultList();
		this.closeEntityManagerAndFactory();

		return resultList;
	}

	@Override
	public void update(Prenotazione prenotazione) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.merge(prenotazione);
		tx.commit();
		this.closeEntityManagerAndFactory();


	}

	@Override
	public void delete(Prenotazione prenotazione) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.remove(prenotazione);
		tx.commit();
		this.closeEntityManagerAndFactory();

	}

}
