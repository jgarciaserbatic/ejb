package com.ceoe.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ceoe.java.model.MyCustomBean;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String FINAL_CONTENT_TEMPLATE = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<meta charset=\"UTF-8\">\r\n" + 
			"<title>Ejemplo de uso de sesi&oacute;n</title>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"	<div class=\"row\">\r\n" + 
			"		<span>Attribute 1 : </span><span>_attr1_</span>	\r\n" + 
			"	</div>\r\n" + 
			"	<div class=\"row\">\r\n" + 
			"		<span>Attribute 2 : </span><span>_attr2_</span>\r\n" + 
			"	</div>\r\n" + 
			"	<div class=\"row\">\r\n" + 
			"		<span>Attribute 3 : </span><span>_attr3_</span>\r\n" + 
			"	</div>\r\n" +
			"</body>\r\n" + 
			"</html>";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/step1.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextStep = request.getParameter("nextStep");
		RequestDispatcher rd;
		if(nextStep != null) {
			HttpSession session = request.getSession();
			String attrValue = request.getParameter("param");
			if("step-2".equals(nextStep)) {
				MyCustomBean bean = new MyCustomBean();
				bean.setAttribute1(attrValue);
				session.setAttribute(WebConstants.MY_CUSTOM_BEAN_ATTRIBUTE, bean);
				rd = request.getRequestDispatcher("/WEB-INF/views/step2.html");
			} else if("step-3".equals(nextStep)) {
				MyCustomBean bean = (MyCustomBean) session.getAttribute(WebConstants.MY_CUSTOM_BEAN_ATTRIBUTE);
				bean.setAttribute2(attrValue);
				session.setAttribute(WebConstants.MY_CUSTOM_BEAN_ATTRIBUTE, bean);
				rd = request.getRequestDispatcher("/WEB-INF/views/step3.html");
			} else if("finish".equals(nextStep)) {
				MyCustomBean bean = (MyCustomBean) session.getAttribute(WebConstants.MY_CUSTOM_BEAN_ATTRIBUTE);
				bean.setAttribute3(attrValue);
				session.setAttribute(WebConstants.MY_CUSTOM_BEAN_ATTRIBUTE, bean);
				String content = FINAL_CONTENT_TEMPLATE;
				content = content.replace("_attr1_", bean.getAttribute1());
				content = content.replace("_attr2_", bean.getAttribute2());
				content = content.replace("_attr3_", bean.getAttribute3());
				response.getOutputStream().print(content);
				return;
			} else {
				rd = request.getRequestDispatcher("/WEB-INF/views/step1.html");
			}
		} else {
			rd = request.getRequestDispatcher("/WEB-INF/views/step1.html");
		}
		rd.forward(request, response);
	}

}
