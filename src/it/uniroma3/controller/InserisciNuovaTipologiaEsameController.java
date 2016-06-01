package it.uniroma3.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.uniroma3.model.IndicatoreDiRisultato;
import it.uniroma3.model.Norma;
import it.uniroma3.persistence.IndicatoreDiRisultatoDao;
import it.uniroma3.persistence.IndicatoreDiRisultatoDaoJPA;
import it.uniroma3.persistence.NormaDao;
import it.uniroma3.persistence.NormaDaoJPA;

@WebServlet("/inserisciNuovaTipologiaEsame")
public class InserisciNuovaTipologiaEsameController extends HttpServlet {
	private static final String UTF_8 = "UTF-8";
	private static final String APPLICATIONS_JSON = "applications/json";
	private static final long serialVersionUID = 1L;

	public InserisciNuovaTipologiaEsameController() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<IndicatoreDiRisultato> indicatoriDiRisultato = getInidicatoriDiRisulato();
		List<Norma> normeDiNorma = getNormeDiNorma();
		Map<String,Object> mappa = new HashMap<>();
		mappa.put("indicatoriDiRisultato",indicatoriDiRisultato);
		mappa.put("normeDiPreparazione",normeDiNorma);
		String responseJson = new Gson().toJson(mappa);
		resp.setContentType(APPLICATIONS_JSON);
		resp.setCharacterEncoding(UTF_8);
		resp.getWriter().write(responseJson);
	}

	private List<IndicatoreDiRisultato> getInidicatoriDiRisulato() {
		IndicatoreDiRisultatoDao id = new IndicatoreDiRisultatoDaoJPA();
		return id.findAll();
	}

	private List<Norma> getNormeDiNorma() {
		NormaDao nd= new NormaDaoJPA();
		return nd.findAll();
	}
}
