package com.ceoe.java.servlet.person;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ceoe.java.model.Person;
import com.ceoe.java.service.impl.DefaultPersonService;

/**
 * Servlet implementation class EditPersonController
 */
public class EditPersonController extends AbstractPersonController {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPersonController() {
    	super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = new Integer(request.getParameter("id"));
		Person p = new Person();
		p.setId(id);
		
		Person person = this.getPersonService().findPerson(p);
		request.setAttribute("person", person);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/editPerson.jsp");
		rd.forward(request, response);
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
			
			if(this.getPersonService().findPerson(p) != null) {
				this.getPersonService().updatePerson(p);
				// Redirigimos al Formulario de persona pero esta vez con datos.
				response.sendRedirect(request.getContextPath()+"/listPersons");
			}else{
				// En el caso de que la persona buscada no esté se le devuelve al formulario
				response.sendRedirect(request.getContextPath()+"/listPersons");
			}
		} catch(Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/error/error.jsp");
			rd.forward(request, response);
		}
	}

}
