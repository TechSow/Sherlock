package br.com.techsow.sherlock.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.techsow.sherlock.model.dao.CursoDAO;
import br.com.techsow.sherlock.model.entities.Curso;
import br.com.techsow.sherlock.model.exception.LengthException;
import br.com.techsow.sherlock.model.exception.NumberException;
import br.com.techsow.sherlock.model.interfaces.bo.ICursoBO;

public class CursoBO implements ICursoBO{



	public String add(Curso curso) throws LengthException, NumberException {

		if(curso.getDescricao().length() > 255) throw new  LengthException("Descrição excedeu quantidade de caracteres");
		if(curso.getDuracao() <= 0) throw new NumberException("Numero de duração de curso inválido");
		if(curso.getDuracao() > 100) throw new NumberException("Numero de duração de curso inválido");
		if(curso.getNome().length() > 100) throw new  LengthException("Nome excedeu quantidade de caracteres");

		/*
		 * if(curso.getUrlImg().length() >200 ) throw new  NumberException("Descrição excedeu quantidade de caracteres");
		 */

		if(curso.getDificuldade() <1 || curso.getDificuldade() > 5 ) throw new NumberException("Numero da dificuldade inválido");

		
		int retorno=0;

		try (CursoDAO dao = new CursoDAO()){

			retorno = dao.add(curso);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try (CursoDAO dao = new CursoDAO()){
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


	public String updateNome(Curso c, String nome) throws LengthException {
		if(nome.length() > 100) throw new  LengthException("Nome excedeu quantidade de caracteres");

		try (CursoDAO dao = new CursoDAO()){
			dao.updateNome(c, nome);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Nome alterado com sucesso";
	}


	public String updateDescricao(Curso c, String descricao) throws LengthException {

		if(descricao.length() > 255) throw new  LengthException("Descrição excedeu quantidade de caracteres");

		try (CursoDAO dao = new CursoDAO()){
			dao.updateDescricao(c, descricao);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Descrição alterada";
	}



	public String updateDuracao(Curso c, int duracao) throws NumberException {

		if(c.getDuracao() <= 0 ) throw new  NumberException("Valor invalido para Duracao");

		try (CursoDAO dao = new CursoDAO()){
			dao.updateDuracao(c, duracao);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Duração alterada";
	}


	public String updateURL(Curso c, String url) throws LengthException {

		if(c.getUrlImg().length() >200 ) throw new  LengthException("URL da Imagem excedeu quantidade de caracteres");

		try (CursoDAO dao = new CursoDAO()){
			dao.updateUrl(c, url);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "URL alterada";
	}


	public String updateDificuldade(Curso c, int dificuldade) throws NumberException {

		if(c.getDificuldade() >200 ) throw new  NumberException("Dificuldade excedeu quantidade de caracteres");

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
