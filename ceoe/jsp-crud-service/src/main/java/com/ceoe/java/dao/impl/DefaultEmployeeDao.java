package com.ceoe.java.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ceoe.java.dao.ConnectionManager;
import com.ceoe.java.model.Employee;
import com.ceoe.java.model.Person;
import com.ceoe.java.model.Persona;

public class DefaultEmployeeDao extends DefaultPersonDao {

	public List<Persona> findAll() throws SQLException {

		List<Persona> persons = new ArrayList<Persona>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id, idPerson, position FROM Employee";
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
			pstm.execute();
			rs = pstm.getResultSet();
			if (rs != null) {
				while (rs.next()) {
					persons.add(new Employee(rs.getInt("id"), rs.getString("position"),
							super.findPerson(rs.getInt("idPerson")).getPersona()));
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
			String sql = "SELECT idPerson, position FROM Employee WHERE id = ?";
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setMaxRows(1);
			pstm.execute();
			rs = pstm.getResultSet();
			if (rs != null) {
				while (rs.next()) {
					person = new Employee(id, rs.getString("position"),
							super.findPerson(rs.getInt("idPerson")).getPersona());
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

			Persona aux = super.findPerson(identifyDoc);

			String sql = "SELECT id, position FROM Employee WHERE idPerson = ?";
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
			pstm.setInt(1, aux.getPersona().getId());
			pstm.setMaxRows(1);
			pstm.execute();
			rs = pstm.getResultSet();
			if (rs != null) {
				while (rs.next()) {
					person = new Employee(rs.getInt("id"), rs.getString("position"), aux.getPersona());
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
			Persona p = super.findPerson(person.getPersona().getIdentityDoc());
			if (p == null) {
				p = super.addPerson(person);
			} else {
				Persona p2 = this.findPerson(person.getPersona().getIdentityDoc());
				if (p2 != null)
					return p2;
			}

			String sql = "INSERT INTO Employee(idPerson,position) VALUES (?,?)";
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
			pstm.setInt(1, person.getPersona().getId());
			pstm.setString(2, ((Employee) person.getPersona()).getPosition());
			pstm.executeUpdate();

			return this.findPerson(person.getPersona().getIdentityDoc());

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
				super.updatePerson(person);

				String sql = "UPDATE Employee SET position=? WHERE id=?";
				pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
				pstm.setString(1, ((Employee) person.getPersona()).getPosition());
				pstm.setInt(2, ((Employee) person.getPersona()).getIdEmployee());
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
				String sql = "DELETE FROM Employee WHERE id=?";
				pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
				pstm.setInt(1, ((Employee) persona.getPersona()).getId());
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
