package com.ceoe.java.servlet.person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
	}

}
