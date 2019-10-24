package br.com.techsow.sherlock.model.interfaces.bo;

import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.exception.ApelidoException;
import br.com.techsow.sherlock.model.exception.DuplicatedException;
import br.com.techsow.sherlock.model.exception.EmailNotFound;
import br.com.techsow.sherlock.model.exception.LengthException;
import br.com.techsow.sherlock.model.exception.NumberException;

public interface IBaseBO<Entity> {
	public String add(Entity obj) throws DuplicatedException, ApelidoException, EmailNotFound, LengthException, NumberException; 
	public Entity getById(int id);
	public int kill(int id);
	public int update(Entity obj);
}