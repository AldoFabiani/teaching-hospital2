package it.uniroma3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.uniroma3.model.Indicatore;
import it.uniroma3.persistence.IndicatoreDao;
import it.uniroma3.persistence.IndicatoreDaoJPA;

@WebServlet("/indicatori")
public class IndicatoriController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UTF_8 = "UTF-8";
	private static final String APPLICATIONS_JSON = "applications/json";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Indicatore> indicatori = getInidicatori();
		String responseJson = new Gson().toJson(indicatori);
		resp.setContentType(APPLICATIONS_JSON);
		resp.setCharacterEncoding(UTF_8);
		resp.getWriter().write(responseJson);
	}
	
	private List<Indicatore> getInidicatori() {
		IndicatoreDao id = new IndicatoreDaoJPA();
		return id.findAll();
	}
	
}
