package br.com.techsow.sherlock.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.techsow.sherlock.model.dao.CursoDAO;
import br.com.techsow.sherlock.model.entities.Curso;
import br.com.techsow.sherlock.model.interfaces.bo.ICursoBO;

public class CursoBO implements ICursoBO{



	public String add(Curso curso) {

		if(curso.getDescricao().length() > 255) throw new  LengthException("Descrição escedeu quantidade de caracteres");


		if(curso.getDuracao() <= 0) {
			return "Duracao do curso invalida. Insira um valor valido";
		}

		if(curso.getNome().length() > 100) {
			return "Tamanho do nome do curso ultrapassa o tamanho limite";
		}	

		/*
		 * if(curso.getUrlImg().length() <= 0 ||curso.getUrlImg().length() >200 ) {
		 * return "URL da imagem maior que o esperado"; }
		 */

		if(curso.getDificuldade() <1 || curso.getDificuldade() > 5 ) {
			return "Valor da dificuldade invalida.";
		}

		CursoDAO dao = null;
		int retorno=0;

		try {

			dao = new CursoDAO();
			retorno = dao.add(curso);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dao.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		if(retorno == 1) {
			return "Sucesso ao adicionar curso";
		}else {
			return "Sem sucesso";
		}



	}

	public Curso getById(int id) {
		Curso curso= null;


		try (CursoDAO dao = new CursoDAO()) {
			curso = dao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return curso;
	}




	public int kill(int id) {

		return 0;
	}


	public int update(Curso obj) {

		return 0;
	}


	public String updateNome(Curso c, String nome) {
		if(nome.length() > 100) {
			return "Nome do curso maior que o esperado";
		}

		try (CursoDAO dao = new CursoDAO()){
			dao.updateNome(c, nome);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Nome alterado com sucesso";
	}


	public String updateDescricao(Curso c, String descricao) {

		if(descricao.length() > 255) {
			return "Ementa excede quantidade de caracteres.";
		}

		try (CursoDAO dao = new CursoDAO()){
			dao.updateDescricao(c, descricao);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Descrição alterada";
	}



	public String updateDuracao(Curso c, int duracao) {

		if(c.getDuracao() <= 0 ) {
			return "duração excede quantidade de caracteres.";
		}

		try (CursoDAO dao = new CursoDAO()){
			dao.updateDuracao(c, duracao);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Duração alterada";
	}


	public String updateURL(Curso c, String url) {

		if(c.getUrlImg().length() <= 0 ||c.getUrlImg().length() >200 ) {
			return "URL da imagem excede quantidade de caracteres.";
		}

		try (CursoDAO dao = new CursoDAO()){
			dao.updateUrl(c, url);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "URL alterada";
	}


	public String updateDificuldade(Curso c, int dificuldade) {

		if(c.getUrlImg().length() <= 0 ||c.getUrlImg().length() >200 ) {
			return "URL da imagem excede quantidade de caracteres.";
		}

		try (CursoDAO dao = new CursoDAO()){
			dao.updateDificuldade(c, dificuldade);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Dificuldade alterada";
	}

	
	public ArrayList<Curso> getAll() {
		ArrayList<Curso> cursos = null;

		try(CursoDAO dao = new CursoDAO()){
			cursos = dao.getAll();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return cursos;
	}

}
