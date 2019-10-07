package br.com.techsow.sherlock.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.techsow.sherlock.model.dao.MateriaDAO;
import br.com.techsow.sherlock.model.entities.Materia;
import br.com.techsow.sherlock.model.interfaces.bo.IMateriaBO;

public class MateriaBO implements IMateriaBO{

	
	public int add(Materia obj) {
		
		return 0;
	}

	
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
