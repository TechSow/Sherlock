package br.com.techsow.sherlock.control.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.CursoBO;
import br.com.techsow.sherlock.model.dao.CursoDAO;
import br.com.techsow.sherlock.model.entities.Curso;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class CadastroCurso implements Task {


	private String cursoBO;

	/**
	 * @author Italo e Breno
	 * 
	 *         Classe criada para lidar com as requisicoes de criacao de novos cursos
	 *         A requisicao vem da Servlet Controller
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public String processTask(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, Exception {

		String nome = req.getParameter("nome");
				
		String[] materias = req.getParameterValues("selectedMaterias");
		String urlimg = req.getParameter("urlimg");
		String descricao = req.getParameter("descricao");
		int dificuldade = Integer.parseInt(req.getParameter("dificuldade"));
		long duracao = Long.parseLong(req.getParameter("duracao"));
			
		try {
			Curso curso= new Curso(nome, descricao, dificuldade, duracao,urlimg);
			cursoBO = new CursoBO().add(curso, materias);	
		} catch (Exception e) {
			req.setAttribute("erro", new String[] {e.getMessage(), "danger", "exclamation"});
		}
		
		req.setAttribute("curso", "Curso adicionado com sucesso");
		return "admin.jsp";
		
	}



}
