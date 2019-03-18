package com.ceoe.java.dao;

import java.sql.SQLException;
import java.util.List;

import com.ceoe.java.model.Person;

public interface PersonDao {
	
	public List<Person> findAll() throws SQLException;
	
	public Person findPerson(Integer id) throws SQLException;
	
	public Person addPerson(Person person) throws SQLException;
	
	public Person updatePerson(Person person) throws SQLException;
	
	public Person deletePerson(Person person) throws SQLException;

}
