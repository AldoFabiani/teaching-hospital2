package it.uniroma3.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Indicatore;


@Repository
public class IndicatoreDaoJPA implements IndicatoreDao {
	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	@Override
	@Transactional
	public void save(Indicatore indicatore) {
		this.em.persist(indicatore);
	}

	@Override
	public Indicatore findByPrimaryKey(Long id) {
		return null;
	}

	@Override
	public Indicatore findByNome(String nomeIndicatore) {
		Query queryFindByNome = em.createQuery("SELECT i FROM Indicatore i WHERE i.nome = :nomeIndicatore");
		queryFindByNome.setParameter("nomeIndicatore", nomeIndicatore);
		return (Indicatore) queryFindByNome.getSingleResult();
	}

	@Override
	public List<Indicatore> findAll() {
		return new ArrayList<Indicatore>(this.em.createNamedQuery("findAllIndicatori").getResultList());
	}

	// @Override
	// public void update(Indicatore indicatore) {
	// EntityTransaction tx = this.entityManager.getTransaction();
	// tx.begin();
	// entityManager.merge(indicatore);
	// tx.commit();
	// this.closeEntityManagerAndFactory();
	//
	// }

	// @Override
	// public void delete(Indicatore indicatore) {
	// EntityTransaction tx = this.entityManager.getTransaction();
	// tx.begin();
	// entityManager.remove(indicatore);
	// tx.commit();
	// this.closeEntityManagerAndFactory();
	// }

}
