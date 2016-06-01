package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.IndicatoreDiRisultato;
import it.uniroma3.model.Norma;
import it.uniroma3.persistence.IndicatoreDiRisultatoDao;
import it.uniroma3.persistence.IndicatoreDiRisultatoDaoJPA;
import it.uniroma3.persistence.NormaDao;
import it.uniroma3.persistence.NormaDaoJPA;

@WebServlet("/inserisciIndicatoreDiRisultato")
public class InserisciIndicatoreDiRisultatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		
		IndicatoreDiRisultato daInserire = new IndicatoreDiRisultato(nome);
		IndicatoreDiRisultatoDao dao = new IndicatoreDiRisultatoDaoJPA();
		dao.save(daInserire);
		
		resp.getWriter().write(daInserire.getId().toString());

	}
}
