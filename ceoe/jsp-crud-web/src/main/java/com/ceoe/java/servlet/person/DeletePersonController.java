package com.ceoe.java.servlet.person;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ceoe.java.model.Person;

/**
 * Servlet implementation class DeletePersonController
 */
public class DeletePersonController extends AbstractPersonController {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePersonController() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Integer id = new Integer(request.getParameter("id"));
			Person persona =  this.getPersonService().encuentraPersona(id);
			this.getPersonService().deletePerson(persona);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listPersons.jsp");
			rd.forward(request, response);
		} catch(Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/error/error.jsp");
			rd.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
