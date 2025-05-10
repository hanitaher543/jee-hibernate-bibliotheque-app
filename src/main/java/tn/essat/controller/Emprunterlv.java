package tn.essat.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.essat.dao.GestionImp;
import tn.essat.dao.IGestion;
import tn.essat.model.Categorie;
import tn.essat.model.Emprunt;
import tn.essat.model.Livre;
import tn.essat.model.Utilisateur;

/**
 * Servlet implementation class Emprunterlv
 */
public class Emprunterlv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Emprunterlv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IGestion dao = new GestionImp();
		
		
		int id =Integer.parseInt(request.getParameter("id"));
		HttpSession session=request.getSession();
		Utilisateur user= (Utilisateur) session.getAttribute("user");
		LocalDate d=LocalDate.now();
		Emprunt em=new Emprunt();
		
		Livre lv=dao.getLivreById(id);
		
		
		
		em.setLv(lv);
		em.setUser(user);
		em.setDate_emprunt(d);
		dao.addEmprunt(em);
		request.getRequestDispatcher("PreCat").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
