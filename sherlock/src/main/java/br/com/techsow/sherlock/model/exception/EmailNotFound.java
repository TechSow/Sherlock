package br.com.techsow.sherlock.model.exception;

public class EmailNotFound  extends Exception{

	private static final long serialVersionUID = 1L;

	public EmailNotFound(String message) {
		super(message);
	}

	public EmailNotFound(String message, Throwable cause) {
		super(message, cause);
	}
	
}
