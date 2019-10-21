package br.com.techsow.sherlock.control.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.techsow.sherlock.model.bo.CursoBO;
import br.com.techsow.sherlock.model.bo.MateriaBO;
import br.com.techsow.sherlock.model.entities.Materia;
import br.com.techsow.sherlock.model.interfaces.web.Task;

@WebServlet(urlPatterns="/cursos")
public class CursoController extends HttpServlet implements Task{

	private static final long serialVersionUID = 2088017031020500936L;

	public String processTask(HttpServletRequest req, HttpServletResponse resp) {
		int id_curso = Integer.parseInt(req.getParameter("id_curso"));
		ArrayList<Materia> materias = new MateriaBO().getMateriasFromCursoId(id_curso); 
		req.setAttribute("materias", materias);
		return "materia.jsp";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("id_curso"));
		int id_curso = 47;
		
		String json = new Gson().toJson(new CursoBO().getById(id_curso));
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
		
	}
	
}
