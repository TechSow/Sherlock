package br.com.techsow.sherlock.model.dao;

import br.com.techsow.sherlock.model.interfaces.repository.IConteudoRepository;
import br.com.techsow.sherlock.model.services.ConnectionFactory;

public class PessoaDAO extends BaseDAO implements IConteudoRepositor{


	public PessoaDAO() throws Exception {

			conn = ConnectionFactory.getConnection();
	}


	public Pessoa getPessoa(int id) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM  TS_T_PESSOA WHERE ID_PESSOA=?");
		stmt.setInt(1, id);
		rs=stmt.executeQuery();
		
		if(rs.next()) {
			return new Pessoa(
					rs.getInt("ID_PESSOA"),
					rs.getString("NOME"),
					rs.getString("SOBRENOME"),
					new UsuarioDAO().getUser(rs.getInt("ID_USUARIO")));
					
		}else {
			return new Pessoa();
		}
	}
	
	
	public int addPessoa(Pessoa p)throws Exception{
		stmt=con.prepareStatement("insert into TS_T_PESSOA (ID_PESSOA,NOME,SOBRENOME,ID_USUARIO) values(?,?,?,?)");
		stmt.setInt(1, p.getId());
		stmt.setString(2, p.getNome());
		stmt.setString(3, p.getSobrenome());
		stmt.setInt(4, p.getUsuarioId().getId());
		return stmt.executeUpdate();
	}
	
	
	public int killPessoa(int id) throws Exception{
		stmt = con.prepareStatement("delete from TS_T_PESSOA where ID_PESSOA =? ");
		stmt.setInt(1, id);
		return stmt.executeUpdate();

	}
	
	
	public int updateNome(Pessoa pessoa, String nomeNovo) throws Exception{

		int idPessoa = pessoa.getId(); 
		stmt = con.prepareStatement("UPDATE TS_T_PESSOA SET NOME =? WHERE ID_PESSOA=?");

		stmt.setString(1, nomeNovo);
		stmt.setInt(2, idPessoa);

		return stmt.executeUpdate();

	}
	
	
	public int updateSobreNome(Pessoa pessoa, String sobreNomeNovo) throws Exception{

		int idPessoa = pessoa.getId(); 
		stmt = con.prepareStatement("UPDATE TS_T_PESSOA SET SOBRENOME=? WHERE ID_PESSOA=?");

		stmt.setString(1, sobreNomeNovo);
		stmt.setInt(2, idPessoa);

		return stmt.executeUpdate();

	}
	
	public int updateIdade(Pessoa pessoa, int idadeNova) throws Exception{

		int idPessoa = pessoa.getId(); 
		stmt = con.prepareStatement("UPDATE TS_T_PESSOA SET IDADE=? WHERE ID_PESSOA=?");

		stmt.setInt(1, idadeNova);
		stmt.setInt(2, idPessoa);

		return stmt.executeUpdate();

	}
	
	
	public void close() throws SQLException{
		con.close();
	}
}
