package com.ceoe.java.model;

public class Employee extends Person {

	private int idEmployee;

	private String position;

	public Employee(int idEmployee, String position, Person person) {
		super(person);
		setIdEmployee(idEmployee);
		setPosition(position);
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Person getPersona() {
		return this;
	}

}
