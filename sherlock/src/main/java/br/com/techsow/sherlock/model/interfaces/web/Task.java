package br.com.techsow.sherlock.model.interfaces.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Task {
	public String processTask(HttpServletRequest req, HttpServletResponse resp);
}
