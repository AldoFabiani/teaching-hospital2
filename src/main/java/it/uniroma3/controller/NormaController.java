package it.uniroma3.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import it.uniroma3.model.Norma;
import it.uniroma3.service.NormaService;

@Controller
@RequestMapping("/norma")
public class NormaController extends WebMvcConfigurerAdapter {

	@Autowired
	private NormaService normaService;
	
	@ModelAttribute("norma")
	public Norma createNormaModel() {
		return new Norma();
	}
	
	@RequestMapping(value= "/addNorma",method=RequestMethod.POST)
	public String addNorma(@ModelAttribute("norma") Norma norma){
		this.normaService.insertNorma(norma);
		return "success";

	}
	
	@RequestMapping(value= "/listNorme",method=RequestMethod.GET)
	public @ResponseBody List<Norma> listNorme(){
		return this.normaService.listNorme();
	}
	
}
