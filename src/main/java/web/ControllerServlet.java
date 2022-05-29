package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.EtudiantDaoImp;
import dao.IEtudiantDao;
import metier.entities.Etudiant;
@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControllerServlet extends HttpServlet {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IEtudiantDao metier;
	 @Override
	public void init() throws ServletException {
		metier = new EtudiantDaoImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			             HttpServletResponse response) 
			            throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/index.do"))
		{
			request.getRequestDispatcher("etudiants.jsp").forward(request,response);
		}
		else if (path.equals("/chercher.do"))
		{
			String rechercheDpt=request.getParameter("motCle").trim();
			EtudiantModele model= new EtudiantModele();
			model.setRechercheDpt(rechercheDpt);
			List<Etudiant> students = metier.etudiantsdpt(rechercheDpt);
			//TO-DO Find bug
			model.setEts(students);
			request.setAttribute("model", model);
			request.getRequestDispatcher("etudiants.jsp").forward(request,response);
		}
		
		else if (path.equals("/saisie.do")  )
		{
			request.getRequestDispatcher("saisieEtudiant.jsp").forward(request,response);
		}
		else if (path.equals("/save.do")  && request.getMethod().equals("POST"))
		{	/*
		    String nom=request.getParameter("nom");
		    String prenom=request.getParameter("prenom");
		    String departement=request.getParameter("departement");

			Etudiant p = metier.save(new Etudiant(nom,prenom,departement));
			request.setAttribute("etudiant", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request,response);
			*/
			
		}
		
		else if (path.equals("/supprimer.do"))
		{
		    int id= Integer.parseInt(request.getParameter("id"));
		    metier.deleteEtudiant(id);
		    response.sendRedirect("chercher.do?motCle=");
					
			//request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		
		else if (path.equals("/editer.do")  )
		{
			int id= Integer.parseInt(request.getParameter("id"));
			Etudiant p = metier.getEtudiant(id);
			System.out.print(p);
			request.setAttribute("p", p);
			request.getRequestDispatcher("editerEtudiant.jsp").forward(request,response);
			
		}
		else if (path.equals("/update.do")  )
		{	int id= Integer.parseInt(request.getParameter("id"));
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String departement=request.getParameter("departement");
			Etudiant p = new Etudiant();
			p.setId(id);
			p.setNom(nom);
			p.setPrenom(prenom);
			p.setDepartement(departement);
			System.out.print("-------------------------------");
			System.out.print(p);
			metier.updateEtudiant(p);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else
		{	
			response.sendError(Response.SC_NOT_FOUND);		
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}