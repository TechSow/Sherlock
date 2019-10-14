package br.com.techsow.sherlock.model.bo;

import java.util.ArrayList;

import br.com.techsow.sherlock.model.dao.ConteudoDAO;
import br.com.techsow.sherlock.model.entities.Conteudo;
import br.com.techsow.sherlock.model.interfaces.bo.IConteudoBO;

public class ConteudoBO implements IConteudoBO {

	public ArrayList<Conteudo> getConteudoFromMateriaId(int id_materia) {
		ArrayList<Conteudo> conteudos = new ArrayList<Conteudo>();

		try (ConteudoDAO dao = new ConteudoDAO()) {
			conteudos = dao.getConteudoFromMateriaId(id_materia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conteudos;
	}

	
	public String add(Conteudo obj) {
	
		return "NOK";
	}

	
	public Conteudo getById(int id) {
		Conteudo conteudo = null;
		try(ConteudoDAO dao = new ConteudoDAO()){
			conteudo = dao.getById(id);
		}catch( Exception e) {
			e.printStackTrace();
		}
		return conteudo;
	}

	@Override
	public int kill(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Conteudo obj) {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
