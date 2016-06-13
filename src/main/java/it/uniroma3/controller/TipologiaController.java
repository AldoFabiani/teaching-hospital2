package it.uniroma3.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import it.uniroma3.dao.IndicatoreDao;
import it.uniroma3.dao.IndicatoreDaoJPA;
import it.uniroma3.dao.NormaDao;
import it.uniroma3.dao.NormaDaoJPA;
import it.uniroma3.model.Indicatore;
import it.uniroma3.model.Norma;
import it.uniroma3.model.TipologiaEsame;
import it.uniroma3.service.IndicatoreService;
import it.uniroma3.service.NormaService;
import it.uniroma3.service.TipologiaEsameService;

@Controller
@RequestMapping("/tipologia")
public class TipologiaController extends WebMvcConfigurerAdapter {

	@Autowired
	private TipologiaEsameService tipologiaEsameService;
	@Autowired
	private NormaService normaService;
	@Autowired
	private IndicatoreService indicatoreEsameService;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/listTipologie", method = RequestMethod.GET)
	public @ResponseBody List<TipologiaEsame> getTipologieEsame() {
		List<TipologiaEsame> tipologie = tipologiaEsameService.listTipologie();
		
		for(TipologiaEsame tipologia : tipologie){
			tipologia.setIndicatori(new HashSet<Indicatore>());
			tipologia.setNorme(new HashSet<Norma>());
		}
		return tipologie;
	}
	
	@RequestMapping(value = "/addTipologia", method = RequestMethod.POST)
	public String addTipologieEsame() {
		String nome = this.request.getParameter("nome");
		String descrizione = this.request.getParameter("descrizione");
		Float costo = new Float(this.request.getParameter("costo"));
		TipologiaEsame daPersistere = new TipologiaEsame(nome,descrizione,costo);
		String[] norme = request.getParameterValues("norme");
		String[] indicatori = request.getParameterValues("indicatori");
		for(String nomeNorma : norme){
			daPersistere.addNorma(normaService.findNormaByNome(nomeNorma));
		}
		for(String nomeIndicatore: indicatori){
			daPersistere.addIndicatore(indicatoreEsameService.findIndicatoreByNome(nomeIndicatore));
		}
		tipologiaEsameService.insertTipologia(daPersistere);
		return "success";

	}
}
