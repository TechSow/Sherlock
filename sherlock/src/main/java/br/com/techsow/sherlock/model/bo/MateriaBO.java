package br.com.techsow.sherlock.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.techsow.sherlock.model.dao.MateriaDAO;
import br.com.techsow.sherlock.model.entities.Materia;
import br.com.techsow.sherlock.model.interfaces.bo.IMateriaBO;

public class MateriaBO implements IMateriaBO{


	public String add(Materia materia) {

		if(materia.getEmenta().length() > 100) {
			return "Tamanho da descricao excedeu o limite de caracteres.";
		}

		if(materia.getNome().length() > 100) {
			return "Nome da matéria maior do que o esperado.";
		}

		if(materia.geturlImg().length() > 300) {
			return "URL ultrapassa tamanho de 300 caracteres.";
		}
		/* Curso foi retirado da entidade materia
		 * if(materia.getId_curso().getId() == 0) { return
		 * "ID do curso nao encontrado. Curso não existe"; }
		 */


		/*Necessário avaliar como validar se uma materia ja pertence a um curso
		 * 
		 * CursoDAO cursoDao = null; try {
		 * 
		 * cursoDao = new CursoDAO();
		 * if(cursoDao.getCursoId(materia.getId_curso().getId()) == 1) { return
		 * "O curso informado ja contem essa máteria"; } } catch (Exception e1) {
		 * e1.printStackTrace(); }
		 */


		/////////////////////////////////////////
		//Espaco para os requisitos funcioinais//
		/////////////////////////////////////////


		MateriaDAO materiaDao = null;
		int retorno = 0;

		try {
			materiaDao = new MateriaDAO();
			retorno = materiaDao.add(materia);


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

	}			


	public Materia getById(int id) {
		Materia materia= null;


		try (MateriaDAO dao = new MateriaDAO()) {
			materia = dao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return materia;
	}


	public int kill(int id) {

		return 0;
	}


	public String updateNome(Materia m, String nomeNovo) {

		if(nomeNovo.length() > 100) {
			return "Nome da matéria maior do que o esperado";
		}

		try (MateriaDAO dao = new MateriaDAO()){
			dao.UpdateNome(m, nomeNovo);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Materia Adicionada";
	}

	public String updateEmenta(Materia m, String novaEmenta) {

		if(novaEmenta.length() > 100) {
			return "Ementa excede quantidade de caracteres.";
		}

		try (MateriaDAO dao = new MateriaDAO()){
			dao.UpdateEmenta(m, novaEmenta);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Materia Adicionada";
	}


	// Nao esta sendo utilizado, mas a interface obriga a implementacao
	public int update(Materia m) {
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
