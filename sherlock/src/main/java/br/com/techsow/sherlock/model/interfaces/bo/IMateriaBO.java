package br.com.techsow.sherlock.model.interfaces.bo;

import java.util.List;

import br.com.techsow.sherlock.model.entities.Materia;

public interface IMateriaBO extends IBaseBO<Materia>{
	public List<Materia> getMateriasFromCursoId(int id_curso);
}
