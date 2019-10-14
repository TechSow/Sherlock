package br.com.techsow.sherlock.model.bo;

import java.sql.SQLException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import br.com.techsow.sherlock.model.dao.UsuarioDAO;
import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.exception.ApelidoException;
import br.com.techsow.sherlock.model.exception.DuplicatedIdException;
import br.com.techsow.sherlock.model.exception.EmailNotFound;
import br.com.techsow.sherlock.model.interfaces.bo.IUsuarioBO;

public class UsuarioBO implements IUsuarioBO {

	/**
	 * @author Italo
	 * 
	 *         Classe criada para efetuar as validacoes da entidade Usuario
	 *         Essa classe é chamada pela classe CadastroUsuario
	 */
	public String add(Usuario user) {

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
			return "Senha muito pequena.";
		}

		if(user.getEmail().length()>80) {
			return "Email excedeu a quantidade de caracteres";
		}
		if(user.getSenha().length()>150) {
			return "Senha excedeu a quantidade de caracteres";
		}

		///////////////////////////////////////////////

		user.setEmail(user.getEmail().toLowerCase());

		//////////////////////////////////////////////

		UsuarioDAO dao = null;
		Usuario usuario = null;

		try {
			dao= new UsuarioDAO();
			usuario = dao.getById(user.getIdUsuario());

			if(usuario != null) throw new DuplicatedIdException("Usuario com ID duplicado");
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			dao= new UsuarioDAO();
			usuario = dao.getByEmail(user.getEmail());

			if(usuario != null) { return "Email já cadastrado"; }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			dao= new UsuarioDAO();
			usuario = dao.getByApelido(user.getApelido());

			if(usuario != null) throw new ApelidoException("Apelido indisponível");
		}catch(Exception e) {
			e.printStackTrace();
		}
				

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

		return "Usuario criado";

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
	public Usuario getByEmail(String email) {
		Usuario usuario = null;
		
		try (UsuarioDAO dao = new UsuarioDAO()) {
			usuario = dao.getByEmail(email);
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
	
<<<<<<< HEAD
	public Usuario getByEmail(String email) throws EmailNotFound {
		Usuario usuario = null;
		
		try(UsuarioDAO dao = new UsuarioDAO()){
			usuario = dao.getByEmail(email);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(usuario == null) throw new EmailNotFound("O usuário com este e-mail não existe");
		
		
		return usuario;
=======
	public String updateToProfessor(Usuario user){
		
		try (UsuarioDAO dao = new UsuarioDAO()){
			dao.updateToProfessor(user);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Usuario " + user.getApelido() + " agora é professor";
>>>>>>> develop
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

