package br.com.techsow.sherlock.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.UsuarioBO;
import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.exception.EmailNotFound;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class RecuperarSenhaController implements Task{

	
	public String processTask(HttpServletRequest req, HttpServletResponse resp) {
	
		String email = req.getParameter("email");
		
		UsuarioBO bo = new UsuarioBO();
		
		try {
			Usuario usuario  = bo.getByEmail(email);
			req.setAttribute("UsuarioEncontrado", usuario);
			int code = (int) (1111 * Math.random());
			req.setAttribute("code", code);
			
			
			
		} catch (EmailNotFound e) {
			// trata o erro mandando um toast pra tela
			System.out.println(e.getMessage());
		}
		
		
		
		return "recuperarSenha.jsp";
	}

	
	
	
	
}
