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



		String idUsuario = req.getParameter("idUsuario");
		int id = Integer.parseInt(idUsuario.replaceAll("\\D+",""));
		int from = Integer.parseInt(req.getParameter("from"));
		String email = req.getParameter("email");
		String apelido = req.getParameter("apelido");
		String senha = req.getParameter("senha");
		String nome = req.getParameter("nome");
		String sobrenome = req.getParameter("sobrenome");

		Usuario usuario = new Usuario(id, email, apelido, senha, 0,0,1);
		
		//Usuario usuario = new Usuario(idUsuario, email, apelido, senha,0,0,1);
		Pessoa pessoa = new Pessoa(nome, sobrenome, usuario);


		if(from == 1) {

			String usuarioBO = null; 
			Pessoa newPessoa = null;
			
			try {
				usuarioBO = new UsuarioBO().add(usuario); 
				new PessoaBO().addPessoa(pessoa);

			
			}catch (Exception e) { req.setAttribute("erro", new String[] {e.getMessage(),"danger", "exclamation"}); 
			}

			return "admin.jsp"; 
		
		} else if(from == 2) {

			
			Usuario userFromBo = new UsuarioBO().getById(usuario.getIdUsuario());
			Pessoa pessoaFromBO = null; 
			try {

				int retorno;
				if(userFromBo.getEmail() != usuario.getEmail()) {
					new UsuarioBO().updateEmail(usuario, usuario.getEmail());
				}
				if(userFromBo.getSenha() != usuario.getSenha()) {
					new UsuarioBO().updateSenha(usuario.getEmail(), usuario.getSenha());
				}

				pessoaFromBO = new PessoaBO().getByUserId(usuario.getIdUsuario());

				if(pessoa.getNome() != pessoaFromBO.getNome()) {

					new PessoaBO().updateNome(usuario, nome);
				}

				if(pessoa.getSobrenome() != pessoaFromBO.getSobrenome()) {
					new PessoaBO().updateNome(usuario, sobrenome);
				}


				return "pessoa.jsp";

			} catch (Exception e) {
				req.setAttribute("erro", new String[] {e.getMessage(), "danger", "exclamation"});
			}

		}

		return "cadastro.jsp";


	}
}
