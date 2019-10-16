package br.com.techsow.sherlock.model.bo;




import br.com.techsow.sherlock.model.dao.UnansweredDAO;
import br.com.techsow.sherlock.model.entities.Unanswered;

public class UnansweredBO {

	public int add(int id_usuario, String mensagem, byte[] audio) {

		Unanswered unanswered = new Unanswered.Builder()
								.usuarioId(id_usuario)
								.mensagem(mensagem)
								.audio(audio)
								.build();
		int ret = 0;
		
		try (UnansweredDAO dao = new UnansweredDAO()) {
			ret = dao.add(unanswered);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

}
