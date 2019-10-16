package br.com.techsow.sherlock.control.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.MateriaBO;
import br.com.techsow.sherlock.model.entities.Materia;
import br.com.techsow.sherlock.model.exception.LengthException;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class CadastroMateria implements Task {


	/**
	 * @author Italo
	 * 
	 *         Classe criada para lidar com as requisicoes de criacao de novos materias
	 *         A requisicao vem da Servlet Controller
	 * @throws LengthException 
	 */
	@Override
	public String processTask(HttpServletRequest req, HttpServletResponse resp) throws LengthException {

		String nome = req.getParameter("nome");
		String ementa = req.getParameter("ementa");
		String urlImg = req.getParameter("urlImg");
		
		
		
		try {
			Materia materia= new Materia(nome, ementa, urlImg);
			String materiaBO = new MateriaBO().add(materia);
			
		} catch (Exception e) {
            req.setAttribute("erro", new String[] {e.getMessage(), "danger", "exclamation"});

		}
		return "admin.jsp";
		
		
	}



}
