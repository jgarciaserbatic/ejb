package com.ceoe.java.servlet.person;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ceoe.java.model.Person;
import com.ceoe.java.service.impl.DefaultPersonService;

/**
 * Servlet implementation class DeletePersonController
 */
public class DeletePersonController extends AbstractPersonController {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePersonController() {
    	super();
    }
        

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer id = new Integer(request.getParameter("id"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			Integer age = new Integer(request.getParameter("age"));
			Person p = new Person();
			p.setId(id);
			p.setFirstName(firstName);
			p.setLastName(lastName);
			p.setAge(age);
			this.getPersonService().deletePerson(p);
			// Volvemos al listado de personas
			response.sendRedirect(request.getContextPath()+"/listPersons");
		} catch(Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/error/error.jsp");
			rd.forward(request, response);
		}
	}

}
