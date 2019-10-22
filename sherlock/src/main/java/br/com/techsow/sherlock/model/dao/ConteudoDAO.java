package br.com.techsow.sherlock.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.techsow.sherlock.model.entities.Conteudo;
import br.com.techsow.sherlock.model.interfaces.repository.IConteudoRepository;
import br.com.techsow.sherlock.model.services.ConnectionFactory;

public class ConteudoDAO extends BaseDAO implements IConteudoRepository {

	public ConteudoDAO() throws Exception {
		conn = ConnectionFactory.getConnection();
	}

	public int add(Conteudo obj) throws SQLException {

		return 0;
	}

	public Conteudo getById(int id) throws Exception {
		Conteudo conteudo= null;
		stmt = conn.prepareStatement("SELECT * FROM TS_T_CONTEUDO WHERE ID_CONTEUDO = ?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			int id_conteudo = rs.getInt(1);
			String nome = rs.getString (2);
			String url_pdf = rs.getString(3);
			int hasbot = rs.getInt(4);
			
			conteudo = new Conteudo(id_conteudo, nome, url_pdf, hasbot);
			
		}
		return conteudo;
	}

	public int kill(int id) throws Exception {

		return 0;
	}

	public int update(Conteudo obj) throws Exception {

		return 0;
	}

	public void close() throws SQLException {
		conn.close();

	}

	public ArrayList<Conteudo> getConteudoFromMateriaId(int id_materia) throws Exception {
		ArrayList<Conteudo> conteudos = new ArrayList<Conteudo>();
		stmt = conn.prepareStatement(
				"select ID_CONTEUDO, TITULO, URL_PDF, HASBOT from ts_t_materia_conteudo inner join ts_t_CONTEUDO on TS_T_MATERIA_CONTEUDO.FK_ID_CONTEUDO = TS_T_CONTEUDO.ID_CONTEUDO where ts_t_materia_conteudo.fk_id_materia = ? ORDER BY ORDEM");
		stmt.setInt(1, id_materia);
		rs = stmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt(1);
			String titulo = rs.getString(2);
			String url_pdf = rs.getString(3);
			int hasbot = rs.getInt(4);
			conteudos.add(new Conteudo(id,titulo,url_pdf,hasbot));
			
		}
		return conteudos;
	}

}
