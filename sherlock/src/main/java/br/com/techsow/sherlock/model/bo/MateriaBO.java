package br.com.techsow.sherlock.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.techsow.sherlock.model.dao.MateriaDAO;
import br.com.techsow.sherlock.model.entities.Conteudo;
import br.com.techsow.sherlock.model.entities.Materia;
import br.com.techsow.sherlock.model.exception.LengthException;
import br.com.techsow.sherlock.model.exception.NumberException;
import br.com.techsow.sherlock.model.interfaces.bo.IMateriaBO;

public class MateriaBO implements IMateriaBO{


	public String add(Materia materia) throws LengthException {

		if(materia.getEmenta().length() > 100) throw new  LengthException("Ementa excedeu quantidade de caracteres");

		if(materia.getNome().length() > 100) throw new  LengthException("\"Nome da matéria maior do que o esperado.\""); {
			
		}

		if(materia.geturlImg().length() > 300) throw new  LengthException("URL da imagem excedeu quantidade de caracteres");
		
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


		
		int retorno = 0;

		try (MateriaDAO materiaDao = new MateriaDAO()){
			
			retorno = materiaDao.add(materia);


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try (MateriaDAO materiaDao = new MateriaDAO()){
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

	public ArrayList<Materia> getAll(){

		ArrayList<Materia> materias = new ArrayList<Materia>();

		try (MateriaDAO dao = new MateriaDAO()) {
			materias = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return materias;
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


	public String updateNome(Materia m, String nomeNovo) throws LengthException {

		if(nomeNovo.length() > 100) throw new  LengthException("Nome excedeu quantidade de caracteres");

		try (MateriaDAO dao = new MateriaDAO()){
			dao.updateNome(m, nomeNovo);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Materia Adicionada";
	}

	public String updateEmenta(Materia m, String novaEmenta) throws NumberException {

		if(novaEmenta.length() > 100) throw new  NumberException("Ementa excedeu quantidade de caracteres");

		try (MateriaDAO dao = new MateriaDAO()){
			dao.updateEmenta(m, novaEmenta);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Materia Adicionada";
	}
	
	public String updateUrlImg(Materia materia, String urlImg) {
		
		try (MateriaDAO dao = new MateriaDAO()){
			dao.updateUrlImg(materia, urlImg);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Imagem da materia atualizada";
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
