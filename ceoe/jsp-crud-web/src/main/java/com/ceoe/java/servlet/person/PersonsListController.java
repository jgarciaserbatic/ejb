package com.ceoe.java.servlet.person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ceoe.java.model.Employee;
import com.ceoe.java.model.Person;
import com.ceoe.java.model.Persona;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		request.getSession().setAttribute("pru", descargarRespuestaREST());

		List<Persona> persons = this.getPersonService().getAllPersons();
		// List<Persona> persons = new ArrayList<Persona>();
		persons.add(new Employee(1, "Director", new Person(1, "70592661B", "Pedro", "Moreno", 12)));
		if (persons != null) {
			request.setAttribute("persons", persons);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listPersons.jsp");
		rd.forward(request, response);
	}

	private String descargarRespuestaREST() {
		try {

			String salida = "";

			URL url = new URL("http://localhost:8080/ges-hos-web/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			//conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			while ((output = br.readLine()) != null) {
				salida += output;
			}
			conn.disconnect();
			return salida;

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
			return "Sin salida";
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
