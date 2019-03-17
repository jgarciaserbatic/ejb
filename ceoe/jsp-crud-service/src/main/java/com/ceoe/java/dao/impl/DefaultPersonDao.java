package com.ceoe.java.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ceoe.java.dao.ConnectionManager;
import com.ceoe.java.dao.PersonDao;
import com.ceoe.java.model.Person;
import com.ceoe.java.model.Persona;

public class DefaultPersonDao implements PersonDao {

	public List<Persona> findAll() throws SQLException {

		List<Persona> persons = new ArrayList<Persona>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id, identityDoc,firstName,lastName,age FROM Person";
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
			pstm.execute();
			rs = pstm.getResultSet();
			if (rs != null) {
				while (rs.next()) {
					persons.add(new Person(rs.getInt("id"), rs.getString("identityDoc"), rs.getString("firstName"),
							rs.getString("lastName"), rs.getInt("age")));
				}
			}
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return persons;

	}

	public Persona findPerson(Integer id) throws SQLException {

		Person person = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id, identityDoc, firstName,lastName,age FROM Person WHERE id = ?";
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setMaxRows(1);
			pstm.execute();
			rs = pstm.getResultSet();
			if (rs != null) {
				while (rs.next()) {
					person = new Person(id, rs.getString("identityDoc"), rs.getString("firstName"),
							rs.getString("lastName"), rs.getInt("age"));
				}
			}
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return person;

	}

	public Persona findPerson(String identifyDoc) throws SQLException {

		Person person = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id, identityDoc, firstName, lastName, age FROM Person WHERE identityDoc = ?";
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
			pstm.setString(1, identifyDoc);
			pstm.setMaxRows(1);
			pstm.execute();
			rs = pstm.getResultSet();
			if (rs != null) {
				while (rs.next()) {
					person = new Person(rs.getInt("id"), identifyDoc, rs.getString("firstName"),
							rs.getString("lastName"), rs.getInt("age"));
				}
			}
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return person;

	}

	public Persona addPerson(Persona person) throws SQLException {
		PreparedStatement pstm = null;
		try {
			Persona p = this.findPerson(person.getPersona().getIdentityDoc());
			if (p == null) {
				String sql = "INSERT INTO Person(identityDoc,firstName,lastName,age) VALUES (?,?,?,?)";
				pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
				pstm.setString(1, person.getPersona().getIdentityDoc());
				pstm.setString(2, person.getPersona().getFirstName());
				pstm.setString(3, person.getPersona().getLastName());
				pstm.setInt(4, person.getPersona().getAge());
				pstm.executeUpdate();
				return this.findPerson(person.getPersona().getId());
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void updatePerson(Persona person) throws SQLException {
		PreparedStatement pstm = null;
		try {
			Persona p = this.findPerson(person.getPersona().getId());
			if (p != null) {
				String sql = "UPDATE Person SET identityDoc=?, firstName=?, lastName=?, age=? WHERE id=?";
				pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
				pstm.setString(1, person.getPersona().getIdentityDoc());
				pstm.setString(2, person.getPersona().getFirstName());
				pstm.setString(3, person.getPersona().getLastName());
				pstm.setInt(4, person.getPersona().getAge());
				pstm.setInt(4, person.getPersona().getId());
				pstm.executeUpdate();
			}
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void deletePerson(Persona persona) throws SQLException {
		PreparedStatement pstm = null;
		try {
			Persona p = this.findPerson(persona.getPersona().getIdentityDoc());
			if (p != null) {
				String sql = "DELETE FROM Person WHERE id=?";
				pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
				pstm.setInt(1, p.getPersona().getId());
				pstm.executeUpdate();
			}
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
