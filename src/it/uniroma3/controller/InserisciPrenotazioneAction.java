package it.uniroma3.controller;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.model.Prenotazione;
import it.uniroma3.model.THWeb;

public class InserisciPrenotazioneAction {
	
	public String execute(HttpServletRequest request){
		Prenotazione prenotazione = Prenotazione();
		prenotazione.setDataEsame(request.getParameter("dataEsame"));
		prenotazione.setCodice(request.getParameter("codice"));
		prenotazione.setMedico(request.getParameter("medico"));
		prenotazione.setPaziente(request.getParameter("paziente"));
		
		THWeb thWeb = new THWeb();
		thWeb.addPrenotazione(prenotazione);
		request.setAttribute("prenotazione",prenotazione);
		return "/rivevuta.jsp";
	}
}
