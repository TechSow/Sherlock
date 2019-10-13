package br.com.techsow.sherlock.model.interfaces.repository;

import java.sql.SQLException;

import br.com.techsow.sherlock.model.entities.Curso;

public interface IBaseRepository<Entity> extends AutoCloseable {
	public int add(Entity obj) throws SQLException; 
	public Entity getById(int id) throws Exception;
	public int kill(int id) throws Exception;
	public int update(Entity obj) throws Exception;
	public void close() throws SQLException;
}
