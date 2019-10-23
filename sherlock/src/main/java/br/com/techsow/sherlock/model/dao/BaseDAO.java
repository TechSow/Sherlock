package br.com.techsow.sherlock.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.techsow.sherlock.model.entities.Pessoa;

public abstract class BaseDAO {
	protected Connection conn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	public int updateNome(Pessoa pessoa, String nomeNovo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
