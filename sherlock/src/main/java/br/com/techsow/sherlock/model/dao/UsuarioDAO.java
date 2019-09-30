package br.com.techsow.sherlock.model.dao;

import java.sql.SQLException;

import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.interfaces.repository.IUsuarioRepository;
import br.com.techsow.sherlock.model.services.ConnectionFactory;
/**
 * Classe DAO responsável pelas consultas e transações com a entidade Usuario no banco de dados
 * para a aplicação.
 * @author Breno Sapucaia
 *
 */
public class UsuarioDAO extends BaseDAO implements IUsuarioRepository{

	public UsuarioDAO() throws SQLException, ClassNotFoundException{
		conn = ConnectionFactory.getConnection();
	}
	
	public int add(Usuario obj) throws SQLException {
		
		
		
		return 0;
	}

	
	public Usuario getById(int id) throws Exception {
		
		stmt = conn.prepareStatement("SELECT * FROM  TS_T_USUARIO WHERE ID_USUARIO=?");
		stmt.setInt(1, id);
		rs=stmt.executeQuery();

		if(rs.next()) {
			return new Usuario(
					rs.getInt("ID_USUARIO"),
					rs.getString("EMAIL"),
					rs.getString("SENHA"),
					rs.getInt("ADMINISTRADOr"),
					rs.getInt("PROFESSOR"));

		}
		
		return null;
	}

	
	public int kill(int id) throws Exception {
		
		return 0;
	}

	
	public int update(Usuario obj) throws Exception {
		
		return 0;
	}

	
	public Usuario loginUser(Usuario user) throws Exception {
		stmt = conn.prepareStatement("SELECT * FROM TS_T_USUARIO WHERE EMAIL = ? AND SENHA = ?");
		stmt.setString(1, user.getEmail());
		stmt.setString(2, user.getSenha());
		rs = stmt.executeQuery();

		if(rs.next()) {
			return this.getById(rs.getInt("ID_USUARIO"));
		}else {
			return null;
		}
	}

	
	public int updateSenha(Usuario user, String senhaNova) throws Exception {
		
		return 0;
	}

	
	public int updateEmail(Usuario user, String emailNovo) throws Exception {
		
		return 0;
	}

	
	public void close() throws SQLException {
		conn.close();
	}

	
}
