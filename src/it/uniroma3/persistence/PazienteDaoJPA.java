package it.uniroma3.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.uniroma3.model.Paziente;

@NamedQuery(name = "findAll", query = "SELECT p FROM Paziente p")
public class PazienteDaoJPA implements PazienteDao {

	private EntityManager entityManager;

	public PazienteDaoJPA() {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("teaching-hospital-web-unit");
		this.entityManager = factory.createEntityManager();
	}

	@Override
	public void save(Paziente paziente) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.persist(paziente);
		tx.commit();
	}

	@Override
	public Paziente findByPrimaryKey(Long id) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		Paziente paziente = entityManager.find(Paziente.class, id);
		tx.commit();
		return paziente;
	}

	public Paziente findByCodiceFiscale(String codiceFiscalePaziente){
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		Query queryFindByCodice = entityManager.createQuery(
			    "SELECT p FROM Paziente p WHERE p.codiceFiscale = :codiceFiscalePaziente"
			);
		queryFindByCodice.setParameter("codiceFiscalePaziente", codiceFiscalePaziente);
		Paziente paziente = 
				(Paziente) queryFindByCodice.getSingleResult();
		tx.commit();
		return paziente;
	}
	
	@Override
	public List<Paziente> findAll() {
		return this.entityManager.createNamedQuery("findAll").getResultList();
	}

	@Override
	public void update(Paziente paziente) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.merge(paziente);
		tx.commit();
	}

	@Override
	public void delete(Paziente paziente) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.remove(paziente);
		tx.commit();	
	}

}
