package tn.essat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.essat.dao.GestionImp;
import tn.essat.dao.IGestion;
import tn.essat.model.Categorie;
import tn.essat.model.Utilisateur;

/**
 * Servlet implementation class PreCat
 */
public class PreCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();//yet7att fil tous les pages
		Utilisateur user=(Utilisateur) session.getAttribute("user");
		if(user==null)
		{
			request.getRequestDispatcher("Principale?err=2").forward(request, response);
		}
		
		
		IGestion dao=new GestionImp();
		List<Categorie>liste=dao.getAllCats();
		
		request.setAttribute("liste",liste);
		request.getRequestDispatcher("categorie.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
