package com.ceoe.java.service;

import java.util.List;

import com.ceoe.java.model.Person;

public interface PersonService {
	
	public List<Person> getAllPersons();
	
	public Person addPerson(Person p);
	
	public void updatePerson(Person p);
	
	public void deletePerson(Person p);
	
	public Person findPerson(Person p);

}
