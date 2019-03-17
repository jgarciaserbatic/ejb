package com.ceoe.java.ejb;

import java.sql.SQLException;
import java.util.List;

import com.ceoe.java.dao.PersonDao;
import com.ceoe.java.model.Person;

/***
 * Ejb encargado de hacer la transacción entre BBDD y la aplicación sobre personas.
 * @author jvazquez
 *
 */
public class PersonEjb implements PersonDao {

	public List<Person> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Person findPerson(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Person addPerson(Person person) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updatePerson(Person person) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void deletePerson(Person person) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public List<Person> findPersonName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
