package br.com.techsow.sherlock.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.UsuarioBO;
import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.exception.ApelidoException;
import br.com.techsow.sherlock.model.exception.DuplicatedIdException;
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
	 */
	@Override
	public String processTask(HttpServletRequest req, HttpServletResponse resp) throws LengthException {

		String email = req.getParameter("email");
		String apelido = req.getParameter("apelido");
		String senha = req.getParameter("senha");
		

		Usuario usuario = new Usuario(email, apelido, senha,0,1,1);
		String usuarioBO;
		try {
			usuarioBO = new UsuarioBO().add(usuario);
		} catch (DuplicatedIdException e) {
			req.setAttribute("erro", e.getMessage());
		} catch (ApelidoException e) {
			req.setAttribute("erro", e.getMessage());
		} catch (EmailNotFound e) {
			req.setAttribute("erro", e.getMessage());
		}
		
		return "admin.jsp";
		
		
	}



}
