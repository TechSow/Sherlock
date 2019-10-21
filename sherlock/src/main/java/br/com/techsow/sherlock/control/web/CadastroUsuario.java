package br.com.techsow.sherlock.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.UsuarioBO;
import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.exception.ApelidoException;
import br.com.techsow.sherlock.model.exception.DuplicatedException;
import br.com.techsow.sherlock.model.exception.EmailNotFound;
import br.com.techsow.sherlock.model.exception.LengthException;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class CadastroUsuario implements Task {


	/**
	 * @author Italo
	 * 
	 *         Classe criada para lidar com as requisicoes de criacao de novos usuarios
	 *         A requisicao vem da Servlet Controller e da JSP cadastroUsuario
	 * @throws LengthException 
	 */
	@Override
	public String processTask(HttpServletRequest req, HttpServletResponse resp) throws LengthException {

		String from = req.getParameter("from");
		String email = req.getParameter("email");
		String apelido = req.getParameter("apelido");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario(email, apelido, senha,0,0,1);
		String usuarioBO = null;
		try {
			usuarioBO = new UsuarioBO().add(usuario);
		} catch (Exception e) {
			req.setAttribute("erro", new String[] {e.getMessage(), "danger", "exclamation"});
		}

		if(from == "CadastroUsuarioAdm") {
		return "admin.jsp";
		}else {
			return "cadastro.jsp";
		}
	}
}
