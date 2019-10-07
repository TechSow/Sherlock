package br.com.techsow.sherlock.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.interfaces.web.Task;

public class Curso implements Task{

	
	public String processTask(HttpServletRequest req, HttpServletResponse resp) {
	
		int id = Integer.parseInt(req.getParameter("id_curso"));
		System.out.println(id);
		
		return "home.jsp";
	}

}
