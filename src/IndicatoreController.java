package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.Indicatore;
import it.uniroma3.persistence.IndicatoreDao;
import it.uniroma3.persistence.IndicatoreDaoJPA;

@WebServlet("/indicatore")
public class IndicatoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		
		Indicatore daInserire = new Indicatore(nome);
		IndicatoreDao dao = new IndicatoreDaoJPA();
		dao.save(daInserire);
		
		resp.getWriter().write(daInserire.getId().toString());

	}
}
