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

}
