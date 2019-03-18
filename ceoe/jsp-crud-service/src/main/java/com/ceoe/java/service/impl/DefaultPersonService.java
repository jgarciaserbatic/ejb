package com.ceoe.java.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ceoe.java.dao.PersonDao;
import com.ceoe.java.dao.impl.DefaultPersonDao;
import com.ceoe.java.model.Person;
import com.ceoe.java.service.PersonService;

public class DefaultPersonService implements PersonService {

	private PersonDao personDao;

	public DefaultPersonService() {
		this.personDao = new DefaultPersonDao();
	}

	public List<Person> getAllPersons() {
		try {
			return this.personDao.findAll();
		} catch (SQLException e) {
			System.out.println("Error buscando el listado de personas");
			return null;
		}
	}

	public Person addPerson(Person p) {
		try {
			if (this.isValid(p)) {
				return this.personDao.addPerson(p);
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Error creando la persona");
			return null;
		}
	}

	public void updatePerson(Person p) {
		try {
			if (this.isValid(p)) {
				this.personDao.updatePerson(p);
			}
		} catch (SQLException e) {
			System.out.println("Error creando la persona");
		}
	}

	public void deletePerson(Person p) {
		try {
			if (this.isValidPersonForUpdate(p)) {
				this.personDao.deletePerson(p);
			}
		} catch (SQLException e) {
			System.out.println("Error borrando la persona");
		}
	}

	public Person findPerson(Person p) {
		Person person = null;
		if (isValidPersonForUpdate(p) == true) {
			try {
				person = this.personDao.findPerson(p.getId());
			} catch (SQLException e) {
				System.out.println("Error actualizando persona");
			}
		}
		return person;
	}

	private boolean isValid(Person p) {
		if (p == null) {
			System.out.println("La persona no puede ser nula");
			return false;
		} else {
			if (p.getId() == null) {
				System.out.println("El id no puede ser nulo");
				return false;
			}
			if (p.getFirstName() == null || p.getFirstName().length() == 0) {
				System.out.println("El first name no puede ser nulo ni vacío");
				return false;
			}
			if (p.getLastName() == null || p.getLastName().length() == 0) {
				System.out.println("El last name no puede ser nulo ni vacío");
				return false;
			}
			if (p.getAge() == null || p.getAge() <= 0) {
				System.out.println("La edad no puede ser nula ni menor que 1");
				return false;
			}
		}
		return true;
	}

	private boolean isValidPersonForUpdate(Person p) {
		if (p == null) {
			System.out.println("La persona no puede ser nula");
			return false;
		} else {
			if (p.getId() == null) {
				System.out.println("El id no puede ser nulo");
				return false;
			}
			return true;
		}
	}
}
