package it.uniroma3.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Paziente;

@Repository
public class PazienteDaoJPA implements PazienteDao {

	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	@Override
	@Transactional
	public void save(Paziente paziente) {
		em.persist(paziente);
	}

	@Override
	public Paziente findByPrimaryKey(Long id) {
		return this.em.find(Paziente.class,id);
	}
	
	@Override
	public Paziente findByCodiceFiscale(String codiceFiscalePaziente) {
		Query queryFindByCodice = em
				.createQuery("SELECT p FROM Paziente p WHERE p.codiceFiscale = :codiceFiscalePaziente");
		queryFindByCodice.setParameter("codiceFiscalePaziente", codiceFiscalePaziente);
		return (Paziente) queryFindByCodice.getSingleResult();
	}

	@Override
	public List<Paziente> findAll() {
		return new ArrayList<Paziente>(this.em.createNamedQuery("findAllPazienti").getResultList());
	}

	@Override
	@Transactional
	public void update(Paziente paziente) {
		this.em.merge(paziente);
	}

	@Override
	public void delete(Paziente paziente) {
		// TODO Auto-generated method stub
	}

}
