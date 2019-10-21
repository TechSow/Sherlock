package br.com.techsow.sherlock.model.exception;

public class NumberException extends Exception {



	/**
	 * @author italo
	 * 
	 * Exception para lidar com valores icorretos informados no input. 
	 */
	private static final long serialVersionUID = 8737898971041974642L;

	public NumberException(String message) {
		super(message);
	}

}
