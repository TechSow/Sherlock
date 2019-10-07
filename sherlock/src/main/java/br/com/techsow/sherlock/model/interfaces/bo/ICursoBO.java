package br.com.techsow.sherlock.model.interfaces.bo;

import java.util.List;

import br.com.techsow.sherlock.model.entities.Curso;


public interface ICursoBO extends IBaseBO<Curso>{
	public int updateNome(Curso c, String nome);
	public int updateDescricao(Curso c, String descricao);
	public List<Curso> getAll();
}
