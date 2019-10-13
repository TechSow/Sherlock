package br.com.techsow.sherlock.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.UsuarioBO;
import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class CadastroUsuario implements Task {


	@Override
	public String processTask(HttpServletRequest req, HttpServletResponse resp) {

		String email = req.getParameter("email");
		String apelido = req.getParameter("apelido");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario(email, apelido, senha,0,0,1);
		String usuarioBO = new UsuarioBO().add(usuario);
		
		
		return "index.jsp";
		
		
	}



}
