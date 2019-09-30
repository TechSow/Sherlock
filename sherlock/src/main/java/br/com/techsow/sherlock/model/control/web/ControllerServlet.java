package br.com.techsow.sherlock.model.control.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.interfaces.web.Task;
/**
 * @author Breno
 * 
 * Controller master que irá receber todas requisiões e re-encaminhará para o devido tratamento.
 */
@WebServlet(urlPatterns = "/controller")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -4896279813971208948L;

	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String task = req.getParameter("tarefa");
			task = "br.com.techsow.sherlock.model.web."+task;
			
			try {
				Class<?> classe = Class.forName(task);
				Task instance = (Task) classe.newInstance();
				String url = instance.processTask(req, resp);
				req.getRequestDispatcher(url).forward(req,resp);
			}catch(ClassNotFoundException | 
					IllegalAccessException | 
					InstantiationException e) {
				e.printStackTrace();
			}
			
			
			
		}
	

	
}
