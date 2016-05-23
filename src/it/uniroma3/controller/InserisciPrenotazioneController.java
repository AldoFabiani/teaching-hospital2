package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inserisciPrenotazione")
public class InserisciPrenotazioneController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InserisciPrenotazioneAction action = new InserisciPrenotazioneAction();
		InserisciPrenotazioneHelper helper = new InserisciPrenotazioneHelper();
		String nextPage="/inserisciNuovaPrenotazione.jsp";
		if(helper.validate(req)){
			nextPage=action.execute(req);
	}
		nextPage=resp.encodeURL(nextPage);
	
		ServletContext application = getServletContext();
		RequestDispatcher dispatcher = application.getRequestDispatcher(nextPage);
		dispatcher.forward(req, resp);
	}
}


