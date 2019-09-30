package br.com.techsow.sherlock.model.interfaces.bo;

import br.com.techsow.sherlock.model.entities.Usuario;

public interface IUsuarioBO extends IBaseBO<Usuario> {
	public Usuario loginUser(Usuario user);
	public int updateSenha(Usuario user, String senhaNova);
	public int updateEmail(Usuario user, String emailNovo);
}
