package br.com.techsow.sherlock.model.interfaces.repository;

import java.util.List;

import br.com.techsow.sherlock.model.entities.Unanswered;

public interface IUnansweredRepository extends IBaseRepository<Unanswered>{
	public List<Unanswered> getAll() throws Exception;
	public List<Unanswered> getAllByIdUsuario(int id_usuario) throws Exception;
}
