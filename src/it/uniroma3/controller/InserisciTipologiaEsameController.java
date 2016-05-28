package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.TipologiaEsame;
import it.uniroma3.persistence.TipologiaEsameDao;
import it.uniroma3.persistence.TipologiaEsameDaoJPA;



@WebServlet("/inserisciTipologiaEsame")
public class InserisciTipologiaEsameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nomeTipologiaEsame = req.getParameter("nomeTipologiaEsame");
		String descrizioneTipologiaEsame = req.getParameter("descrizioneTipologiaEsame");
		String costoTipologiaEsame = req.getParameter("costoTipologiaEsame");
		
		TipologiaEsame nuovaTipologiaEsame = new TipologiaEsame(nomeTipologiaEsame, descrizioneTipologiaEsame, Float.valueOf(costoTipologiaEsame));
		TipologiaEsameDao dao = new TipologiaEsameDaoJPA();
		dao.save(nuovaTipologiaEsame);

	}
}
