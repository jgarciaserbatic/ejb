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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer id = Integer.parseInt(request.getParameter("id").toString());
			Person p = this.getPersonService().getPerson(id);
			if(p != null) {
				request.setAttribute("person", p);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deletePerson.jsp");
			rd.forward(request, response);
		} catch(Exception e) {
			response.getWriter().append(e.getMessage());
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	/* Recogemos las variables enviadas desde el boton (eliminar persona) del formulario */		
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
			
   /*Llamamos al sevicio que elimna a la persona */			
			this.getPersonService().deletePerson(p);
 
   /* Redirigimos a la nueva pagina con el aviso de persona eliminada y la lista con la persona eliminada */			
		     response.sendRedirect("deletePerson");
			
		} catch(Exception e) {
			response.getWriter().append(e.getMessage());
		}
	}

}
