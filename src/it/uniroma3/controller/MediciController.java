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

import it.uniroma3.model.Medico;
import it.uniroma3.persistence.MedicoDaoJPA;
@WebServlet("/mediciController")
public class MediciController extends HttpServlet{
	private static final String UTF_8 = "UTF-8";
	private static final String APPLICATIONS_JSON = "applications/json";
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Medico> medici = getMedici();
		String responseJson = new Gson().toJson(medici);
		resp.setContentType(APPLICATIONS_JSON);
		resp.setCharacterEncoding(UTF_8);
		resp.getWriter().write(responseJson);
	}

	private List<Medico> getMedici() {
		MedicoDaoJPA md = new MedicoDaoJPA();
		return md.findAll();
	}
}
