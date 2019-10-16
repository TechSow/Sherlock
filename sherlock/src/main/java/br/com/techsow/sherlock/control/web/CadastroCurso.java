package br.com.techsow.sherlock.control.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.CursoBO;
import br.com.techsow.sherlock.model.dao.CursoDAO;
import br.com.techsow.sherlock.model.entities.Curso;
import br.com.techsow.sherlock.model.exception.LengthException;
import br.com.techsow.sherlock.model.exception.NumberException;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class CadastroCurso implements Task {


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
				
		
		String descricao = req.getParameter("descricao");
		int dificuldade = Integer.parseInt(req.getParameter("dificuldade"));
		long duracao = Long.parseLong(req.getParameter("duracao"));
			
		try {
			Curso curso= new Curso(nome, descricao, dificuldade, duracao,"vazio");
			String cursoBO = new CursoBO().add(curso);
			
		} catch (Exception e) {
			req.setAttribute("erro", new String[] {e.getMessage(), "danger", "exclamation"});
		}
		
		
		String[] materias = req.getParameterValues("selectedMaterias");
		Curso curso = new CursoDAO().getNoRelationedCurseId();
		
		
			int resultado = new CursoDAO().relateCursoMateria(curso.getId_curso(), Integer.parseInt(materias[0]));
	
		
		return "admin.jsp";
		
	}



}
