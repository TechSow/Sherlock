package br.com.techsow.sherlock.model.bo;

import java.sql.SQLException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import br.com.techsow.sherlock.model.dao.UsuarioDAO;
import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.exception.ApelidoException;
import br.com.techsow.sherlock.model.exception.DuplicatedException;
import br.com.techsow.sherlock.model.exception.EmailNotFound;
import br.com.techsow.sherlock.model.exception.LengthException;
import br.com.techsow.sherlock.model.exception.NotEqualsException;
import br.com.techsow.sherlock.model.interfaces.bo.IUsuarioBO;

public class UsuarioBO implements IUsuarioBO {

	/**
	 * @author Italo
	 * 
	 *         Classe criada para efetuar as validacoes da entidade Usuario
	 *         Essa classe é chamada pela classe CadastroUsuario
	 * @throws LengthException 
	 */
	public String add(Usuario user) throws DuplicatedException,ApelidoException, EmailNotFound, LengthException {

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

		if(user.getSenha().length()  < 6) throw new  LengthException("Senha não corresponde as exigências de tamanho");
		if(user.getEmail().length()>80) throw new  LengthException("Email excedeu quantidade de caracteres");
		if(user.getSenha().length()>150) throw new  LengthException("Senha excedeu quantidade de caracteres");

		///////////////////////////////////////////////

		user.setEmail(user.getEmail().toLowerCase());

		//////////////////////////////////////////////


		Usuario usuario = null;

		try (UsuarioDAO dao= new UsuarioDAO()){

			usuario = dao.getById(user.getIdUsuario());

		}catch(Exception e) {
			e.printStackTrace();

		}
		if(usuario != null) throw new DuplicatedException("Usuario com ID duplicado");


		try (UsuarioDAO dao= new UsuarioDAO()){

			usuario = dao.getByEmail(user.getEmail());

		}catch(Exception e) {
			e.printStackTrace();

		}
		if(usuario != null) throw new DuplicatedException("Email ja cadastrado.");


		try (UsuarioDAO dao= new UsuarioDAO()){

			usuario = dao.getByApelido(user.getApelido());		

		}catch(Exception e) {
			e.printStackTrace();
		}

		if(usuario != null) throw new ApelidoException("Apelido indisponível");


		int ret =0;
		try (UsuarioDAO dao= new UsuarioDAO()) {
			ret = dao.add(user);
		}catch(Exception e){
			e.printStackTrace();

		}finally {
			try (UsuarioDAO dao= new UsuarioDAO()){
				dao.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		if(ret == 1) {
			return "Usuario criado";
		}else {
			return "Não foi possivel cadastrar o usuario";
		}
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


	public int kill(int id) {

		return 0;
	}


	public int update(Usuario obj)  {

		return 0;
	}

	public Usuario loginUser(Usuario user)  {
		Usuario usuario = null;

		try (UsuarioDAO dao = new UsuarioDAO()) {
			usuario = dao.loginUser(user);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return usuario;

	}


	public Usuario getByEmail(String email) throws EmailNotFound {
		Usuario usuario = null;

		try(UsuarioDAO dao = new UsuarioDAO()){
			usuario = dao.getByEmail(email);
		}catch (Exception e) {
			e.printStackTrace();
		}

		if(usuario == null) throw new EmailNotFound("O usuário com este e-mail não existe");


		return usuario;
	}

	public String updateToProfessor(Usuario user){

		try (UsuarioDAO dao = new UsuarioDAO()){
			dao.updateToProfessor(user);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Usuario " + user.getApelido() + " agora é professor";

	}

	public int updateSenha(String email, String senhaNova, String confirmarSenha) throws NotEqualsException, EmailNotFound{

		if(!(senhaNova.equals(confirmarSenha))) throw new NotEqualsException("Senhas não coincidem");

		Usuario user;
		try {
			user = this.getByEmail(email);
		} catch (EmailNotFound e1) {
			throw new EmailNotFound(e1.getMessage());
		}

		try (UsuarioDAO dao = new UsuarioDAO()){
			dao.updateSenha(user, senhaNova);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateEmail(Usuario usuario, String emailNovo){
		if(usuario.getEmail() != null && !usuario.getEmail().isEmpty()) {

			try (UsuarioDAO dao = new UsuarioDAO()){
				dao.updateEmail(usuario, emailNovo);
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return 1; 
		}
		return 0;
	}


	public int updateSenha(Usuario usuario, String senhaNova) {

		if(usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {

			try (UsuarioDAO dao = new UsuarioDAO()){

				if(usuario.getSenha().length()  < 6) throw new  LengthException("Senha não corresponde as exigências de tamanho");
				dao.updateSenha(usuario, senhaNova);

			} catch (Exception e) {

			}

			return 1;
		}
		return 0;
	}


	public int updateApelido(Usuario usuario, String apelidoNovo) {
		
		if(usuario.getApelido() != null && !usuario.getApelido().isEmpty()) {
			try (UsuarioDAO dao = new UsuarioDAO()){
				Usuario usuarioTeste = dao.getByApelido(usuario.getApelido()); 

				if(usuarioTeste != null) throw new ApelidoException("Apelido indisponível");

				dao.updateApelido(usuario, apelidoNovo);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return 0;
	}
}