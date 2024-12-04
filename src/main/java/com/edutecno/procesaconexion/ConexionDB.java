package com.edutecno.procesaconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConexionDB {
	private static final String URL = "jdbc:postgresql://localhost:5432/horoscopo_db";
	private static final String USER ="postgres";
	private static final String PASS = "luisluis";
	private static Connection cnn;
	
	public static Connection getConexion() throws SQLException, ClassNotFoundException {
		if(cnn == null || cnn.isClosed()) {
			Class.forName("org.postgresql.Driver");
			cnn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("CONEXION ESTABLECIDA");
		}
		return cnn;
	}

}