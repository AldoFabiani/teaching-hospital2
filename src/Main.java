import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.model.Medico;
import it.uniroma3.persistence.MedicoDao;
import it.uniroma3.persistence.MedicoDaoJPA;

public class Main {
public static void main(String[] args){
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("teaching-hospital-web-unit");
	emf.createEntityManager();
	emf.close();
	
}
}
