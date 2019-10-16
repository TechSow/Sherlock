package br.com.techsow.sherlock.control.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.MateriaBO;
import br.com.techsow.sherlock.model.entities.Materia;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class GetMateriaController implements Task {

	
	public String processTask(HttpServletRequest req, HttpServletResponse resp) {
		
		ArrayList<Materia> materias = new ArrayList<Materia>();
		materias = new MateriaBO().getAll().
		req.setAttribute("conteudos", conteudos);
		return "conteudos.jsp";
	}

}
