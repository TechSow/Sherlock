package br.com.techsow.sherlock.model.bo;

import java.sql.SQLException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import br.com.techsow.sherlock.model.dao.UsuarioDAO;
import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.interfaces.bo.IUsuarioBO;

public class UsuarioBO implements IUsuarioBO {

	String add(Usuario user) {

		/* Não é mais necessário, ja que nome é atributo da entidade PESSOA no banco
		 * if(user.getNome().length() < 5) { return
		 * "O nome não pode ter menos que 5 caracteres"; }
		 */

		try {
			InternetAddress email = new InternetAddress(user.getEmail());
			email.validate();
		}catch(AddressException e) {
			return "E-mail inválido";
		}

		if(user.getSenha().length()  < 6) {
			return "A senha tem que ser maior que 6 caracteres.";
		}

		if(user.getEmail().length()>80) {
			return "Excedeu a quantidade de caracteres";
		}
		if(user.getSenha().length()>150) {
			return "Excedeu a quantidade de caracteres";
		}

		///////////////////////////////////////////////

		user.setEmail(user.getEmail().toLowerCase());

		//////////////////////////////////////////////

		UsuarioDAO dao = null;
		Usuario verificarId = null;

		try {
			dao= new UsuarioDAO();
			verificarId = dao.getById(user.getIdUsuario());

		}catch(Exception e) {
			e.printStackTrace();
		}

		///////////////////////////////////////
		if( verificarId != null || verificarId.getIdUsuario() > 0 ) {
			return "O usuário já existe";
		}
		//////////////////////////////////////

		int ret = 0;
		try {
			ret = dao.add(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				dao.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		return "usuario criado";

	}


////////////////////////////////////////////////////
	public Usuario getById(int id) {
		Usuario usuario = null;
		
		try (UsuarioDAO dao = new UsuarioDAO()) {
			usuario = dao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}
//////////////////////////////////////////////////

	public int kill(int id) {

		return 0;
	}

//////////////////////////////////////////////////
	public int update(Usuario obj)  {

		return 0;
	}
	
//////////////////////////////////////////////////

	public Usuario loginUser(Usuario user)  {
		Usuario usuario = null;

		try (UsuarioDAO dao = new UsuarioDAO()) {
			usuario = dao.loginUser(user);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public int updateSenha(Usuario user, String senhaNova){
				
		try (UsuarioDAO dao = new UsuarioDAO()){
			dao.updateSenha(user, senhaNova);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateEmail(Usuario user, String emailNovo){
		
		try (UsuarioDAO dao = new UsuarioDAO()){
			dao.updateEmail(user, emailNovo);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}

