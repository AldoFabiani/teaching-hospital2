package it.uniroma3.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class DaoJPA {
	
	protected EntityManager entityManager;
	protected EntityManagerFactory factory;
	
	protected void closeEntityManagerAndFactory(){
		entityManager.close();
		factory.close();
	}
}
