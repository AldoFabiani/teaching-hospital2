package it.uniroma3.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.uniroma3.model.TipologiaEsame;

public class TipologiaEsameDaoJPA extends DaoJPA implements TipologiaEsameDao {

	public TipologiaEsameDaoJPA() {
		this.factory = Persistence.createEntityManagerFactory("teaching-hospital-web-unit");
		this.entityManager = factory.createEntityManager();
	}

	@Override
	public void save(TipologiaEsame tipologiaEsame) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.persist(tipologiaEsame);
		tx.commit();
		this.closeEntityManagerAndFactory();

	}

	@Override
	public TipologiaEsame findByPrimaryKey(Long id) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		TipologiaEsame tipologiaEsame = entityManager.find(TipologiaEsame.class, id);
		tx.commit();
		this.closeEntityManagerAndFactory();

		return tipologiaEsame;
	}

	public TipologiaEsame findByNome(String nomeTipologia) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		Query queryFindByNome = entityManager
				.createQuery("SELECT t FROM TipologiaEsame t WHERE t.nome = :nomeTipologia");
		queryFindByNome.setParameter("nomeTipologia", nomeTipologia);
		TipologiaEsame tipologiaEsame = (TipologiaEsame) queryFindByNome.getSingleResult();
		tx.commit();
		this.closeEntityManagerAndFactory();

		return tipologiaEsame;
	}

	@Override
	public List<TipologiaEsame> findAll() {
		List<TipologiaEsame> resultList = this.entityManager.createNamedQuery("findAllTipologie").getResultList();
		this.closeEntityManagerAndFactory();

		return resultList;

	}

	@Override
	public void update(TipologiaEsame tipologiaEsame) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.merge(tipologiaEsame);
		tx.commit();
		this.closeEntityManagerAndFactory();

	}

	@Override
	public void delete(TipologiaEsame tipologiaEsame) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.remove(tipologiaEsame);
		tx.commit();
		this.closeEntityManagerAndFactory();

	}

}
