package br.com.techsow.sherlock.model.interfaces.repository;

import br.com.techsow.sherlock.model.entities.Usuario;

public interface IUsuarioRepository extends IBaseRepository<Usuario>{
	public Usuario loginUser(Usuario user) throws Exception;
	public int updateSenha(Usuario user, String senhaNova) throws Exception;
	public int updateEmail(Usuario user, String emailNovo) throws Exception;
	public Usuario getByEmail(String email) throws Exception;
}
