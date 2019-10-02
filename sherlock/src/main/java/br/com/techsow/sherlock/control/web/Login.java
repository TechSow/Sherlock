package br.com.techsow.sherlock.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.techsow.sherlock.model.bo.UsuarioBO;
import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.interfaces.web.Task;
/**
 * Controller resposável pelo login do usuário;
 * @author Breno
 *
 */
public class Login implements Task {

	
	public String processTask(HttpServletRequest req, HttpServletResponse resp) {

		
		String emailOuApelido = req.getParameter("emailOuApelido");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario(emailOuApelido,senha);
		usuario = new UsuarioBO().loginUser(usuario);
		
		if(usuario != null) {
			HttpSession session = req.getSession();
			session.setAttribute("usuario", usuario);
			return "home.jsp";
		}
		
		req.setAttribute("erro", "Usuário e/ou senha não existem");
		return "index.jsp";
		
	}

	
	
}
