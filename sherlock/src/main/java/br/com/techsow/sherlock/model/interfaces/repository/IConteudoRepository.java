package br.com.techsow.sherlock.model.interfaces.repository;

import java.util.List;

import br.com.techsow.sherlock.model.entities.Conteudo;


public interface IConteudoRepository extends IBaseRepository<Conteudo>{
	public List<Conteudo> getConteudoFromMateriaId(int id_materia) throws Exception;
}
