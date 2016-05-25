package it.uniroma3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.google.gson.Gson;

import it.uniroma3.model.Medico;

import it.uniroma3.model.THWeb;
import it.uniroma3.model.TipologiaEsame;
import it.uniroma3.persistence.MedicoDaoJPA;
import it.uniroma3.persistence.TipologiaEsameDao;
import it.uniroma3.persistence.TipologiaEsameDaoJPA;

@WebServlet("/inserisciNuovaPrenotazione")
public class InserisciNuovaPrenotazioneController extends HttpServlet {
	private static final String UTF_8 = "UTF-8";
	private static final String APPLICATIONS_JSON = "applications/json";
	private static final long serialVersionUID = 1L;

	public InserisciNuovaPrenotazioneController() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Medico> medici = getMedici();
		List<TipologiaEsame> tipologieEsame = getTipologieEsame();
		req.setAttribute("medici", medici);
		req.setAttribute("tipologieEsame", tipologieEsame);
		Map<String,Object> mappa = new HashMap<>();
		mappa.put("medici",medici);
		mappa.put("tipologie",tipologieEsame);
		String responseJson = new Gson().toJson(mappa);
		resp.setContentType(APPLICATIONS_JSON);
		resp.setCharacterEncoding(UTF_8);
		resp.getWriter().write(responseJson);
	}

	private List<Medico> getMedici() {
		MedicoDaoJPA md = new MedicoDaoJPA();
		return md.findAll();
	}

	private List<TipologiaEsame> getTipologieEsame() {
		TipologiaEsameDao tipologieEsameDao= new TipologiaEsameDaoJPA();
		return tipologieEsameDao.findAll();
	}
}
