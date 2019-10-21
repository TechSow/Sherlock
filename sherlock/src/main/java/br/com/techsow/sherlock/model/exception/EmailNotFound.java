package br.com.techsow.sherlock.model.exception;

/**
 * 
 * @author Breno
 * Exception para lidar com erro ao procurar se o Email existe no banco de dados
 *
 */
public class EmailNotFound  extends Exception{

	private static final long serialVersionUID = 1L;

	public EmailNotFound(String message) {
		super(message);
	}

	public EmailNotFound(String message, Throwable cause) {
		super(message, cause);
	}
	
}
