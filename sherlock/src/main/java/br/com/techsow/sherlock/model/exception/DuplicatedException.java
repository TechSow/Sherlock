package br.com.techsow.sherlock.model.exception;

/**
 * 
 * @author Italo 
 * Exception customizada para erros de Indexes duplicados(Email, apelido, IDs)
 *
 */
public class DuplicatedException extends Exception{

	private static final long serialVersionUID = 1L;

	public DuplicatedException(String message) {
		super(message);
	}

}
