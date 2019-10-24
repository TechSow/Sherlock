package br.com.techsow.sherlock.control.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.CursoBO;
import br.com.techsow.sherlock.model.entities.Curso;
import br.com.techsow.sherlock.model.interfaces.web.Task;


public class CursoController  implements Task{



	@Override
	public String processTask(HttpServletRequest req, HttpServletResponse resp) {
	ArrayList<Curso> cursos=new CursoBO().getAll();
	req.setAttribute("cursos",cursos);
	return "materia.jsp";
	}
	
}