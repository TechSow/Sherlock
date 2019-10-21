package br.com.techsow.sherlock.model.exception;

/**
 * 
 * @author Breno
 * Exeption customizada para erros envolvendo o user de login
 *
 */
public class ApelidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ApelidoException(String message) {
		super(message);
	}

}
