import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.plaf.metal.MetalDesktopIconUI;

import it.uniroma3.model.Indicatore;
import it.uniroma3.model.Medico;
import it.uniroma3.model.Norma;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.TipologiaEsame;
import it.uniroma3.persistence.MedicoDao;
import it.uniroma3.persistence.MedicoDaoJPA;
import it.uniroma3.persistence.NormaDao;
import it.uniroma3.persistence.NormaDaoJPA;
import it.uniroma3.persistence.PazienteDaoJPA;
import it.uniroma3.persistence.TipologiaEsameDaoJPA;

public class Main {
public static void main(String[] args){
//	TipologiaEsame t = new TipologiaEsame("tipo1","una tipologia",5F);
//	TipologiaEsameDaoJPA dao = new TipologiaEsameDaoJPA();
//	dao.save(t);
	NormaDao daoN = new NormaDaoJPA();
	
	Norma n = new Norma("no-pregnant","descrizione");
	daoN.save(n);
	System.out.println(n);
}
}
