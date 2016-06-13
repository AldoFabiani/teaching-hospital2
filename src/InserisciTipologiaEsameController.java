package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.Norma;
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
		resp.getWriter().write("Arrivo a fare la post");
		String nome = req.getParameter("nome");
		String descrizione = req.getParameter("descrizione");
		String costo = req.getParameter("costo");
		resp.getWriter().write("\nRaccolti: nome, costo e descrizione");
		String[] norme = req.getParameterValues("norme");
		String[] indicatori = req.getParameterValues("indicatori");
		resp.getWriter().write("\nRaccolti: norme e indicatori");

		TipologiaEsame nuovaTipologiaEsame = new TipologiaEsame(nome, descrizione, Float.valueOf(costo));
		resp.getWriter().write("Creato oggetto tipologia!");
		for(String nomeNorma : norme){
			NormaDao daoNorma = new NormaDaoJPA();
			Norma normaDaAggiungere = daoNorma.findByNome(nomeNorma);
			resp.getWriter().write("\n\tNorma trovata");
			nuovaTipologiaEsame.addNorma(normaDaAggiungere);
			resp.getWriter().write("\n\tNorma aggiunta");
//			daoNorma.findByNome(nomeNorma);
		}
		resp.getWriter().write("\nHo iterato sulle norme e aggiunte alle tipologia");
		for(String nomeIndicatore: indicatori){
			IndicatoreDao daoIndicatore = new IndicatoreDaoJPA();
			nuovaTipologiaEsame.addIndicatore(daoIndicatore.findByNome(nomeIndicatore));
//			daoIndicatore.findByNome(nomeIndicatore);
		}
		resp.getWriter().write("\nHo iterato sugli indicatori e aggiunti alle tipologia");;
		TipologiaEsameDao dao = new TipologiaEsameDaoJPA();
		dao.save(nuovaTipologiaEsame);
		resp.getWriter().write("QUI CI ARRIVO -> FINITO!");

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
