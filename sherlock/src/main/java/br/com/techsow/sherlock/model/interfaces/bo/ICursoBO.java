package br.com.techsow.sherlock.model.interfaces.bo;

import java.util.List;

import br.com.techsow.sherlock.model.entities.Curso;
import br.com.techsow.sherlock.model.exception.LengthException;
import br.com.techsow.sherlock.model.exception.NumberException;


public interface ICursoBO extends IBaseBO<Curso>{
	public String updateNome(Curso c, String nome) throws LengthException;
	public String updateDescricao(Curso c, String descricao) throws LengthException;
	public List<Curso> getAll();
	public String add(Curso curso, String[] materias) throws LengthException, NumberException;
	public int updateCurso(Curso curso, String[] materias);
}
