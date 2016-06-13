package it.uniroma3.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.uniroma3.model.Indicatore;

public class IndicatoreDaoJPA extends DaoJPA implements IndicatoreDao {

	public IndicatoreDaoJPA() {
		this.factory = Persistence.createEntityManagerFactory("teaching-hospital-web-unit");
		this.entityManager = factory.createEntityManager();
	}

	@Override
	public void save(Indicatore indicatore) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.persist(indicatore);
		tx.commit();
		this.closeEntityManagerAndFactory();
	}

	@Override
	public Indicatore findByPrimaryKey(Long id) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		Indicatore indicatore = entityManager.find(Indicatore.class, id);
		tx.commit();
		this.closeEntityManagerAndFactory();

		return indicatore;
	}

	@Override
	public Indicatore findByNome(String nomeIndicatore) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		Query queryFindByNome = entityManager
				.createQuery("SELECT i FROM Indicatore i WHERE i.nome = :nomeIndicatore");
		queryFindByNome.setParameter("nomeIndicatore", nomeIndicatore);
		Indicatore indicatore = (Indicatore) queryFindByNome.getSingleResult();
		tx.commit();
		this.closeEntityManagerAndFactory();
		return indicatore;
	}

	@Override
	public List<Indicatore> findAll() {
		List<Indicatore> resultList = this.entityManager.createNamedQuery("findAllIndicatori").getResultList();
		this.closeEntityManagerAndFactory();

		return resultList;
	}

//	@Override
//	public void update(Indicatore indicatore) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
//		entityManager.merge(indicatore);
//		tx.commit();
//		this.closeEntityManagerAndFactory();
//
//	}

//	@Override
//	public void delete(Indicatore indicatore) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
//		entityManager.remove(indicatore);
//		tx.commit();
//		this.closeEntityManagerAndFactory();
//	}

}
