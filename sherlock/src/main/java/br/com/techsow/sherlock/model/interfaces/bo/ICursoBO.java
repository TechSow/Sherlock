package br.com.techsow.sherlock.model.interfaces.bo;

import java.util.List;

import br.com.techsow.sherlock.model.entities.Curso;


public interface ICursoBO extends IBaseBO<Curso>{
	public String updateNome(Curso c, String nome);
	public String updateDescricao(Curso c, String descricao);
	public List<Curso> getAll();
}
