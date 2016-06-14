package it.uniroma3.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Prenotazione;

@Repository
public class PrenotazioneDaoJPA implements PrenotazioneDao {
	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	@Override
	@Transactional
	public void save(Prenotazione prenotazione) {
		this.em.persist(prenotazione);
	}

	@Override
	public Prenotazione findByPrimaryKey(Long id) {
		return null;
	}
	
	@Override
	public Prenotazione findByCodice(String codicePrenotazione) {

		Query queryFindByCodice = em.createQuery("SELECT p FROM Prenotazione p WHERE p.codice = :codicePrenotazione");
		queryFindByCodice.setParameter("codicePrenotazione", codicePrenotazione);
		return (Prenotazione) queryFindByCodice.getSingleResult();

	}

	@Override
	public List<Prenotazione> findAll() {
		return new ArrayList<Prenotazione>(this.em.createNamedQuery("findAllPrenotazioni").getResultList());
	}

	@Override
	public void update(Prenotazione prenotazione) {
		this.em.merge(prenotazione);

	}

	@Override
	public void delete(Prenotazione prenotazione) {
		this.delete(prenotazione);

	}

}
