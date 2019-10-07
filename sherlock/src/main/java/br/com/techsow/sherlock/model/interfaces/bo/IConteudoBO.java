package br.com.techsow.sherlock.model.interfaces.bo;

import java.util.List;

import br.com.techsow.sherlock.model.entities.Conteudo;

public interface IConteudoBO extends IBaseBO<Conteudo>{
	public List<Conteudo> getConteudoFromMateriaId(int id_materia);
}
