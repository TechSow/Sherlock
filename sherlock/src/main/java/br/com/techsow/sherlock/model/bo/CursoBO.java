package br.com.techsow.sherlock.model.bo;

import java.util.ArrayList;

import br.com.techsow.sherlock.model.dao.CursoDAO;
import br.com.techsow.sherlock.model.entities.Curso;
import br.com.techsow.sherlock.model.exception.ApelidoException;
import br.com.techsow.sherlock.model.exception.DuplicatedException;
import br.com.techsow.sherlock.model.exception.EmailNotFound;
import br.com.techsow.sherlock.model.exception.LengthException;
import br.com.techsow.sherlock.model.exception.NumberException;
import br.com.techsow.sherlock.model.interfaces.bo.ICursoBO;

public class CursoBO implements ICursoBO {

	public String add(Curso curso, String[] materias) throws LengthException, NumberException {

		if (curso.getDescricao().length() > 255)
			throw new LengthException("Descrição excedeu quantidade de caracteres");
		if (curso.getDuracao() <= 0)
			throw new NumberException("Numero de duração de curso inválido");
		if (curso.getUrlImg() == null)
			throw new LengthException("Imagem nao existe");
		if (curso.getNome().length() > 100)
			throw new LengthException("Nome excedeu quantidade de caracteres");
		if(materias.length <=0 ) throw new LengthException("Adicione ao menos uma matéria");
		/*
		 * if(curso.getUrlImg().length() >200 ) throw new
		 * NumberException("Descrição excedeu quantidade de caracteres");
		 */

		if (curso.getDificuldade() < 1 || curso.getDificuldade() > 5)
			throw new NumberException("Numero da dificuldade inválido");

		int retorno = 0;

		try (CursoDAO dao = new CursoDAO()) {

			retorno = dao.add(curso);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Curso curso2 = this.getNoRelationedCurseId();
		this.relateCursoMateria(curso2.getId_curso(), materias);

		if (retorno == 1) {
			return "Sucesso ao adicionar curso";
		} else {
			return "Sem sucesso";
		}
	}

	public Curso getNoRelationedCurseId() {
		Curso curso = null;
		try (CursoDAO dao = new CursoDAO()) {
			curso = dao.getNoRelationedCurseId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curso;
	}

	public int relateCursoMateria(int cursoId,String[] materias ) {
		for(int i = 0; i < materias.length; i++) {

			try(CursoDAO dao = new CursoDAO()){
				dao.relateCursoMateria(cursoId, Integer.parseInt(materias[i]));
			}catch(Exception e) {
				e.printStackTrace();			
			}

		}



		return 0;
	}

	public Curso getById(int id) {
		Curso curso = null;

		try (CursoDAO dao = new CursoDAO()) {
			curso = dao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return curso;
	}

	public int kill(int id) {
		try(CursoDAO dao = new CursoDAO()){
			dao.killRelationBetweenCursoAndMateria(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		int ret= 0;
		try(CursoDAO dao = new CursoDAO()){
			ret = dao.kill(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return ret;
	}

	public int updateCurso(Curso obj, String[] materias) throws LengthException, NumberException {
		if (obj.getDescricao().length() > 255)
			throw new LengthException("Descrição excedeu quantidade de caracteres");
		if (obj.getDuracao() <= 0)
			throw new NumberException("Numero de duração de curso inválido");
		if (obj.getUrlImg() == null)
			throw new LengthException("Imagem nao existe");
		if (obj.getNome().length() > 100)
		if(materias.length <=0 ) throw new LengthException("Adicione ao menos uma matéria");
		
		int retCurso = 0;
		int dellCursos =0;
		try(CursoDAO dao = new CursoDAO()){
			retCurso = dao.update(obj);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(CursoDAO dao = new CursoDAO()){
			dellCursos = dao.killRelationBetweenCursoAndMateria(obj.getId_curso());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		relateCursoMateria(obj.getId_curso(),materias);
		
		if(retCurso == 1 && dellCursos > 0)
			return 1;
		else
			return 0;
	}

	

	public ArrayList<Curso> getAll() {
		ArrayList<Curso> cursos = null;

		try (CursoDAO dao = new CursoDAO()) {
			cursos = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cursos;
	}

	@Override
	public String add(Curso obj)
			throws DuplicatedException, ApelidoException, EmailNotFound, LengthException, NumberException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Curso obj) {
		// TODO Auto-generated method stub
		return 0;
	}	

}
