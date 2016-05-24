package it.uniroma3.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.model.Medico;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.Prenotazione;
import it.uniroma3.model.THWeb;

public class InserisciPrenotazioneAction {
	private THWeb thWeb;
	
	public String execute(HttpServletRequest request){
		this.thWeb = new THWeb();
		Prenotazione prenotazione = new Prenotazione();

		Medico medico = this.thWeb.findMedico(request.getParameter("medico"));
		prenotazione.setMedico(medico);
		
		prenotazione.setCodice(request.getParameter("codice"));

		Paziente paziente = this.thWeb.findPaziente(request.getParameter("paziente"));
		prenotazione.setPaziente(paziente);
		
		Date dataEsama = new Date(request.getParameter("dataEsame"));
		prenotazione.setDataEsame(dataEsama);
		
		
		thWeb.addPrenotazione(prenotazione);
		request.setAttribute("prenotazione",prenotazione);
		return "/rivevuta.jsp";
	}
}
