package br.com.techsow.sherlock.model.interfaces.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.exception.LengthException;
import br.com.techsow.sherlock.model.exception.NumberException;

public interface Task {
	public String processTask(HttpServletRequest req, HttpServletResponse resp) throws LengthException, NumberException;
}
