package it.uniroma3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.IBANValidator.Validator;

import com.google.gson.Gson;

import it.uniroma3.model.Medico;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.Prenotazione;
import it.uniroma3.model.TipologiaEsame;
import it.uniroma3.persistence.MedicoDaoJPA;
import it.uniroma3.persistence.PazienteDao;
import it.uniroma3.persistence.PazienteDaoJPA;
import it.uniroma3.persistence.PrenotazioneDao;
import it.uniroma3.persistence.PrenotazioneDaoJPA;
import it.uniroma3.persistence.TipologiaEsameDaoJPA;

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
		String codiceMedico = req.getParameter("medico");
		String codiceTipologia = req.getParameter("tipologia");
		String codicePaziente = req.getParameter("codiceFiscale");
		String dataEsame = req.getParameter("dataEsame");
		if(dataEsame==null)
			resp.getWriter().write("datanull");;
		
		DateValidator dateValidator = new DateValidator();
		Date data = dateValidator.validate(dataEsame.substring(0,10),"yyyy-MM-dd");
		if (codiceMedico != null) {
			MedicoDaoJPA medicoDaoJpa = new MedicoDaoJPA();
			Medico medico = medicoDaoJpa.findByCodice(codiceMedico);
			PazienteDaoJPA pazienteDao = new PazienteDaoJPA();
			Paziente paziente = pazienteDao.findByCodiceFiscale(codicePaziente);
			TipologiaEsameDaoJPA tipologiaDao = new TipologiaEsameDaoJPA();
			TipologiaEsame esame = tipologiaDao.findByNome(codiceTipologia);
			PrenotazioneDaoJPA prenotazioneDao = new PrenotazioneDaoJPA();
			Prenotazione prenotazione = new Prenotazione(data, medico, paziente, esame);
			prenotazioneDao.save(prenotazione);
		}
		else resp.getWriter().write("sono null");
	}
}
