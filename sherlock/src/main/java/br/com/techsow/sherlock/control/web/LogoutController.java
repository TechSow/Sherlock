package br.com.techsow.sherlock.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.techsow.sherlock.model.interfaces.web.Task;

public class LogoutController implements Task {
	


	@Override
	public String processTask(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.invalidate();
		
		return"index.jsp";
	}
	
}
