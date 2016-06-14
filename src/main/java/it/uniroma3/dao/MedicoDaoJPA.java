package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.model.Medico;

@Repository
public class MedicoDaoJPA implements MedicoDao {

	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	@Override
	public void save(Medico medico) {
		em.persist(medico);
	}

	@Override
	public Medico findByPrimaryKey(Long id) {
		return null;
	}

	@Override
	public Medico findByCodice(String codiceMedico) {
		Query queryFindByCodice = em.createQuery("SELECT m FROM Medico m WHERE m.codice = :codiceMedico");
		queryFindByCodice.setParameter("codiceMedico", codiceMedico);
		return (Medico) queryFindByCodice.getSingleResult();
	}

	@Override
	public List<Medico> findAll() {
		List resultList = this.em.createNamedQuery("findAll").getResultList();
		return resultList;
	}

	@Override
	public void update(Medico medico) {
		this.em.merge(medico);
	}

	@Override
	public void delete(Medico medico) {
	}

}
