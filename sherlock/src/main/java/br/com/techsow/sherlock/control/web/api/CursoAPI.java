package br.com.techsow.sherlock.control.web.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.techsow.sherlock.model.bo.CursoBO;
@WebServlet(urlPatterns = "/curso")
public class CursoAPI extends HttpServlet {

	private static final long serialVersionUID = 1624568340304101011L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idReq = req.getParameter("id");
		System.out.println(idReq);
		int id = Integer.parseInt(idReq);

		String json = new Gson().toJson(new CursoBO().getById(id));
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);

	}

}
