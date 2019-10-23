package br.com.techsow.sherlock.control.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import br.com.techsow.sherlock.model.bo.CursoBO;
import br.com.techsow.sherlock.model.entities.Curso;
=======
import br.com.techsow.sherlock.model.bo.MateriaBO;
import br.com.techsow.sherlock.model.entities.Materia;
>>>>>>> parent of be479da... Metodo
import br.com.techsow.sherlock.model.interfaces.web.Task;


public class CursoController  implements Task{


<<<<<<< HEAD

	@Override
	public String processTask(HttpServletRequest req, HttpServletResponse resp) {
	ArrayList<Curso> cursos=new CursoBO().getAll();
	req.setAttribute("cursos",cursos);
	return "materia.jsp";
	}
}
=======
}
>>>>>>> parent of be479da... Metodo
