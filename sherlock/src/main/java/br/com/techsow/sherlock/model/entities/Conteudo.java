package br.com.techsow.sherlock.model.entities;
/**
 * Entidade conteudo que irá armazenar o conteudo de uma materia 
 * @author Breno
 *
 */
public class Conteudo {
	private int id_conteudo, hasbot;
	String titulo, url_pdf;
	
	/**
	 * Construtor cheio para pesquisas no banco de dados
	 * @param id_conteudo
	 * @param titulo
	 * @param url_pdf
	 */
	public Conteudo(int id_conteudo, String titulo, String url_pdf, int hasbot) {
		this(titulo,url_pdf,hasbot);
		this.id_conteudo = id_conteudo;
	}

	/**
	 * construtor meio cheio para cadastros no banco de dados
	 * @param titulo
	 * @param url_pdf
	 */
	public Conteudo(String titulo, String url_pdf, int hasbot) {
		this.titulo = titulo;
		this.url_pdf = url_pdf;
		this.hasbot = hasbot;
	}

	
	public int getId_conteudo() {
		return id_conteudo;
	}

	public void setId_conteudo(int id_conteudo) {
		this.id_conteudo = id_conteudo;
	}

	public String getUrl_pdf() {
		return url_pdf;
	}

	public void setUrl_pdf(String url_pdf) {
		this.url_pdf = url_pdf;
	}

	public int getHasbot() {
		return hasbot;
	}

	public void setHasbot(int hasbot) {
		this.hasbot = hasbot;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
