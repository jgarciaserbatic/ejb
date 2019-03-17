package com.ceoe.java.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ceoe.java.dao.PersonDao;
import com.ceoe.java.dao.impl.DefaultPersonDao;
import com.ceoe.java.dao.impl.StaticListPersonDao;
import com.ceoe.java.model.Person;
import com.ceoe.java.model.Persona;
import com.ceoe.java.service.PersonService;

public class DefaultPersonService implements PersonService {

	private PersonDao personDao;

	public DefaultPersonService() {
		this.personDao = new DefaultPersonDao();
	}

	public List<Persona> getAllPersons() {
		try {
			return this.personDao.findAll();
		} catch (SQLException e) {
			System.out.println("Error buscando el listado de personas");
			return null;
		}
	}

	public Persona findPerson(int id) {
		try {
			return this.personDao.findPerson(id);
		} catch(SQLException e) {
			System.out.println("Error buscando la persona: " + id );
			return null;
		}
	}

	public Persona addPerson(Persona p) {
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

	public void updatePerson(Persona p) {
		try {
			if (this.isValid(p)) {
				this.personDao.updatePerson(p);
			}
		} catch (SQLException e) {
			System.out.println("Error creando la persona");
		}
	}

	public void deletePerson(Persona p) {
		try {
			// TODO: Validar el objeto Person p
			this.personDao.deletePerson(p);
		} catch (SQLException e) {
			System.out.println("Error creando la persona");
		}
	}

	private boolean isValid(Persona p) {
		if (p.getPersona() == null) {
			System.out.println("La persona no puede ser nula");
			return false;
		} else {
			if (p.getPersona().getId() == null) {
				System.out.println("El id no puede ser nulo");
				return false;
			}
			if (p.getPersona().getIdentityDoc() == null || p.getPersona().getIdentityDoc().length() == 0) {
				System.out.println("El identityDoc no puede ser nulo ni vacío");
				return false;
			}
			if (p.getPersona().getFirstName() == null || p.getPersona().getFirstName().length() == 0) {
				System.out.println("El first name no puede ser nulo ni vacío");
				return false;
			}
			if (p.getPersona().getLastName() == null || p.getPersona().getLastName().length() == 0) {
				System.out.println("El last name no puede ser nulo ni vacío");
				return false;
			}
			if (p.getPersona().getAge() == null || p.getPersona().getAge() <= 0) {
				System.out.println("La edad no puede ser nula ni menor que 1");
				return false;
			}
		}
		return true;
	}

}
