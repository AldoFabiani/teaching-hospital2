package it.uniroma3.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Norma;

@Repository
public class NormaDaoJPA implements NormaDao {
	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	@Override
	@Transactional
	public void save(Norma norma) {
		this.em.persist(norma);
	}
	
	@Override
	public Norma findByPrimaryKey(Long id) {
		return null;
	}

	@Override
	public Norma findByNome(String nomeNorma) {
		Query queryFindByNome = em.createQuery("SELECT n FROM Norma n WHERE n.nome = :nomeNorma");
		queryFindByNome.setParameter("nomeNorma", nomeNorma);
		return (Norma) queryFindByNome.getSingleResult();
	}

	@Override
	public List<Norma> findAll() {
		return new ArrayList<Norma>(this.em.createNamedQuery("findAllNorme").getResultList());
	}



	// @Override
	// public void update(Norma norma) {
	// EntityTransaction tx = this.entityManager.getTransaction();
	// tx.begin();
	// entityManager.merge(norma);
	// tx.commit();
	// this.closeEntityManagerAndFactory();
	//
	// }

	// @Override
	// public void delete(Norma norma) {
	// EntityTransaction tx = this.entityManager.getTransaction();
	// tx.begin();
	// entityManager.remove(norma);
	// tx.commit();
	// this.closeEntityManagerAndFactory();
	// }

}
