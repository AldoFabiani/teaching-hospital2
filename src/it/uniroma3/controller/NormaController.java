package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.Norma;
import it.uniroma3.persistence.NormaDao;
import it.uniroma3.persistence.NormaDaoJPA;

@WebServlet("/norma")
public class NormaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String descrizione = req.getParameter("descrizione");
		
		
		Norma daInserire = new Norma(nome,descrizione);
		NormaDao dao = new NormaDaoJPA();
		dao.save(daInserire);
		
		resp.getWriter().write(daInserire.getId().toString());

	}
}
