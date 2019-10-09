package br.com.techsow.sherlock.model.interfaces.repository;

import java.util.List;

import br.com.techsow.sherlock.model.entities.Curso;

public interface ICursoRepository extends IBaseRepository<Curso> {
	public int updateNome(Curso c, String nome) throws Exception;
	public int updateDescricao(Curso c, String descricao) throws Exception;
	public List<Curso> getAll() throws Exception;
}
