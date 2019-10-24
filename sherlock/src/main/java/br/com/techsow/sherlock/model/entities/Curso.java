package br.com.techsow.sherlock.model.entities;

import java.util.List;

public class Curso {

	private String nome, descricao, urlImg;
	private long duracao;
	private int id_curso, dificuldade;
	private List<Materia> materias; 
	
	
	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public int getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getDuracao() {
		return duracao;
	}

	public void setDuracao(long duracao) {
		this.duracao = duracao;
	}

	/**
	 * construtor para cadastro de um curso
	 * 
	 * @param nome
	 * @param descricao
	 * @param duracao
	 */
	public Curso(String nome, String descricao, long duracao) {
		this.nome = nome;
		this.descricao = descricao;
		this.duracao = duracao;
	}
	public Curso(String nome, String descricao, String urlImg) {
		this.nome = nome;
		this.descricao = descricao;
		this.urlImg = urlImg;
	}
	
	public Curso(String nome, String descricao, int dificuldade, long duracao, String urlImg) {
		this.nome = nome;
		this.descricao = descricao;
		this.duracao = duracao;
		this.dificuldade = dificuldade;
		this.urlImg = urlImg;
	}
	
	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	/**
	 * construtor cheio para consulta
	 * 
	 * @param id
	 * @param nome
	 * @param descricao
	 * @param duracao
	 */
	public Curso(int id, String nome, String descricao, long duracao, String urlImg, int dificuldade) {
		this.id_curso = id;
		this.nome = nome;
		this.descricao = descricao;
		this.duracao = duracao;
		this.urlImg = urlImg;
		this.dificuldade = dificuldade;
	}

	/**
	 * consturtor para cursos sem duração
	 * 
	 * @param id
	 * @param nome
	 * @param descricao
	 */
	public Curso(int id, String nome, String descricao) {
		this.id_curso = id;
		this.nome = nome;
		this.descricao = descricao;
	}
}
