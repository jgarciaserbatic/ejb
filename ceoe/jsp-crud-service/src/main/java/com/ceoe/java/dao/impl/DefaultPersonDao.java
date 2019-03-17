package com.ceoe.java.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ceoe.java.dao.ConnectionManager;
import com.ceoe.java.dao.PersonDao;
import com.ceoe.java.model.Person;

public class DefaultPersonDao implements PersonDao {
	
	public List<Person> findAll() throws SQLException {
		List<Person> persons = new ArrayList<Person>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id,firstName,lastName,age FROM Person";
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
			pstm.execute();
			rs = pstm.getResultSet();
			if(rs != null) {				
				while(rs.next()) {
					Person person = new Person();
					person.setId(rs.getInt("id"));
					person.setFirstName(rs.getString("firstName"));
					person.setLastName(rs.getString("lastName"));
					person.setAge(rs.getInt("age"));
					persons.add(person);
				}
			}
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
		return persons;
	}
	
	public Person findPerson(Integer id) throws SQLException {
		Person person = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id,firstName,lastName,age FROM Person WHERE id = ?";
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setMaxRows(1);
			pstm.execute();
			rs = pstm.getResultSet();
			if(rs != null) {				
				while(rs.next()) {
					person = new Person();
					person.setId(id);
					person.setFirstName(rs.getString("firstName"));
					person.setLastName(rs.getString("lastName"));
					person.setAge(rs.getInt("age"));
				}
			}
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
		return person;
	}

	public Person addPerson(Person person) throws SQLException {
		PreparedStatement pstm = null;
		try {
			Person p = this.findPerson(person.getId());
			if(p == null) {
				String sql = "INSERT INTO Person(id,firstName,lastName,age) VALUES (?,?,?,?)";
				pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
				pstm.setInt(1, person.getId());
				pstm.setString(2, person.getFirstName());
				pstm.setString(3, person.getLastName());
				pstm.setInt(4, person.getAge());
				pstm.executeUpdate();
				return this.findPerson(person.getId());
			} else {
				return null;
			}
		} finally {
			if(pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
	}

	//Metodo en el service que actualiza un usuario.
	public void updatePerson(Person person) throws SQLException {
		PreparedStatement pstm = null;
		try {
			String sqlUpdate = "UPDATE Person SET firstName='" + person.getFirstName() + "', lastName='" + person.getLastName()
			+ "', age='" + person.getAge() + "'  WHERE id='" + person.getId() + "'";
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sqlUpdate);
			pstm.executeUpdate(sqlUpdate);
			
		}finally {
			if(pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
		
	}

	//Metodo en el service que elimina un usuario.
	public void deletePerson(Person person) throws SQLException {
		PreparedStatement pstm = null;
		try {
			String sqlDelete = "DELETE FROM Person WHERE firstName='" + person.getFirstName() + "', lastName='" + person.getLastName()
			+ "', age='" + person.getAge() + "'  WHERE id='" + person.getId() + "'";
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sqlDelete);
			pstm.executeUpdate(sqlDelete);
			
		}finally {
			if(pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
		
	}

	public List<Person> findPersonName(String name) throws SQLException {
		List<Person> persons = new ArrayList<Person>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id,firstName,lastName,age FROM Person where name= '"+ name+"';";
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
			pstm.execute();
			rs = pstm.getResultSet();
			if(rs != null) {				
				while(rs.next()) {
					Person person = new Person();
					person.setId(rs.getInt("id"));
					person.setFirstName(rs.getString("firstName"));
					person.setLastName(rs.getString("lastName"));
					person.setAge(rs.getInt("age"));
					persons.add(person);
				}
			}
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
		return persons;
	}	

}
