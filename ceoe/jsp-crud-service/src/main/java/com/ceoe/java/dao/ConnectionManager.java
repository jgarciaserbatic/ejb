package com.ceoe.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	private static ConnectionManager instance = new ConnectionManager();

	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "org.h2.Driver";
	private static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";

	// Database credentials
	private static final String USER = "sa";
	private static final String PASS = "";

	private Connection connection;

	private ConnectionManager() {
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);
			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			this.connection = DriverManager.getConnection(DB_URL, USER, PASS);

			createDataBase();

		} catch (Exception e) {
			System.out.println("Error inicializando la BBDD, imposible continuar");
			System.out.print(e.getLocalizedMessage());
			throw new RuntimeException(e);
		}
	}

	public static final ConnectionManager getInstance() {
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	private void createDataBase() {
		String person = "CREATE TABLE IF NOT EXISTS Person (id INT AUTO_INCREMENT, identityDoc VARCHAR(100), firstName VARCHAR(100), lastName VARCHAR(100), age INT)";
		String employee = "CREATE TABLE IF NOT EXISTS Employee (id INT, idPerson INT, position VARCHAR(100))";
		createTable(person);
		createTable(employee);

	}

	private void createTable(String sqlCreate) {
		Statement stmt;
		try {
			stmt = getConnection().createStatement();
			stmt.execute(sqlCreate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
