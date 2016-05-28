package it.uniroma3.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.uniroma3.model.NormaDiPreparazione;

public class NormaDiPreparazioneDaoJPA extends DaoJPA implements NormaDiPreparazioneDao {

	public NormaDiPreparazioneDaoJPA() {
		this.factory = Persistence.createEntityManagerFactory("teaching-hospital-web-unit");
		this.entityManager = factory.createEntityManager();
	}

//	@Override
//	public void save(NormaDiPreparazione normaDiPreparazione) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
//		entityManager.persist(normaDiPreparazione);
//		tx.commit();
//		this.closeEntityManagerAndFactory();
//	}

//	@Override
//	public NormaDiPreparazione findByPrimaryKey(Long id) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
//		NormaDiPreparazione normaDiPreparazione = entityManager.find(NormaDiPreparazione.class, id);
//		tx.commit();
//		this.closeEntityManagerAndFactory();
//
//		return normaDiPreparazione;
//	}

	public NormaDiPreparazione findByNome(String nomeNormaDiPreparazione) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		Query queryFindByNome = entityManager
				.createQuery("SELECT n FROM NormaDiPreparazione n WHERE n.nome = :nomeNormaDiPreparazione");
		queryFindByNome.setParameter("nomeNormaDiPreparazione", nomeNormaDiPreparazione);
		NormaDiPreparazione normaDiPreparazione = (NormaDiPreparazione) queryFindByNome.getSingleResult();
		tx.commit();
		this.closeEntityManagerAndFactory();
		return normaDiPreparazione;
	}

	@Override
	public List<NormaDiPreparazione> findAll() {
		List<NormaDiPreparazione> resultList = this.entityManager.createNamedQuery("findAllNormeDiPreparazione").getResultList();
		this.closeEntityManagerAndFactory();

		return resultList;
	}

//	@Override
//	public void update(NormaDiPreparazione normaDiPreparazione) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
//		entityManager.merge(normaDiPreparazione);
//		tx.commit();
//		this.closeEntityManagerAndFactory();
//
//	}

//	@Override
//	public void delete(NormaDiPreparazione normaDiPreparazione) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
//		entityManager.remove(normaDiPreparazione);
//		tx.commit();
//		this.closeEntityManagerAndFactory();
//	}

}
