package it.uniroma3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.uniroma3.model.Medico;
import it.uniroma3.model.Prenotazione;
import it.uniroma3.persistence.MedicoDaoJPA;
import it.uniroma3.persistence.PrenotazioneDao;
import it.uniroma3.persistence.PrenotazioneDaoJPA;

@WebServlet("/inserisciPrenotazione")
public class InserisciPrenotazioneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// InserisciPrenotazioneAction action = new
		// InserisciPrenotazioneAction();
		// InserisciPrenotazioneHelper helper = new
		// InserisciPrenotazioneHelper();
		// if (helper.validate(req)) {
		// action.execute(req);
		// }
		String parameter = req.getParameter("medico");
		if (parameter != null) {
			MedicoDaoJPA medicoDaoJpa = new MedicoDaoJPA();
			Medico medico = medicoDaoJpa.findByCodice(parameter);

			PrenotazioneDao prenotazioneDao = new PrenotazioneDaoJPA();
			Prenotazione prenotazione = new Prenotazione(Calendar.getInstance().getTime(), medico, null, null);
			prenotazioneDao.save(prenotazione);
		}
		else resp.getWriter().write("sono null");
	}
}
