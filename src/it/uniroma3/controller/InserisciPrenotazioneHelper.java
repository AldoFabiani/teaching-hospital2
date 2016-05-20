package it.uniroma3.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.DateValidator;

import it.uniroma3.model.Medico;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.TipologiaEsame;

public class InserisciPrenotazioneHelper {
	public boolean validate(HttpServletRequest request) {
		String codice,dataAvvenutaPrenotazione,dataEsame,medico,paziente,tipologiaEsame;
		
		boolean corretto = true;
		
		codice = request.getParameter("codice");
		medico = request.getParameter("medico");
		dataAvvenutaPrenotazione = request.getParameter("dataAvvenutaPrenotazione");
		dataEsame = request.getParameter("dataEsame");
		tipologiaEsame = request.getParameter("tipologiaEsame");
		paziente = request.getParameter("paziente");
		
		DateValidator dateValidator = new DateValidator();

		if (codice.equals("")) {
			corretto = false;
			request.setAttribute("codiceError", "Il codice è obbligatorio");
		}

		if (medico.equals("")) {
			corretto = false;
			request.setAttribute("medicoError", "Il medico è obbligatorio");
		}

		if (dateValidator.validate(dataAvvenutaPrenotazione, "yyyy-mm-dd") == null) {
			corretto = false;
			request.setAttribute("dataAvvenutaPrenotazioneError", "Formato data non valido");
		}
		if (dateValidator.validate(dataEsame, "yyyy-mm-dd") == null) {
			corretto = false;
			request.setAttribute("dataEsameError", "Formato data non valido");
		}

		if (dataAvvenutaPrenotazione.equals("")) {
			corretto = false;
			request.setAttribute("dataAvvenutaPrenotazioneError", "La matriocola è obbligatoria");
		}
		
		if (paziente.equals("")) {
			corretto = false;
			request.setAttribute("pazienteError", "Il paziente è obbligatorio");
		}
		
		return corretto;
	}
}
