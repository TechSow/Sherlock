package br.com.techsow.sherlock.model.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.techsow.sherlock.model.bo.CursoBO;
import br.com.techsow.sherlock.model.bo.MateriaBO;
import br.com.techsow.sherlock.model.entities.Curso;
import br.com.techsow.sherlock.model.entities.Materia;
@WebServlet(urlPatterns = "/curso")
public class CursoAPI extends HttpServlet {

	private static final long serialVersionUID = 1624568340304101011L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		List<Materia> materias= new MateriaBO().getMateriasFromCursoId(id);
		Curso curso = new CursoBO().getById(id);
		curso.setMaterias(materias);
		String json = new Gson().toJson(curso);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);
	}
}
