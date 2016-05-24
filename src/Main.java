import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.model.Medico;
import it.uniroma3.persistence.MedicoDao;
import it.uniroma3.persistence.MedicoDaoJPA;

public class Main {
public static void main(String[] args){
	
	MedicoDao medico = new MedicoDaoJPA();
	medico.findAll();
}
}
