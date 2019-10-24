package br.com.techsow.sherlock.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.interfaces.repository.IUsuarioRepository;
import br.com.techsow.sherlock.model.services.ConnectionFactory;
/**
 * Classe DAO responsável pelas consultas e transações com a entidade Usuario no banco de dados
 * para a aplicação.
 * @author Breno Sapucaia e Italo Chagas
 *
 */
public class UsuarioDAO extends BaseDAO implements IUsuarioRepository{

	public UsuarioDAO() throws SQLException, ClassNotFoundException{
		conn = ConnectionFactory.getConnection();
	}

	public int add(Usuario u) throws SQLException {

		stmt= conn.prepareStatement("insert into TS_T_USUARIO(ID_USUARIO,EMAIL,APELIDO,SENHA, ADM, PROFESSOR, ALUNO) values(c_usuario_seq.nextval,?,?,?,?,?,?)");


		stmt.setString(1, u.getEmail());
		stmt.setString(2, u.getApelido());
		stmt.setString(3, u.getSenha());
		stmt.setInt(4, u.getAdm());
		stmt.setInt(5, u.getProfessor());
		stmt.setInt(6, u.getAluno());

		return stmt.executeUpdate();

	}

	public int generateId() throws SQLException {
		int id=0;

		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USUARIOTS");
		ResultSet rs = stmt.executeQuery();

		while(rs.next()) {
			id++;

			id += 1;
		}
		return id ;	
	}

	public Usuario getById(int id) throws Exception {

		stmt = conn.prepareStatement("SELECT * FROM  TS_T_USUARIO WHERE ID_USUARIO=?");
		stmt.setInt(1, id);
		rs=stmt.executeQuery();

		if(rs.next()) {
			return new Usuario(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4),
					rs.getInt(5),
					rs.getInt(6),
					rs.getString(7));

		}

		return null;
	}
	
	
	public Usuario getByEmail(String email) throws Exception {

		stmt = conn.prepareStatement("SELECT * FROM  TS_T_USUARIO WHERE EMAIL=?");
		stmt.setString(1, email);
		rs=stmt.executeQuery();

		if(rs.next()) {
			
			Usuario usuario = new Usuario(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4),
					rs.getInt(5),
					rs.getInt(6),
					rs.getString(7));

			return usuario; 
		}

		return null;
	}
	
	public Usuario getByApelido(String apelido) throws Exception {

		stmt = conn.prepareStatement("SELECT * FROM  TS_T_USUARIO WHERE APELIDO=?");
		stmt.setString(1, apelido);
		rs=stmt.executeQuery();

		if(rs.next()) {
			return new Usuario(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4),
					rs.getInt(5),
					rs.getInt(6),
					rs.getString(7));

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
		if(user.getEmail().isEmpty()) {
			stmt = conn.prepareStatement("SELECT * FROM TS_T_USUARIO WHERE APELIDO = ? AND SENHA = ?");
			stmt.setString(1, user.getApelido());
			stmt.setString(2, user.getSenha());
		}else {
			stmt = conn.prepareStatement("SELECT * FROM TS_T_USUARIO WHERE EMAIL =? AND SENHA =?");
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getSenha());
		}
		rs = stmt.executeQuery();

		if(rs.next()) {
			return new Usuario(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4),
					rs.getInt(5),
					rs.getInt(6),
					rs.getString(7));
		}else {
			return null;
		}
	}
	
	public int updateToProfessor(Usuario user) throws Exception {
		//String senhaAntinga = usuario.getSenha();

		int idUsuario = user.getIdUsuario(); 
		stmt = conn.prepareStatement("UPDATE TS_T_USUARIO SET PROFESSOR=1 WHERE ID_USUARIO=?");

		stmt.setInt(1, idUsuario);

		return stmt.executeUpdate();
	}
	
	public int updateSenha(Usuario user, String senhaNova) throws Exception {

		int idUsuario = user.getIdUsuario(); 
		stmt = conn.prepareStatement("UPDATE TS_T_USUARIO SET SENHA =? WHERE ID_USUARIO=?");

		stmt.setString(1, senhaNova);
		stmt.setInt(2, idUsuario);

		return stmt.executeUpdate();

	}
	
	
	public int updateApelido(Usuario user, String apelidoNovo) throws Exception {

		int idUsuario = user.getIdUsuario(); 
		stmt = conn.prepareStatement("UPDATE TS_T_USUARIO SET APELIDO =? WHERE ID_USUARIO=?");

		stmt.setString(1, apelidoNovo);
		stmt.setInt(2, idUsuario);

		return stmt.executeUpdate();

	}


	public int updateEmail(Usuario user, String emailNovo) throws Exception {
		int idUsuario = user.getIdUsuario();

		stmt = conn.prepareStatement("UPDATE TS_T_USUARIO SET EMAIL =? WHERE ID_USUARIO=?");
		stmt.setString(1, emailNovo);
		stmt.setInt(2, idUsuario);

		return stmt.executeUpdate();
	}


	public void close() throws SQLException {
		conn.close();
	}


}
