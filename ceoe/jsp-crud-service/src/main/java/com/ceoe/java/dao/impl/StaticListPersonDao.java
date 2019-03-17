package com.ceoe.java.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ceoe.java.dao.PersonDao;
import com.ceoe.java.model.Person;
import com.ceoe.java.model.Persona;

public class StaticListPersonDao implements PersonDao {

	private static List<Person> personas = null;

	private List<Person> getPersonas() {
		/*if (personas == null) {
			personas = new ArrayList<Person>();
			personas.add(new Person(1, "Carlos", "Padilla", 22));
			personas.add(new Person(2, "Pedro", "Sanchez", 19));
			personas.add(new Person(3, "Lorena", "Mota", 31));
			personas.add(new Person(4, "Martin", "Romero", 26));
			personas.add(new Person(5, "Jesus", "Hernan", 17));
			personas.add(new Person(6, "Pablo", "Lopez", 13));
			personas.add(new Person(7, "Mirella", "Ponderosa", 32));
			personas.add(new Person(8, "Bernardo", "Diaz", 29));
			personas.add(new Person(9, "Josefa", "Perez", 27));
			personas.add(new Person(10, "Nuria", "Gonzalez", 23));
		}
		return personas;*/
		return null;
	}

	private void setPeronas(List<Person> lista) {
		personas = lista;
	}

	public List<Persona> findAll() throws SQLException {
		return null;
	}

	public Person findPerson(Integer id) throws SQLException {
		for (Person per : getPersonas()) {
			if (per.getId().equals(id))
				return per;
		}
		return null;
	}

	public Person addPerson(Person person) throws SQLException {
		List<Person> personas = getPersonas();
		personas.add(person);
		setPeronas(personas);
		return person;
	}

	public void updatePerson(Person person) throws SQLException {
		List<Person> personas = getPersonas();
		System.out.println("Salidneod");
		for (Person per : personas) {
			if (per.getId().equals(person.getId())) {
				personas.remove(per);
				personas.add(person);
				setPeronas(personas);
				break;
			}
		}

	}

	public void deletePerson(Person person) throws SQLException {
		List<Person> personas = getPersonas();

		for (Person per : personas) {
			if (per.getId().equals(person.getId())) {
				personas.remove(per);
				setPeronas(personas);
				break;
			}
		}
	}

	public Persona addPerson(Persona person) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updatePerson(Persona person) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void deletePerson(Persona person) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
