package br.com.techsow.sherlock.model.exception;

public class NotEqualsException extends Exception {

	

	/**
	 * @author Breno 
	 * 
	 * Exception para quando for necessário comparar entrada do usuario com o que esta no banco. 
	 */
	private static final long serialVersionUID = 8242004280622577554L;
	public NotEqualsException(String message) {
		super(message);
	}
}
