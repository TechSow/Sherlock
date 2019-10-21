package br.com.techsow.sherlock.model.exception;

/**
 * 
 * @author italo
 * 
 * Exception customizada para lidar com problemas de tamanhos de campos (Int e String)
 *
 */

public class LengthException extends Exception {


	private static final long serialVersionUID = -1966005328010276742L;

	public LengthException(String message) {
		super(message);
	}

}
