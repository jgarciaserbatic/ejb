package com.ceoe.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleParamsServlet
 */
public class SampleParamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String POST_CONTENT_TEMPLATE = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<meta charset=\"UTF-8\">\r\n" + 
			"<title>Ejemplo de uso de parametros</title>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"	<div class=\"row\">\r\n" + 
			"		<span>Usuario : </span><span>_user_</span>	\r\n" + 
			"	</div>\r\n" + 
			"	<div class=\"row\">\r\n" + 
			"		<span>Password : </span><span>_password_</span>\r\n" + 
			"	</div>\r\n" + 
			"</body>\r\n" + 
			"</html>";

    /**
     * Default constructor. 
     */
    public SampleParamsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/params.html");
		rd.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String content = new String(POST_CONTENT_TEMPLATE);
		if(user != null) {
			content = content.replaceAll("_user_", user);
		} else {
			content = content.replaceAll("_user_", "no informado");
		}
		if(password != null) {
			content = content.replaceAll("_password_", password);
		} else {
			content = content.replaceAll("_password_", "no informado");
		}
		response.getOutputStream().print(content);
	}

}
