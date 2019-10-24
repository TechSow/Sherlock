package br.com.techsow.sherlock.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.PessoaBO;
import br.com.techsow.sherlock.model.bo.UsuarioBO;
import br.com.techsow.sherlock.model.entities.Pessoa;
import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.exception.LengthException;
import br.com.techsow.sherlock.model.interfaces.web.Task;

public class CadastroUsuario implements Task {
	/**
	 * @author Italo
	 * 
	 *         Classe criada para lidar com as requisicoes de criacao de novos usuarios
	 *         A requisicao vem da Servlet Controller
	 * @throws LengthException 
	 */
	@Override
	public String processTask(HttpServletRequest req, HttpServletResponse resp) throws LengthException {


		
		int from = Integer.parseInt(req.getParameter("from"));
		String email = req.getParameter("email");
		String apelido = req.getParameter("apelido");
		String senha = req.getParameter("senha");



		if(from == 1) {
			try {

				Usuario usuario = new Usuario(email, apelido, senha,0,0,1);
				new UsuarioBO().add(usuario);
			} catch (Exception e) {
				req.setAttribute("erro", new String[] {e.getMessage(), "danger", "exclamation"});
			}
			return "admin.jsp";

		}else if(from == 2) {
			
			String idUsuario = req.getParameter("idUsuario");
			int id = Integer.parseInt(idUsuario.replaceAll("\\D+",""));

			try {
				Usuario usuario = new Usuario(id, email, apelido, senha);
				if(email != null && !email.isEmpty()) {
					new UsuarioBO().updateEmail(usuario, email);
				}
				
				
				new UsuarioBO().updateSenha(usuario, senha);
				new UsuarioBO().updateApelido(usuario, apelido);
			} catch (Exception e) {
				req.setAttribute("erro", new String[] {e.getMessage(), "danger", "exclamation"});
			}

			return "pessoa.jsp";


		}else {

			try {

				Usuario usuario = new Usuario(email, apelido, senha,0,0,1);
				new UsuarioBO().add(usuario);
			} catch (Exception e) {
				req.setAttribute("erro", new String[] {e.getMessage(), "danger", "exclamation"});
			}

			return "login.jsp";
		}





	}
}
