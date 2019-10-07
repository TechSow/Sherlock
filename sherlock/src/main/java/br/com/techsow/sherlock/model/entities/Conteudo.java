package br.com.techsow.sherlock.model.entities;
/**
 * Entidade conteudo que irá armazenar o conteudo de uma materia 
 * @author Breno
 *
 */
public class Conteudo {
	private int id_conteudo;
	String nome, url_pdf;
	
	/**
	 * Construtor cheio para pesquisas no banco de dados
	 * @param id_conteudo
	 * @param nome
	 * @param url_pdf
	 */
	public Conteudo(int id_conteudo, String nome, String url_pdf) {
		this(nome,url_pdf);
		this.id_conteudo = id_conteudo;
	}

	/**
	 * construtor meio cheio para cadastros no banco de dados
	 * @param nome
	 * @param url_pdf
	 */
	public Conteudo(String nome, String url_pdf) {
		this.nome = nome;
		this.url_pdf = url_pdf;
	}

	
	public int getId_conteudo() {
		return id_conteudo;
	}

	public void setId_conteudo(int id_conteudo) {
		this.id_conteudo = id_conteudo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl_pdf() {
		return url_pdf;
	}

	public void setUrl_pdf(String url_pdf) {
		this.url_pdf = url_pdf;
	}
	
	
}
