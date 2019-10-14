package br.com.techsow.sherlock.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.UsuarioBO;
import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class CadastroProfessor implements Task {


	/**
	 * @author Italo
	 * 
	 *         Classe criada para lidar com as requisicoes de tornar um Usuario comum em professor na plataforma
	 *         A requisicao vem da Servlet Controller pela jsp cadastroProfessor
	 */
	@Override
	public String processTask(HttpServletRequest req, HttpServletResponse resp) {

		String email = req.getParameter("email");
		
		Usuario usuario = new UsuarioBO().getByEmail(email);
		String usuarioBO = new UsuarioBO().updateToProfessor(usuario);
		
		req.setAttribute("erro", usuarioBO);
		return "home.jsp";
		
		
	}



}
