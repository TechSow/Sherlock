package br.com.techsow.sherlock.model.interfaces.repository;

import java.util.List;

import br.com.techsow.sherlock.model.entities.Materia;

public interface IMateriaRepository extends IBaseRepository<Materia>{
	public List<Materia> getMateriasFromCursoId(int id_curso) throws Exception;
}
