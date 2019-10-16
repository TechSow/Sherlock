package br.com.techsow.sherlock.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.techsow.sherlock.model.entities.Unanswered;
import br.com.techsow.sherlock.model.interfaces.repository.IUnansweredRepository;

public class UnansweredDAO extends BaseDAO implements IUnansweredRepository{

	
	public int add(Unanswered obj) throws SQLException {
		if(obj.getAudio() != null) {
			stmt = conn.prepareStatement("INSERT INTO TS_T_UNANSWERED(ID_USUARIO, MENSAGEM, AUDIO) VALUES(?,?,?)");
			stmt.setInt(1, obj.getId_usuario());
			stmt.setString(2, obj.getMensagem());
			stmt.setBlob(3, obj.getAudio());
		}else {
			stmt = conn.prepareStatement("INSERT INTO TS_T_UNANSWERED(ID_USUARIO, MENSAGEM) VALUES(?,?)");
			stmt.setInt(1, obj.getId_usuario());
			stmt.setString(2, obj.getMensagem());
		}
		return stmt.executeUpdate();
	}

	
	public Unanswered getById(int id) throws Exception {
		
		return null;
	}

	
	public int kill(int id) throws Exception {
		
		return 0;
	}

	
	public int update(Unanswered obj) throws Exception {
		
		return 0;
	}

	
	public void close() throws SQLException {
		conn.close();
	}

	
	public List<Unanswered> getAll() throws Exception {
		
		return null;
	}

	
	public List<Unanswered> getAllByIdUsuario(int id_usuario) throws Exception {
		
		return null;
	}

}
