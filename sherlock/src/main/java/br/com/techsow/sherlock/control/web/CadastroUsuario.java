package br.com.techsow.sherlock.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.UsuarioBO;
import br.com.techsow.sherlock.model.entities.Curso;
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

		String nome = req.getParameter("nome");
		String descricao = req.getParameter("descricao");
		String duracao = req.getParameter("duracao");
		String dificuldade = req.getParameter("dificuldade");
		String cursoImg = req.getParameter("cursoImg");

		
		Curso curso = new Curso(nome, descricao, duracao, dificuldade, cursoImg);
		String usuarioBO = new UsuarioBO().add(usuario);
		
		req.setAttribute("erro", usuarioBO);
		return "cadastro.jsp";
		
		
	}



}
