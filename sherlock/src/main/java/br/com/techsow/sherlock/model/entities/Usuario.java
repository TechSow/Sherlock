package br.com.techsow.sherlock.model.entities;
/**
 * beans do usuário
 * @author Breno
 *
 */
public class Usuario {
	private int idUsuario,adm,professor, aluno;
	private String email, senha, apelido;
	
	/**
	 * Construtor vazio para operações onde o usuário não é encontrado.
	 */
	public Usuario() { }
	
	/**
	 * Construtor para login onde o usuario pode informar ou o email ou o apelido
	 * @param email
	 * @param senha
	 */
	
	public Usuario(String emailOuApelido, String senha) {
		if(emailOuApelido.contains("@") && emailOuApelido.contains(".com")) {
			this.email = emailOuApelido;
			this.senha = senha;
			this.apelido = "";
		}else {
			this.apelido = emailOuApelido;
			this.senha = senha;
			this.email = "";
		}
		
	}
	
	/**
	 * Construtor cheio para criar/buscar entidades cheias
	 * @param idUsuario
	 * @param email
	 * @param senha
	 * @param adm
	 * @param professor
	 */
	
	public Usuario(int idUsuario, String email, String senha, int adm, int professor,int aluno, String apelido) {
		this.idUsuario = idUsuario;
		this.email = email;
		this.senha = senha;
		this.aluno = aluno;
		this.adm = adm; 
		this.professor = professor;
		this.apelido = apelido;
	}
	
	
	
	public Usuario(int idUsuario, String email, String apelido, String senha, int adm, int professor,int aluno) {
		this.idUsuario = idUsuario;
		this.email = email;
		this.senha = senha;
		this.aluno = aluno;
		this.adm = adm; 
		this.professor = professor;
		this.apelido = apelido;
	}
	
	
	public Usuario(String email, String apelido, String senha, int adm, int professor,int aluno) {
		this.idUsuario = idUsuario;
		this.email = email;
		this.senha = senha;
		this.aluno = aluno;
		this.adm = adm; 
		this.professor = professor;
		this.apelido = apelido;
	}

	/**
	 * 
	 * @param email
	 * @param apelido
	 * @param senha
	 */
	public Usuario(String email, String apelido, String senha) {
		this.email = email;
		this.senha = senha;
		this.apelido = apelido;
	}
	
	
	/**
	 * Método para fazer update dos atributos do usuario
	 * @param id
	 * @param email
	 * @param apelido
	 * @param senha
	 */
	
	public Usuario(int id, String email, String apelido, String senha) {
		this.idUsuario = id;
		this.email = email;
		this.senha = senha;
		this.apelido = apelido;
	}

	public int getAluno() {
		return aluno;
	}

	public void setAluno(int aluno) {
		this.aluno = aluno;
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

	public String getApelido() {
		return apelido;	
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	
	
	
	
	
}
