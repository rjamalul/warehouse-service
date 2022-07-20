package com.skillstorm.conf;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class WarehousesDbCreds {
	
//	static {
//
//	}
	
	private static WarehousesDbCreds instance;
	private String url;
	private String username;
	private String password;
	
	private WarehousesDbCreds() {
		
			try {
				//Load it into memory so I have it
				Class.forName("com.mysql.jdbc.Driver");
				
				//Read properties from application.properties
				try (InputStream input = WarehousesDbCreds.class.getClassLoader()
						.getResourceAsStream("application.properties")) {
					
					Properties props = new Properties();
					props.load(input); //load in file we open
					
					//grabs the creds
					this.url = props.getProperty("db.url");
					this.password = props.getProperty("db.password");
					this.username = props.getProperty("db.username");
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	
	
	public static WarehousesDbCreds getInstance() {
		if (instance == null) { //Lazily initialize connection to DB
			instance = new WarehousesDbCreds();
		}
		return instance;
		
	}


	public String getUrl() {
		return url;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}
	
	//Makes it simpler to receive a connection
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	
}
