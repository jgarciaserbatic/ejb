package com.ceoe.java.dao;

import java.sql.SQLException;
import java.util.List;

import com.ceoe.java.model.Person;
import com.ceoe.java.model.Persona;

public interface PersonDao {
	
	public List<Persona> findAll() throws SQLException;
	
	public Persona findPerson(Integer id) throws SQLException;
	
	public Persona addPerson(Persona person) throws SQLException;
	
	public void updatePerson(Persona person) throws SQLException;
	
	public void deletePerson(Persona person) throws SQLException;

}
