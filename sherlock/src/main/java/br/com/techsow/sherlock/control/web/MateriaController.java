package br.com.techsow.sherlock.control.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.ConteudoBO;
import br.com.techsow.sherlock.model.entities.Conteudo;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class MateriaController implements Task {

	
	public String processTask(HttpServletRequest req, HttpServletResponse resp) {
		
		int id_materia = Integer.parseInt(req.getParameter("id_materia"));
		ArrayList<Conteudo> conteudos = new ArrayList<Conteudo>();
		conteudos = new ConteudoBO().getConteudoFromMateriaId(id_materia);
		req.setAttribute("conteudos", conteudos);
		return "conteudos.jsp";
	}

}
