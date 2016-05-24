import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
public static void main(String[] args){
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("teaching-hospital-web-unit");
	emf.createEntityManager();
	emf.close();
	
	MedicoDao medico = new MedicoDaoJPA();
	medico.findAll();
}
}
