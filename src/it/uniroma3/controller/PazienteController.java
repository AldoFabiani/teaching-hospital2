package it.uniroma3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.uniroma3.model.Paziente;
import it.uniroma3.persistence.PazienteDaoJPA;

@WebServlet("/findPaziente")
public class PazienteController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codiceFiscale = req.getParameter("codiceFiscale");
		PazienteDaoJPA pazienteDao = new PazienteDaoJPA();
		Paziente paziente = pazienteDao.findByCodiceFiscale(codiceFiscale);
		String json = new Gson().toJson(paziente);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("applications/json");
		PrintWriter writer = resp.getWriter();
		writer.write(json);
	}

}
