package tn.essat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import tn.essat.dao.GestionImp;
import tn.essat.dao.IGestion;
import tn.essat.model.Utilisateur;

/**
 * Servlet implementation class ValidInscription
 */
public class ValidInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidInscription() {
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom=request.getParameter("nom");
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		String password2=BCrypt.hashpw(password, BCrypt.gensalt());
		
		
		IGestion dao=new GestionImp();
		Utilisateur u=new Utilisateur();
		u.setNom(nom);
		
		u.setLogin(login);
		u.setPassword(password2);
		u.setRole("user");
		dao.addUser(u);
		request.getRequestDispatcher("connexion.jsp").forward(request, response);
		
	}

}
