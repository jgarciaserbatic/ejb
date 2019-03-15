package com.ceoe.java.servlet.person;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ceoe.java.model.Person;

/**
 * Servlet implementation class PersonsListController
 */
public class PersonsListController extends AbstractPersonController {

    /**
     * Default constructor. 
     */
    public PersonsListController() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Person> persons = this.getPersonService().getAllPersons();
		if(persons != null) {
			request.setAttribute("persons", persons);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listPersons.jsp");
		rd.forward(request, response);
	}

}
