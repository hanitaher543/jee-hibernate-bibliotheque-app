package tn.essat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.essat.dao.GestionImp;
import tn.essat.dao.IGestion;
import tn.essat.model.Utilisateur;

/**
 * Servlet implementation class Verif
 */
public class Verif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verif() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Utilisateur user=(Utilisateur) session.getAttribute("user");
		if(user==null)
		{
			request.getRequestDispatcher("Principale?err=2").forward(request, response);
		}
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tthebet login w mot pass s7a7
		
		
		IGestion dao=new GestionImp();
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		Utilisateur u=dao.GetUser(login, password);
		if(u==null) {
			request.getRequestDispatcher("Principale?err=1").forward(request, response);//afiche erreur
			
		}else {
			
			HttpSession session=request.getSession();
			session.setAttribute("user", u);//nemchou lil jsp espace_user
			if(u.getRole().equals("admin")) {
				
				request.getRequestDispatcher("espace_admin.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("espace_user.jsp").forward(request, response);
			}
		}
	}

}
