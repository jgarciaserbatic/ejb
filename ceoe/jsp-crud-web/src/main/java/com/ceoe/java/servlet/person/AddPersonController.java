package com.ceoe.java.servlet.person;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ceoe.java.model.Person;

/**
 * Servlet implementation class AddPersonController
 */
public class AddPersonController extends AbstractPersonController {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersonController() {
    	super();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/addPerson.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer id = new Integer(request.getParameter("id"));
			String identityDoc = request.getParameter("identityDoc");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			Integer age = new Integer(request.getParameter("age"));
			Person p = new Person(id, identityDoc, firstName, lastName, age);
			this.getPersonService().addPerson(p);
			// Volvemos al listado de personas
			response.sendRedirect(request.getContextPath()+"/listPersons");
		} catch(Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/error/error.jsp");
			rd.forward(request, response);
		}
	}

}
