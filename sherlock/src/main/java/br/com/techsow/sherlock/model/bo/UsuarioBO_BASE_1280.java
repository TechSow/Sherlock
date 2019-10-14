package br.com.techsow.sherlock.model.bo;

import br.com.techsow.sherlock.model.dao.UsuarioDAO;
import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.interfaces.bo.IUsuarioBO;

public class UsuarioBO implements IUsuarioBO {

	public int add(Usuario obj){

		return 0;
	}

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

	public int updateSenha(Usuario user, String senhaNova){

		return 0;
	}

	public int updateEmail(Usuario user, String emailNovo){

		return 0;
	}

}
