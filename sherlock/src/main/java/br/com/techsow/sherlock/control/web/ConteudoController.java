package br.com.techsow.sherlock.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.ConteudoBO;
import br.com.techsow.sherlock.model.entities.Conteudo;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class ConteudoController implements Task {

	public String processTask(HttpServletRequest req, HttpServletResponse resp) {
	
		int id_conteudo = Integer.parseInt(req.getParameter("id_conteudo"));
		
		Conteudo conteudo = null;
		conteudo = new ConteudoBO().getById(id_conteudo);
		req.setAttribute("conteudo", conteudo);
		return "aula.jsp";
	}

}
