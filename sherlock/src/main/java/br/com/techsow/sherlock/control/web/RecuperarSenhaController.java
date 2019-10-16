package br.com.techsow.sherlock.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.UsuarioBO;
import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.exception.EmailNotFound;
import br.com.techsow.sherlock.model.exception.NotEqualsException;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class RecuperarSenhaController implements Task {

	private static int code;

	public String processTask(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getMethod().toUpperCase().equals("GET"))
			return doGet(req,resp);
		else
			return doPost(req,resp);
		
	}
	
	
	private String doGet(HttpServletRequest req, HttpServletResponse resp) {
		int _code = 1;
		if(req.getParameter("code") != null) {
			 _code = Integer.parseInt(req.getParameter("code"));			
		}
		String email = req.getParameter("emailOuApelido");

		UsuarioBO bo = new UsuarioBO();

		if (code == _code) {
			req.setAttribute("Bateu", false);
			req.setAttribute("email", email);
			req.setAttribute("code", 0);
			return "recuperarSenha.jsp";
		}
		
		try {
			Usuario usuario = bo.getByEmail(email);
			code = (int) (11111 * Math.random());
			EmailSender es = new EmailSender(code);
			es.enviarEmail(usuario);
			req.setAttribute("email", email);
			req.setAttribute("code", _code);
			req.setAttribute("Bateu", true);
		} catch (EmailNotFound e) {
			System.out.println(e.getMessage());
			req.setAttribute("erro", e.getMessage());
		}

		return "recuperarSenha.jsp";

	}
	public String doPost(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("emailOuApelido");
		String senha = req.getParameter("senha");
		String confirmarSenha = req.getParameter("confirmarSenha");
		UsuarioBO bo = new UsuarioBO();
		
		
			try {
				bo.updateSenha(email, senha, confirmarSenha);

				req.setAttribute("erro", new String[] {"Senha alterada com sucesso", "success", "fa fa-"});
			} catch (NotEqualsException | EmailNotFound e) {
				req.setAttribute("email", email);
				req.setAttribute("CodigoBateu", false);
				req.setAttribute("code", 0);
				req.setAttribute("erro", new String[] {e.getMessage(), "danger", ""});
				return "recuperarSenha.jsp";
			}
		
		
		
		return "login.jsp";
	}

}
