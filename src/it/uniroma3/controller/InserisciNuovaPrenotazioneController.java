package it.uniroma3.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inserisciNuovaPrenotazione")
public class InserisciNuovaPrenotazioneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InserisciNuovaPrenotazioneController() {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Medico> medici = getMedici();
		ArrayList<TipologiaEsame> tipologieEsame = getTipologieEsame();
		req.setAttribute("medici",medici);
		req.setAttribute("tipologieEsame", tipologieEsame);
		req.setAttribute("prova", "prova");  //x Davide
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/prenotazione.jsp");
		dispatcher.forward(req, resp);
	}
}
