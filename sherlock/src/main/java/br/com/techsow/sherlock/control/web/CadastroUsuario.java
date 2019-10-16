package br.com.techsow.sherlock.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.UsuarioBO;
import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.exception.ApelidoException;
import br.com.techsow.sherlock.model.exception.DuplicatedIdException;
import br.com.techsow.sherlock.model.exception.EmailNotFound;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class CadastroUsuario implements Task {


	/**
	 * @author Italo
	 * 
	 *         Classe criada para lidar com as requisicoes de criacao de novos usuarios
	 *         A requisicao vem da Servlet Controller
	 */
	@Override
	public String processTask(HttpServletRequest req, HttpServletResponse resp) {

		String email = req.getParameter("email");
		String apelido = req.getParameter("apelido");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario(email, apelido, senha,0,0,1);
		String usuarioBO = null;
		try {
			usuarioBO = new UsuarioBO().add(usuario);
		} catch (DuplicatedIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApelidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmailNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("erro", usuarioBO);
		return "admin.jsp";
	}



}
