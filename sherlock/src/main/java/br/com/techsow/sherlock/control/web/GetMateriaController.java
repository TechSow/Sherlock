package br.com.techsow.sherlock.control.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.MateriaBO;
import br.com.techsow.sherlock.model.entities.Conteudo;
import br.com.techsow.sherlock.model.entities.Materia;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class GetMateriaController implements Task {

	/**
	 * 
	 * @author italo
	 * Classe que trará todas as matérias cadastradas no banco. 
	 * Utilizada na hora de cadastrar ou alterar cursos e matérias na área administrativa e áre do professor. 
	 * 
	 */
	public String processTask(HttpServletRequest req, HttpServletResponse resp)  {
		
		
		ArrayList<Materia> materias = new ArrayList<Materia>();
		materias = new MateriaBO().getAll();
		req.setAttribute("materias", materias);
		return "admin.jsp";
	}

}
