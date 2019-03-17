package com.ceoe.java.model;

public class Person implements Persona {

	private Integer id;
	private String identityDoc;
	private String firstName;
	private String lastName;
	private Integer age;

	public Person(int id, String identityDoc, String firstName, String lastName, int age) {
		setId(id);
		setIdentityDoc(identityDoc);
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
	}

	public Person(String identityDoc, String firstName, String lastName, int age) {
		setIdentityDoc(identityDoc);
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
	}

	public Person(Person person) {
		setId(person.getId());
		setIdentityDoc(person.getIdentityDoc());
		setFirstName(person.getFirstName());
		setLastName(person.getLastName());
		setAge(person.getAge());

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentityDoc() {
		return identityDoc;
	}

	public void setIdentityDoc(String identityDoc) {
		this.identityDoc = identityDoc;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Person getPersona() {
		return this;
	}

}
