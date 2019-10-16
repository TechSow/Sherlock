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

public class CadastroProfessor implements Task {


	/**
	 * @author Italo
	 * 
	 *         Classe criada para lidar com as requisicoes de tornar um Usuario comum em professor na plataforma
	 *         A requisicao vem da Servlet Controller pela jsp cadastroProfessor
	 * @throws LengthException 
	 * @throws EmailNotFound 
	 * @throws ApelidoException 
	 */
	@Override
	public String processTask(HttpServletRequest req, HttpServletResponse resp) throws LengthException, ApelidoException, EmailNotFound {

		String email = req.getParameter("email");
		String apelido = req.getParameter("apelido");
		String senha = req.getParameter("senha");
		

		
		try {
			Usuario usuario = new Usuario(email, apelido, senha,0,1,1);
			String usuarioBO;
			usuarioBO = new UsuarioBO().add(usuario);
			
		} catch (Exception e) {
            req.setAttribute("erro", new String[] {e.getMessage(), "danger", "exclamation"});
		}
		
		return "admin.jsp";
				
	}

}
