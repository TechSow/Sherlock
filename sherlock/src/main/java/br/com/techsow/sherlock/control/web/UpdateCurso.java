package br.com.techsow.sherlock.control.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.CursoBO;
import br.com.techsow.sherlock.model.dao.CursoDAO;
import br.com.techsow.sherlock.model.entities.Curso;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class UpdateCurso implements Task {


	private String cursoBO;

	/**
	 * @author Italo
	 * 
	 *         Classe criada para lidar com as requisicoes de alteração de cursos ja cadastrados
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

		int idCurso = Integer.parseInt(req.getParameter("selectedCurso"));
		int dificuldade = Integer.parseInt(req.getParameter("dificuldade"));
		long duracao = Long.parseLong(req.getParameter("duracao"));


		try {
			Curso curso = new CursoBO().getById(idCurso);


			if(nome.length() > 1) {
				new CursoBO().updateNome(curso, nome);
			}

			if(descricao.length() > 1) {
				new CursoBO().updateDescricao(curso, descricao);
			}

			if(dificuldade != 0) {
				new CursoBO().updateDificuldade(curso, dificuldade);
			}

			if(duracao > 0) {
				new CursoBO().updateDuracao(curso, duracao);
			}


			if(urlimg != null) {
				new CursoBO().updateURL(curso, urlimg);
			}

			if(materias != null) { 

				try {
					
					new CursoBO().relateCursoMateria(curso.getId_curso(), materias);
					
				} catch (Exception e) {
					req.setAttribute("erro", new String[] {e.getMessage(), "danger", "exclamation"});
				}	

			}




		} catch (Exception e) {
			req.setAttribute("erro", new String[] {e.getMessage(), "danger", "exclamation"});
		}				

		req.setAttribute("curso", "Curso adicionado com sucesso");
		return "admin.jsp";

	}



}
