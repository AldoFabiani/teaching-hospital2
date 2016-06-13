package it.uniroma3.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.TipologiaEsame;

@Repository
public class TipologiaEsameDaoJPA implements TipologiaEsameDao {
	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	@Override
	@Transactional
	public void save(TipologiaEsame tipologiaEsame) {
		em.persist(tipologiaEsame);
	}

	@Override
	public TipologiaEsame findByPrimaryKey(Long id) {
		return null;
	}

	@Override
	public TipologiaEsame findByNome(String nomeTipologia) {

		Query queryFindByNome = em
				.createQuery("SELECT t FROM TipologiaEsame t WHERE t.nome = :nomeTipologia");
		queryFindByNome.setParameter("nomeTipologia", nomeTipologia);
		return (TipologiaEsame) queryFindByNome.getSingleResult();
		
	}
	
	@Override
	public List<TipologiaEsame> findAll() {
		return new ArrayList<TipologiaEsame>(em.createNamedQuery("findAllTipologie").getResultList());
	}

	@Override
	public void update(TipologiaEsame tipologiaEsame) {
		this.em.merge(tipologiaEsame);

	}

	@Override
	public void delete(TipologiaEsame tipologiaEsame) {
		this.em.remove(tipologiaEsame);
	}

}
