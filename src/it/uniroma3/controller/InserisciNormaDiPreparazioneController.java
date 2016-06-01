package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.NormaDiPreparazione;
import it.uniroma3.persistence.NormaDiPreparazioneDao;
import it.uniroma3.persistence.NormaDiPreparazioneDaoJPA;

@WebServlet("/inserisciNormaDiPreparazione")
public class InserisciNormaDiPreparazioneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String descrizione = req.getParameter("descrizione");
		
		
		NormaDiPreparazione daInserire = new NormaDiPreparazione(nome,descrizione);
		NormaDiPreparazioneDao dao = new NormaDiPreparazioneDaoJPA();
		dao.save(daInserire);
		
		resp.getWriter().write(daInserire.getId().toString());

	}
}
