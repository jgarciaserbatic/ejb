package com.ceoe.java.servlet.person;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ceoe.java.model.Employee;
import com.ceoe.java.model.Person;
import com.ceoe.java.model.Persona;
import com.ceoe.java.service.PersonService;
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final int idPersona = Integer.parseInt(request.getParameter("id"));
		final boolean empleado = (request.getParameter("EMP") != null) ? true : false;

		try {
			PersonService service = (empleado) ? this.getEmployeeService() : this.getPersonService();

			Persona persona = service.findPerson(idPersona);

			request.setAttribute("person", persona);

			String URL_SALIDA = (empleado) ? "/WEB-INF/views/editEmployee.jsp" : "/WEB-INF/views/editPerson.jsp";

			RequestDispatcher rd = request.getRequestDispatcher(URL_SALIDA);
			rd.forward(request, response);
		} catch (Exception ex) {

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			final int idPersona = Integer.parseInt(request.getParameter("id"));
			final boolean empleado = (request.getParameter("EMP") != null) ? true : false;

			String identityDoc = request.getParameter("identityDoc");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			Integer age = new Integer(request.getParameter("age"));

			PersonService service = (empleado) ? this.getEmployeeService() : this.getPersonService();

			Persona persona = new Person(idPersona, identityDoc, firstName, lastName, age);

			if (empleado) {
				int idEmployee = new Integer(request.getParameter("idEmployee"));
				String position = request.getParameter("position");
				persona = new Employee(idEmployee, position, persona.getPersona());
			}

			service.updatePerson(persona);

			response.sendRedirect(request.getContextPath() + "/listPersons");
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/error/error.jsp");
			rd.forward(request, response);
		}
	}

}
