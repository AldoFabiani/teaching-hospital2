package it.uniroma3.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class DaoJPA {
	
	private EntityManager entityManager;
	private EntityManagerFactory factory;
	
	public void closeEntityManagerAndFactory(){
		entityManager.close();
		factory.close();
	}
}
