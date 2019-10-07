package br.com.techsow.sherlock.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.techsow.sherlock.model.entities.Curso;
import br.com.techsow.sherlock.model.interfaces.repository.ICursoRepository;
import br.com.techsow.sherlock.model.services.ConnectionFactory;

public class CursoDAO extends BaseDAO implements ICursoRepository {

	public CursoDAO() throws ClassNotFoundException, SQLException {
		conn = ConnectionFactory.getConnection();
	}

	public int add(Curso obj) throws SQLException {

		return 0;
	}

	public Curso getById(int id) throws Exception {
		stmt = conn.prepareStatement("SELECT * FROM TS_T_CURSO WHERE ID_CURSO=?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();

		if (rs.next()) 
			return new Curso(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4));

		return null;
	}

	
	public int kill(int id) throws Exception {

		return 0;
	}

	public int update(Curso obj) throws Exception {

		return 0;
	}

	public void close() throws SQLException {
		conn.close();
	}

	public int updateNome(Curso c, String nome) throws Exception {

		return 0;
	}

	public int updateDescricao(Curso c, String descricao) throws Exception {

		return 0;
	} 
	
	public ArrayList<Curso> getAll() throws Exception {
		stmt = conn.prepareStatement("SELECT * FROM TS_T_CURSO");
		rs = stmt.executeQuery();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		
		while(rs.next()) {
			Long duracao = rs.getLong(4); 
			String nome = rs.getString(3);
			String descricao = rs.getString(2);
			int id = rs.getInt(1);
			
			if(duracao == 0) 
				cursos.add(new Curso(id, nome, descricao));
			else
				cursos.add(new Curso(id,nome,descricao, duracao));				
			
			
		}
		
		return cursos;
	}

}
