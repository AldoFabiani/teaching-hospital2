package it.uniroma3.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.uniroma3.model.IndicatoreDiRisultato;

public class IndicatoreDiRisultatoDaoJPA extends DaoJPA implements IndicatoreDiRisultatoDao {

	public IndicatoreDiRisultatoDaoJPA() {
		this.factory = Persistence.createEntityManagerFactory("teaching-hospital-web-unit");
		this.entityManager = factory.createEntityManager();
	}

	@Override
	public void save(IndicatoreDiRisultato indicatoreDiRisultato) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		entityManager.persist(indicatoreDiRisultato);
		tx.commit();
		this.closeEntityManagerAndFactory();
	}

	@Override
	public IndicatoreDiRisultato findByPrimaryKey(Long id) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		IndicatoreDiRisultato indicatoreDiRisultato = entityManager.find(IndicatoreDiRisultato.class, id);
		tx.commit();
		this.closeEntityManagerAndFactory();

		return indicatoreDiRisultato;
	}

	public IndicatoreDiRisultato findByNome(String nomeIndicatoreDiRisultato) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		Query queryFindByNome = entityManager
				.createQuery("SELECT i FROM IndicatoreDiRisultato i WHERE i.nome = :nomeIndicatoreDiRisultato");
		queryFindByNome.setParameter("nomeIndicatoreDiRisultato", nomeIndicatoreDiRisultato);
		IndicatoreDiRisultato indicatoreDiRisultato = (IndicatoreDiRisultato) queryFindByNome.getSingleResult();
		tx.commit();
		this.closeEntityManagerAndFactory();
		return indicatoreDiRisultato;
	}

	@Override
	public List<IndicatoreDiRisultato> findAll() {
		List<IndicatoreDiRisultato> resultList = this.entityManager.createNamedQuery("findAllIndicatoriDiRisulato").getResultList();
		this.closeEntityManagerAndFactory();

		return resultList;
	}

//	@Override
//	public void update(IndicatoreDiRisultato indicatoreDiRisultato) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
//		entityManager.merge(indicatoreDiRisultato);
//		tx.commit();
//		this.closeEntityManagerAndFactory();
//
//	}

//	@Override
//	public void delete(IndicatoreDiRisultato indicatoreDiRisultato) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
//		entityManager.remove(indicatoreDiRisultato);
//		tx.commit();
//		this.closeEntityManagerAndFactory();
//	}

}
