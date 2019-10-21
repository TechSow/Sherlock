package br.com.techsow.sherlock.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author italo
 * Classe abstrata para ser implementada por todas as classes DAO. 
 */
public abstract class BaseDAO {
	protected Connection conn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
}
