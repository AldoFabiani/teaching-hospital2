package it.uniroma3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import it.uniroma3.model.Medico;
import it.uniroma3.service.MedicoService;

@Controller
@RequestMapping("/medico")
public class MedicoController  extends WebMvcConfigurerAdapter{
	
	@Autowired
	private MedicoService medicoService;

	@RequestMapping(value = "/listMedici", method = RequestMethod.GET)
	public @ResponseBody List<Medico> listMedici() {
		return medicoService.listMedici();
	}
}
