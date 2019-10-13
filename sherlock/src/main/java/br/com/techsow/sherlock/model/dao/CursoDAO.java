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

	public int add(Curso c) throws SQLException {

		stmt = conn.prepareStatement("INSERT INTO TS_T_CURSO(c_curso_seq.nextval,NOME,DESCRICAO,DURACAO, DIFICULDADE, URLIMG)VALUES(?,?,?,?,?)");
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getDescricao());
		stmt.setLong(3, c.getDuracao());
		stmt.setInt(4, c.getDificuldade());
		stmt.setString(5, c.getUrlImg());
		return stmt.executeUpdate();
		
	}

	public Curso getById(int id) throws Exception {
		stmt = conn.prepareStatement("SELECT * FROM TS_T_CURSO WHERE ID_CURSO=?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();

		if (rs.next()) 
			return new Curso(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4),rs.getString(5), rs.getInt(6));

		return null;
	}

	
	public int getCursoId(int cod) throws Exception {
		stmt = conn.prepareStatement("SELECT ID_CURSO FROM TS_T_CURSO WHERE ID_CURSO=?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("ID_CURSO");

		} else {
			return rs.getInt("ID_CURSO");
		}
	}
	
	@Override
	public int updateNome(Curso c, String nomeNovo) throws Exception {
		stmt = conn.prepareStatement("UPDATE TS_T_CURSO SET NOME=? WHERE ID_MATERIA=?");
		stmt.setString(1, nomeNovo);
		stmt.setInt(2, c.getId_curso());
		return stmt.executeUpdate();

	}
	
	@Override
	public int updateDescricao(Curso c, String novaDescricao) throws Exception {
		stmt = conn.prepareStatement("UPDATE TS_T_CURSO SET DESCRICAO=? WHERE ID_CURSO=?");
		stmt.setString(1, novaDescricao);
		stmt.setInt(2, c.getId_curso());
		return stmt.executeUpdate();
	}
	
	public int updateDuracao(Curso c, String novaDuracao) throws Exception {
		stmt = conn.prepareStatement("UPDATE TS_T_CURSO SET DURACAO=? WHERE ID_CURSO=?");
		stmt.setString(1, novaDuracao);
		stmt.setInt(2, c.getId_curso());
		return stmt.executeUpdate();
	}
	
	
	public int updateUrl(Curso c, String novaUrl) throws Exception {
		stmt = conn.prepareStatement("UPDATE TS_T_CURSO SET DURACAO=? WHERE ID_CURSO=?");
		stmt.setString(1, novaUrl);
		stmt.setInt(2, c.getId_curso());
		return stmt.executeUpdate();
	}
	
	
	public int updateDificuldade(Curso c, int novaDificuldade) throws Exception {
		stmt = conn.prepareStatement("UPDATE TS_T_CURSO SET DIFICULDADE=? WHERE ID_CURSO=?");
		stmt.setInt(1, novaDificuldade);
		stmt.setInt(2, c.getId_curso());
		return stmt.executeUpdate();
	}
	
	@Override
	public int kill(Curso c) throws Exception {

		stmt = conn.prepareStatement("DELETE FROM TS_T_CURSO WHERE ID_CURSO=?");
		stmt.setInt(1, c.getId_curso());
		return stmt.executeUpdate();	}


	public void close() throws SQLException {
		conn.close();
	}

		
	
	
	/*
	 * 
	 * implementar tabela de ts_t_curso_usuario "curso 1 --> n curso"
	 * OSB: Ja existe tabela ts_t_usu_cur
	 * 
	 */
	
	public ArrayList<Curso> getAll() throws Exception {
		stmt = conn.prepareStatement("SELECT * FROM TS_T_CURSO");
		rs = stmt.executeQuery();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		
		while(rs.next()) {
			Long duracao = rs.getLong(4); 
			String nome = rs.getString(3);
			String descricao = rs.getString(2);
			String urlImg = rs.getString(5);
			int dificuldade = rs.getInt(6);
			int id = rs.getInt(1);
			if(duracao == 0 && urlImg.isEmpty() && dificuldade == 0) 
				cursos.add(new Curso(id, nome, descricao));
			else
				cursos.add(new Curso(id,nome,descricao, duracao, urlImg,dificuldade));				
			
			
		}
		
		return cursos;
	}


	@Override
	public int update(Curso obj) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int kill(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



}
