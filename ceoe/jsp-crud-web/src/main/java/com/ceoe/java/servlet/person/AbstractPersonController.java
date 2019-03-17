package com.ceoe.java.servlet.person;

import javax.servlet.http.HttpServlet;

import com.ceoe.java.service.PersonService;
import com.ceoe.java.service.impl.DefaultEmployeeService;
import com.ceoe.java.service.impl.DefaultPersonService;

public abstract class AbstractPersonController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5376787058469259610L;

	private PersonService personService;
	private PersonService employeeService;

	public AbstractPersonController() {
		super();
		this.personService = new DefaultPersonService();
		this.employeeService = new DefaultEmployeeService();
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public PersonService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(PersonService employeeService) {
		this.employeeService = employeeService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
