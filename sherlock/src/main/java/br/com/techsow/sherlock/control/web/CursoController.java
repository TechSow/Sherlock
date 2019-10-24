package br.com.techsow.sherlock.control.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.CursoBO;
import br.com.techsow.sherlock.model.bo.MateriaBO;
import br.com.techsow.sherlock.model.entities.Curso;
import br.com.techsow.sherlock.model.entities.Materia;
import br.com.techsow.sherlock.model.interfaces.web.Task;


public class CursoController  implements Task{

	public String processTask(HttpServletRequest req, HttpServletResponse resp) {
		String curso = req.getParameter("cursobool");
		
		if(curso == null) {
			int id_curso = Integer.parseInt(req.getParameter("id_curso"));
			ArrayList<Materia> materias = new MateriaBO().getMateriasFromCursoId(id_curso); 
			req.setAttribute("materias", materias);
			
			return "materia.jsp";}
		else {
			ArrayList<Curso> cursos = new CursoBO().getAll();
			req.setAttribute("cursos", cursos);
			return "home.jsp";
		}
	}
	
}