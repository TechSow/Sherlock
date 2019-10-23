package br.com.techsow.sherlock.control.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.MateriaBO;
import br.com.techsow.sherlock.model.entities.Materia;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class UpdateMateria implements Task {


	private String cursoBO;

	/**
	 * @author Italo
	 * 
	 *         Classe criada para lidar com as requisicoes de alteração de matérias ja cadastrados
	 *         A requisicao vem da Servlet Controller
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public String processTask(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, Exception {
		
		int idMateria = Integer.parseInt(req.getParameter("selectedMateria"));
		String nome = req.getParameter("nome");
		String ementa = req.getParameter("ementa");
		String urlImg = req.getParameter("urlImg");

		Materia materia = new MateriaBO().getById(idMateria);
		
		try {
			new MateriaBO().updateNome(materia, nome);
			new MateriaBO().updateUrlImg(materia, urlImg);
			new MateriaBO().updateEmenta(materia, ementa);


		} catch (Exception e) {
			req.setAttribute("erro", new String[] {e.getMessage(), "danger", "exclamation"});
		}				

		req.setAttribute("materia", "Materia alterada com sucesso");
		return "admin.jsp";

	}



}
