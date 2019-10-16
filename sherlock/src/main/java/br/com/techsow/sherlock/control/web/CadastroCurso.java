package br.com.techsow.sherlock.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.CursoBO;
import br.com.techsow.sherlock.model.entities.Curso;
import br.com.techsow.sherlock.model.exception.LengthException;
import br.com.techsow.sherlock.model.exception.NumberException;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class CadastroCurso implements Task {


	/**
	 * @author Italo
	 * 
	 *         Classe criada para lidar com as requisicoes de criacao de novos cursos
	 *         A requisicao vem da Servlet Controller
	 * @throws NumberException 
	 * @throws LengthException 
	 */
	@Override
	public String processTask(HttpServletRequest req, HttpServletResponse resp) throws LengthException, NumberException {

		String nome = req.getParameter("nome");
		String descricao = req.getParameter("descricao");
		int dificuldade = Integer.parseInt(req.getParameter("dificuldade"));
		long duracao = Long.parseLong(req.getParameter("duracao"));
		
		
		Curso curso= new Curso(nome, descricao, dificuldade, duracao,"vazio");
		String cursoBO = new CursoBO().add(curso);
		
		req.setAttribute("erro", cursoBO);
		return "admin.jsp";
		
		
	}



}
