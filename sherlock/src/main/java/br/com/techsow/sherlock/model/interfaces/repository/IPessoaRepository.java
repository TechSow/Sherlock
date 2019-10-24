package br.com.techsow.sherlock.model.interfaces.repository;

import br.com.techsow.sherlock.model.entities.Pessoa;
import br.com.techsow.sherlock.model.entities.Usuario;

public interface IPessoaRepository extends IBaseRepository<Usuario>{
	public Pessoa loginUser(Usuario user) throws Exception;
	public int updateNome(Pessoa pessoa, String nomeNovo) throws Exception;
	public int updateSobrenome(Usuario user, String SobrenomeNovo) throws Exception;
}
