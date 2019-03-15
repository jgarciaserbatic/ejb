package com.ceoe.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	private static ConnectionManager instance = new ConnectionManager();
	
	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "org.h2.Driver";
	private static final String DB_URL = "jdbc:h2:~/test";

	// Database credentials
	private static final String USER = "sa";
	private static final String PASS = "";

	private Connection connection;

	private ConnectionManager() {
		try {
			// STEP 1: Register JDBC driver 
	        Class.forName(JDBC_DRIVER);	            
	        //STEP 2: Open a connection 
	        System.out.println("Connecting to database..."); 
	        this.connection = DriverManager.getConnection(DB_URL,USER,PASS); 
		} catch(Exception e) {
			System.out.println("Error inicializando la BBDD, imposible continuar");
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

}
