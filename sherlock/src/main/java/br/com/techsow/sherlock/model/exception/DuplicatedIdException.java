package br.com.techsow.sherlock.model.exception;

public class DuplicatedIdException extends Exception{

	private static final long serialVersionUID = 1L;

	public DuplicatedIdException(String message) {
		super(message);
	}

}
