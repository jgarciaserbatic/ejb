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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer id = Integer.parseInt(request.getParameter("id").toString());
			Person p = this.getPersonService().getPerson(id);
			if(p != null) {
				request.setAttribute("person", p);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/editPerson.jsp");
			rd.forward(request, response);
		} catch(Exception e) {
			response.getWriter().append(e.getMessage());
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	/* Recogemos las variables enviadas desde el boton (editar) del formulario */		
			Integer id = Integer.parseInt(request.getParameter("id").toString());
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			Integer age = new Integer(request.getParameter("age"));
			
	/* Creamos la clase persona con esas variables */		
			Person p = new Person();
			p.setId(id);
			p.setFirstName(firstName);
			p.setLastName(lastName);
			p.setAge(age);
   /*Llamamos al sevicio que actualiza a la persona */			
			this.getPersonService().updatePerson(p);
 
   /* Redirigimos a la lista de personas con el cambio realizado */			
		     response.sendRedirect(request.getContextPath()+"/listPersons");
			
		} catch(Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/error/error.jsp");
			response.getWriter().append(e.getMessage());
		}
	}

}
