package it.uniroma3.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.uniroma3.model.Norma;

public class NormaDaoJPA extends DaoJPA implements NormaDao {

	public NormaDaoJPA() {
		this.factory = Persistence.createEntityManagerFactory("teaching-hospital-web-unit");
		this.entityManager = factory.createEntityManager();
	}

	@Override
	public void save(Norma norma) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.persist(norma);
		tx.commit();
		this.closeEntityManagerAndFactory();
	}

	@Override
	public Norma findByPrimaryKey(Long id) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		Norma norma = entityManager.find(Norma.class, id);
		tx.commit();
		this.closeEntityManagerAndFactory();

		return norma;
	}

	@Override
	public Norma findByNome(String nomeNorma) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		Query queryFindByNome = entityManager
				.createQuery("SELECT n FROM Norma n WHERE n.nome = :nomeNorma");
		queryFindByNome.setParameter("nomeNorma", nomeNorma);
		Norma norma = (Norma) queryFindByNome.getSingleResult();
		tx.commit();
		this.closeEntityManagerAndFactory();
		return norma;
	}

	@Override
	public List<Norma> findAll() {
		List<Norma> resultList = this.entityManager.createNamedQuery("findAllNorme").getResultList();
		this.closeEntityManagerAndFactory();

		return resultList;
	}

//	@Override
//	public void update(Norma norma) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
//		entityManager.merge(norma);
//		tx.commit();
//		this.closeEntityManagerAndFactory();
//
//	}

//	@Override
//	public void delete(Norma norma) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
//		entityManager.remove(norma);
//		tx.commit();
//		this.closeEntityManagerAndFactory();
//	}

}
