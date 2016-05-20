package it.uniroma3.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.uniroma3.model.Medico;

@NamedQuery(name = "findAll", query = "SELECT m FROM Medico m")
public class MedicoDaoJPA implements MedicoDao {

	private EntityManager entityManager;

	public MedicoDaoJPA() {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("teaching-hospital-web-unit");
		this.entityManager = factory.createEntityManager();
	}

	@Override
	public void save(Medico medico) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.persist(medico);
		tx.commit();
	}

	@Override
	public Medico findByPrimaryKey(Long id) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		Medico medico = entityManager.find(Medico.class, id);
		tx.commit();
		return medico;
	}

	public Medico findByCodice(String codiceMedico){
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		Query queryFindByCodice = entityManager.createQuery(
			    "SELECT m FROM Medico m WHERE m.codice = :codiceMedico"
			);
		queryFindByCodice.setParameter("codiceMedico", codiceMedico);
		Medico medico = 
				(Medico) queryFindByCodice.getSingleResult();
		tx.commit();
		return medico;
	}
	
	@Override
	public List<Medico> findAll() {
		return this.entityManager.createNamedQuery("findAll").getResultList();
	}

	@Override
	public void update(Medico medico) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.merge(medico);
		tx.commit();
	}

	@Override
	public void delete(Medico medico) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.remove(medico);
		tx.commit();	
	}

}
