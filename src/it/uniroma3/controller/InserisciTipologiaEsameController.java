package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.TipologiaEsame;
import it.uniroma3.persistence.IndicatoreDao;
import it.uniroma3.persistence.IndicatoreDaoJPA;
import it.uniroma3.persistence.NormaDao;
import it.uniroma3.persistence.NormaDaoJPA;
import it.uniroma3.persistence.TipologiaEsameDao;
import it.uniroma3.persistence.TipologiaEsameDaoJPA;



@WebServlet("/inserisciTipologiaEsame")
public class InserisciTipologiaEsameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("QUI CI ARRIVO -> line 27 AGGIORNATO");
		String nome = req.getParameter("nome");
		String descrizione = req.getParameter("descrizione");
		String costo = req.getParameter("costo");

		String[] norme = req.getParameterValues("norme");
		String[] indicatori = req.getParameterValues("indicatori");
		resp.getWriter().write("QUI CI ARRIVO -> line 33" + norme[0] + " " +norme[1]);

		TipologiaEsame nuovaTipologiaEsame = new TipologiaEsame(nome, descrizione, Float.valueOf(costo));
		for(Long id : getIds(norme)){
			NormaDao daoNorma = new NormaDaoJPA();
			//			nuovaTipologiaEsame.addNorma(daoNorma.findByPrimaryKey(id));
			daoNorma.findByPrimaryKey(id);
		}
		resp.getWriter().write("QUI CI ARRIVO -> line 40");
		for(Long id: getIds(indicatori)){
			IndicatoreDao daoIndicatore = new IndicatoreDaoJPA();
			//			nuovaTipologiaEsame.addIndicatore(daoIndicatore.findByPrimaryKey(id));
			daoIndicatore.findByPrimaryKey(id);
		}
		resp.getWriter().write("QUI CI ARRIVO -> line 45");
		TipologiaEsameDao dao = new TipologiaEsameDaoJPA();
		dao.save(nuovaTipologiaEsame);

	}

	private Long[] getIds(String[] daCastare){
		if(daCastare.length>0){
			Long[] daRitornare = new Long[daCastare.length];
			for(int i=0; i<=daCastare.length-1;i++){
				daRitornare[i] = Long.parseLong(daCastare[i]);
			}
			return daRitornare;
		}
		return null;
	}

}
