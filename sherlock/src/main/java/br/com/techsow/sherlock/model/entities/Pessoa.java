package br.com.techsow.sherlock.model.entities;
/**
 * beans da Pessoa
 * @author Italo
 *
 */
public class Pessoa {
	
	

	private int id;
	private String nome, sobrenome;
	private Usuario usuarioId = new Usuario();
	
	/**
	 * Construtor vazio para operações onde o usuário não é encontrado.
	 */
	public Pessoa() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Usuario getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}
	

	/**
	 * Construtor para criar e buscar entidades.
	 * @param nome
	 * @param sobrenome
	 * @param id
	 * @param usuarioId 
	 * @param usuadioId
	 * @param idade
	 */
	public Pessoa(int id, String nome, String sobrenome, Usuario usuarioId) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.usuarioId = usuarioId;
	}
	
	
	public Pessoa(String nome, String sobrenome, Usuario usuarioId) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.usuarioId = usuarioId;
	}
	
		
}
