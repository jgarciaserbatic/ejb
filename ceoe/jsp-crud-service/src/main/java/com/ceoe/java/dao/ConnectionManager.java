package com.ceoe.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {

	private static ConnectionManager instance = new ConnectionManager();
	
	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cuestionario";

	// Database credentials
	private static final String USER = "root";
	private static final String PASS = "root";

	private Connection connection;

	private ConnectionManager() {
		try {
			// STEP 1: Register JDBC driver 
	        Class.forName(JDBC_DRIVER);	            
	        //STEP 2: Open a connection 
	        System.out.println("Connecting to database..."); 
	        Properties prop = new Properties();
	        prop.put("user", "root");
	        prop.put("password", "root");
	        prop.put("useUnicode", "yes");
	        prop.put("characterEncoding", "utf8");
//	        prop.put("", "");
//	        prop.put("", ""); 
	        this.connection = DriverManager.getConnection(DB_URL,prop); 
		} catch(Exception e) {
			e.printStackTrace();
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
