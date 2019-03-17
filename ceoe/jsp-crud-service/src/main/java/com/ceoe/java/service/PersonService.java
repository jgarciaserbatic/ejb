package com.ceoe.java.service;

import java.util.List;

import com.ceoe.java.model.Person;
import com.ceoe.java.model.Persona;

public interface PersonService {
	
	
	
	public List<Persona> getAllPersons();
	
	public Persona findPerson(int id);
	
	public Persona addPerson(Persona p);
	
	public void updatePerson(Persona p);
	
	public void deletePerson(Persona p);

}
