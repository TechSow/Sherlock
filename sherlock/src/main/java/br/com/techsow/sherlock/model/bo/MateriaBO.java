package br.com.techsow.sherlock.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.techsow.sherlock.model.dao.MateriaDAO;
import br.com.techsow.sherlock.model.entities.Materia;
import br.com.techsow.sherlock.model.interfaces.bo.IMateriaBO;

public class MateriaBO implements IMateriaBO{

	
	public String add(Materia obj) {
		
		if(materia.getEmenta().length() > 100) {
			return "Tamanho da descricao excedeu o limite de caracteres";
		}

		if(materia.getNome().length() > 100) {
			return "Nome da matéria maior do que o esperado";
		}

		if(materia.getId_curso().getId() == 0) {
			return "ID do curso nao encontrado. Curso não existe";
		}

		
		CursoDAO cursoDao = null;
		try {
			
			cursoDao = new CursoDAO();
			if(cursoDao.getCursoId(materia.getId_curso().getId()) == 1) {
				return "O curso informado ja contem essa máteria";
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		

		/////////////////////////////////////////
		//Espaco para os requisitos funcioinais//
		/////////////////////////////////////////


		MateriaDAO materiaDao = null;
		int retorno = 0;

		try {
			materiaDao = new MateriaDAO();
			retorno = materiaDao.addMateria(materia)	;


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				materiaDao.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		if(retorno == 1) {
			return "Materia criada com sucesso";
		}else {
			return "Materia não pode ser cadastrado. Verificar dados informados";
		}

	}			}

	
	public Materia getById(int id) {
		
		return null;
	}

	
	public int kill(int id) {
		
		return 0;
	}

	
	public int update(Materia obj) {
		
		return 0;
	}

	
	public ArrayList<Materia> getMateriasFromCursoId(int id_curso) {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		try(MateriaDAO dao = new MateriaDAO()){
			materias = dao.getMateriasFromCursoId(id_curso);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return materias;
	}
	
}
