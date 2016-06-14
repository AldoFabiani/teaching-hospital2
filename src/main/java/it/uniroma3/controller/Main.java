package it.uniroma3.controller;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.dao.PazienteDaoJPA;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.Prenotazione;

public class Main {
public static void main(String[] args){
//	TipologiaEsame t = new TipologiaEsame("tipo1","una tipologia",5F);
//	TipologiaEsameDaoJPA dao = new TipologiaEsameDaoJPA();
//	dao.save(t);
	EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
	EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
	createEntityManager.close();
	createEntityManagerFactory.close();
}
}
