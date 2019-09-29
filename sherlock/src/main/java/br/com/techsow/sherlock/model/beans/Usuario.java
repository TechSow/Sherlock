package br.com.techsow.sherlock.model.beans;

public class Usuario {
	private int idUsuario,adm,professor;
	private String email, senha;
	
	/**
	 * Construtor vazio para operações onde o usuário não é encontrado.
	 */
	public Usuario() { }
	
	/**
	 * Construtor para login
	 * @param email
	 * @param senha
	 */
	
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	/**
	 * Construtor cheio para criar/buscar entidades cheias
	 * @param idUsuario
	 * @param email
	 * @param senha
	 * @param adm
	 * @param professor
	 */
	
	public Usuario(int idUsuario, String email, String senha, int adm, int professor) {
		this(email,senha);
		this.idUsuario = idUsuario;
		this.adm = adm;
		this.professor = professor;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getAdm() {
		return adm;
	}

	public void setAdm(int adm) {
		this.adm = adm;
	}

	public int getProfessor() {
		return professor;
	}

	public void setProfessor(int professor) {
		this.professor = professor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	
	
}
