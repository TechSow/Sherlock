package br.com.techsow.sherlock.model.bo;

import java.sql.SQLException;

import br.com.techsow.sherlock.model.dao.PessoaDAO;
import br.com.techsow.sherlock.model.dao.UsuarioDAO;
import br.com.techsow.sherlock.model.entities.Pessoa;
import br.com.techsow.sherlock.model.entities.Usuario;
import br.com.techsow.sherlock.model.exception.DuplicatedException;
import br.com.techsow.sherlock.model.exception.LengthException;

public class PessoaBO {

	public int addPessoa(Pessoa pessoa) throws LengthException, DuplicatedException {

		if(pessoa.getNome().length()>20)throw new  LengthException("Nome excedeu quantidade de caracteres");
		if(pessoa.getSobrenome().length()>30) throw new  LengthException("Sobrenome excedeu quantidade de caracteres");
		
		
		Pessoa verificarId = null;
		try (PessoaDAO dao = new PessoaDAO()) {

			
			verificarId = dao.getById(pessoa.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}

		if(verificarId.getId() > 0) throw new DuplicatedException("\"Parece que ja existe um cadastro para essa pessoa. Para alterar suas informações, utilize a classe de teste Update{nome/sobrenome}\"");
		if(pessoa.getUsuarioId().getIdUsuario() ==1) throw new DuplicatedException("Ja existe um cadastro para esse Usuario");
		
		int ret = 0;

		try (PessoaDAO dao = new PessoaDAO()){

			ret = dao.add(pessoa);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try (PessoaDAO dao = new PessoaDAO()){
				dao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return ret; 
		
	}	
	
	//////////////////////////////////////////////////////
	
	
	public String deleteUser(int id) throws Exception{

		
		int retorno =0;
		try (PessoaDAO dao = new PessoaDAO()){

				retorno = dao.killPessoa(id);

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try(PessoaDAO dao = new PessoaDAO()) {
				dao.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		if (retorno == 1) {
			return "Pessoa deletada com sucesso";
		}else {
			return "Pessoa não pode ser deletado. Verificar as informações fornecidas";			
		}

	}

	public Pessoa getByUserId(int id) throws Exception{
		Pessoa pessoa = null;
		try (PessoaDAO dao = new PessoaDAO()){
			
			pessoa = dao.getByUserId(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pessoa;
	}
	
	
	public int updateNome(Pessoa pessoa, String nomeNovo){
		
		try (PessoaDAO dao = new PessoaDAO()){
			dao.updateNome(pessoa, nomeNovo);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int updateSobrenome(Usuario user, String sobrenomeNovo){
		
		try (PessoaDAO dao = new PessoaDAO()){
			dao.updateSobrenome(user, sobrenomeNovo);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
