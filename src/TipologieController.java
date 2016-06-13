package it.uniroma3.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.uniroma3.model.TipologiaEsame;
import it.uniroma3.persistence.TipologiaEsameDao;
import it.uniroma3.persistence.TipologiaEsameDaoJPA;
@WebServlet("/tipologieController")
public class TipologieController extends HttpServlet{
	private static final String UTF_8 = "UTF-8";
	private static final String APPLICATIONS_JSON = "applications/json";
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TipologiaEsame> tipologieEsame = getTipologieEsame();
		String responseJson = new Gson().toJson(tipologieEsame);
		resp.setContentType(APPLICATIONS_JSON);
		resp.setCharacterEncoding(UTF_8);
		resp.getWriter().write(responseJson);
	}

	private List<TipologiaEsame> getTipologieEsame() {
		TipologiaEsameDao tipologieEsameDao= new TipologiaEsameDaoJPA();
		return tipologieEsameDao.findAll();
	}
}