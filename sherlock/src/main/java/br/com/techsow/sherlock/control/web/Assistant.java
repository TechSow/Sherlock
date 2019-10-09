package br.com.techsow.sherlock.control.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ibm.watson.assistant.v2.model.MessageContext;

@WebServlet(urlPatterns = "/assistant")
public class Assistant extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MessageContext context = new MessageContext();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = req.getParameter("question");
		System.out.println(msg);
		
		resp.setContentType("application/json");
		resp.getWriter().write(new Gson().toJson(msg));
//		
	}
	
}
