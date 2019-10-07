package br.com.techsow.sherlock.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.techsow.sherlock.model.dao.CursoDAO;
import br.com.techsow.sherlock.model.entities.Curso;
import br.com.techsow.sherlock.model.interfaces.bo.ICursoBO;

public class CursoBO implements ICursoBO{

	
	
	public int add(Curso obj) {
		
		return 0;
	}

	
	public Curso getById(int id) {
		
		return null;
	}

	
	public int kill(int id) {
		
		return 0;
	}

	
	public int update(Curso obj) {
		
		return 0;
	}

	
	public int updateNome(Curso c, String nome) {
		
		return 0;
	}

	
	public int updateDescricao(Curso c, String descricao) {
		
		return 0;
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
