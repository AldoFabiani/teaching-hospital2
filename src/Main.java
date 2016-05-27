import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.plaf.metal.MetalDesktopIconUI;

import it.uniroma3.model.Medico;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.TipologiaEsame;
import it.uniroma3.persistence.MedicoDao;
import it.uniroma3.persistence.MedicoDaoJPA;
import it.uniroma3.persistence.PazienteDaoJPA;
import it.uniroma3.persistence.TipologiaEsameDaoJPA;

public class Main {
public static void main(String[] args){
	MedicoDaoJPA medicoDao=new MedicoDaoJPA();
	Medico medico = medicoDao.findByPrimaryKey((long) 1);
	TipologiaEsameDaoJPA tip = new TipologiaEsameDaoJPA();
	TipologiaEsame tipo = tip.findByPrimaryKey((long) 1);
PazienteDaoJPA pazienteDao = new PazienteDaoJPA();
Paziente findByCodiceFiscale = pazienteDao.findByCodiceFiscale("RLNDVD94D12H501J");
System.out.println(medico);
System.out.println(tipo);
System.out.println(findByCodiceFiscale.getNome());
	
}
}
