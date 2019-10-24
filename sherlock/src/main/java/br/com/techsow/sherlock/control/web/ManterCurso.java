package br.com.techsow.sherlock.control.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.CursoBO;
import br.com.techsow.sherlock.model.entities.Curso;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class ManterCurso implements Task {


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

		String id = req.getParameter("id_curso");
		String delete = req.getParameter("queroexcluir");
		
		if(!(delete.isEmpty()) ) {
			return doDelete(req,resp);
		}else if(id.isEmpty() || id == null) {
			return doPost(req,resp);
		}else {
			return doPut(req,resp);
		}

		
		
		
		
	}

	private String doDelete(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id_curso");
		
		try {
			new CursoBO().kill(Integer.parseInt(id));
			req.setAttribute("erro", new String[] {"curso deletado", "success", "check"});
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return "admin.jsp";
	}

	public String doPut(HttpServletRequest req,HttpServletResponse resp) {
		String id = req.getParameter("id_curso");
		String nome = req.getParameter("nome");
		String[] materias = req.getParameterValues("selectedMaterias");
		String urlimg = req.getParameter("urlimg");
		String descricao = req.getParameter("descricao");
		int dificuldade = Integer.parseInt(req.getParameter("dificuldade"));
		long duracao = Long.parseLong(req.getParameter("duracao"));
			
		
		
		try {
			Curso curso= new Curso(nome, descricao, dificuldade, duracao,urlimg);
			curso.setId_curso(Integer.parseInt(id));
			int ret = new CursoBO().updateCurso(curso, materias);	
			
		} catch (Exception e) {
			req.setAttribute("erro", new String[] {e.getMessage(), "danger", "exclamation"});
			return "admin.jsp";
		}
		
		req.setAttribute("erro", new String[] {"curso atualizado com sucesso", "success", "check"});
		return "admin.jsp";
	}
	
	public String doPost(HttpServletRequest req,HttpServletResponse resp) {
	

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
			return "admin.jsp";
		}
		
		req.setAttribute("erro", new String[] {cursoBO, "success", "check"});
		return "admin.jsp";
	}

}
