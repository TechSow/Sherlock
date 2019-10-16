package br.com.techsow.sherlock.model.bo;

import br.com.techsow.sherlock.model.dao.UnansweredDAO;

public class UnansweredBO {

	public int add(int id_usuario, String mensagem, InputStream audio) {

		Unanswered unanswered = new Unanswered(id_usuario: id_usuario, mensagem, audio);
		try (UnansweredDAO dao = new UnansweredDAO()) {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
