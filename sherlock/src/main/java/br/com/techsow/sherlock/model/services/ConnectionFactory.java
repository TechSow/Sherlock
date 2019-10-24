package br.com.techsow.sherlock.model.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;


public class ConnectionFactory {
	public static  Connection getConnection() throws ClassNotFoundException, SQLException{
		// professor você tem que colocar na raiz do projeto lib/ojdbc6.jar
		DriverManager.registerDriver(new OracleDriver());
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", 
				"rm83214",
				"280501");
	}
}
