package com.ceoe.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesServlet
 */
public class CookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String COOKIE_NAME = "my-custom-cookie";

    /**
     * Default constructor. 
     */
    public CookiesServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cookies.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("cookie");
		RequestDispatcher rd;
		if(value != null && value.length() > 0) { 
			rd = request.getRequestDispatcher("/WEB-INF/views/cookies-result.html");
			Cookie cookie = new Cookie(COOKIE_NAME, value);
			response.addCookie(cookie);
		} else {
			rd = request.getRequestDispatcher("/WEB-INF/views/cookies.html");
		}
		rd.forward(request, response);
	}

}
