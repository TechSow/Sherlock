package br.com.techsow.sherlock.model.entities;
/**
 * entidade matéria
 * @author breno e Italo Chagas
 *
 */
public class Materia {
	private int id_materia;
	private String nome, ementa, urlImg;
	
	

	/**
	 * construtor vazio para objetos null;
	 */
	public Materia() {}
	
	
	/**
	 * construtor cheio para pesquisas no banco de dados
	 * @param id_materia
	 * @param nome
	 * @param ementa
	 */
	public Materia(int id_materia, String nome, String ementa,String urlImg) {
		this.id_materia = id_materia;
		this.nome = nome;
		this.ementa = ementa;
		this.urlImg= urlImg;
	}
	
	public String geturlImg() {
		return urlImg;
	}

	public void seturlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	/**
	 * consturtor semi cheio para criar novas matérias
	 * @param nome
	 * @param ementa
	 */
	public Materia(String nome, String ementa,String urlImg) {
		this.nome = nome;
		this.ementa = ementa;
		this.urlImg = urlImg;
	}
	
	
	public int getId_materia() {
		return id_materia;
	}
	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	
	
	
}
