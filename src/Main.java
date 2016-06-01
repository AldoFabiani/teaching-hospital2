import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.plaf.metal.MetalDesktopIconUI;

import it.uniroma3.model.IndicatoreDiRisultato;
import it.uniroma3.model.Medico;
import it.uniroma3.model.Norma;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.TipologiaEsame;
import it.uniroma3.persistence.MedicoDao;
import it.uniroma3.persistence.MedicoDaoJPA;
import it.uniroma3.persistence.PazienteDaoJPA;
import it.uniroma3.persistence.TipologiaEsameDaoJPA;

public class Main {
public static void main(String[] args){
	TipologiaEsame t = new TipologiaEsame("tipo1","una tipologia",5F);
//	t.addNormaDiPreparazione(new Norma("no-pregnant","esame vietato per donne incinte"));
//	t.addNormaDiPreparazione(new Norma("no-aldarelli","esame vietato per aldarelli"));
//	t.addIndicatoreDiRisultato(new IndicatoreDiRisultato("da quanto sei incinta"));
	TipologiaEsameDaoJPA dao = new TipologiaEsameDaoJPA();
	dao.save(t);
}
}
