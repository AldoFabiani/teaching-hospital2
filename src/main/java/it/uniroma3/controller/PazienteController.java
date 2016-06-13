package it.uniroma3.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.Prenotazione;
import it.uniroma3.service.PazienteService;

@Controller
@RequestMapping("/paziente")
public class PazienteController extends WebMvcConfigurerAdapter {
	@Autowired
	private PazienteService pazienteService;

	@ModelAttribute("paziente")
	public Paziente createPazienteModel() {
		return new Paziente();
	}
	
	@RequestMapping(value = "/find/{codiceFiscale}", method = RequestMethod.GET)
	public @ResponseBody Paziente findPaziente(@PathVariable("codiceFiscale") String codiceFiscale) {
		Paziente paziente = pazienteService.findPaziente(codiceFiscale);
		paziente.setPrenotazioni(new HashSet<Prenotazione>());
		return paziente;
	
	}

	@RequestMapping(value= "/addPaziente",method=RequestMethod.POST)
	public String addPaziente(@ModelAttribute("paziente") Paziente paziente){
		this.pazienteService.insertPaziente(paziente);
		return "success";

	}
}
