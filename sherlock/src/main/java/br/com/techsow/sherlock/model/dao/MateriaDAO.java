package br.com.techsow.sherlock.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.techsow.sherlock.model.entities.Conteudo;
import br.com.techsow.sherlock.model.entities.Materia;
import br.com.techsow.sherlock.model.interfaces.repository.IMateriaRepository;
import br.com.techsow.sherlock.model.services.ConnectionFactory;

public class MateriaDAO extends BaseDAO implements IMateriaRepository{

	public MateriaDAO() throws Exception{
		conn = ConnectionFactory.getConnection();
	}


	public int add(Materia m) throws SQLException {

		stmt=conn.prepareStatement("insert into TS_T_MATERIA(ID_MATERIA,NOME_MATERIA,EMENTA_MATERIA, URLIMG_MATERIA)VALUES(c_materia_seq.nextval,?,?,?)");
		stmt.setString(1, m.getNome());
		stmt.setString(2, m.getEmenta());
		stmt.setString(3, m.geturlImg());
		return stmt.executeUpdate();

	}


	public Materia getById(int id) throws SQLException {

		stmt=conn.prepareStatement("SELECT * FROM TS_T_MATERIA WHERE ID_MATERIA=?");
		stmt.setInt(1, id);
		rs=stmt.executeQuery();
		if(rs.next()) {
			return new Materia(
					rs.getInt("ID_MATERIA"),
					rs.getString("NOME_MATERIA"),
					rs.getString("EMENTA_MATERIA"),
					rs.getString("URLIMG_MATERIA"));

		}else {

			return new Materia();
		}
	}


	public ArrayList<Materia> getAll() throws SQLException {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		stmt=conn.prepareStatement("SELECT * FROM TS_T_MATERIA");
		rs=stmt.executeQuery();
		while(rs.next()) {

			materias.add(new Materia(
					rs.getInt("ID_MATERIA"),
					rs.getString("NOME_MATERIA"),
					rs.getString("EMENTA_MATERIA"),
					rs.getString("URLIMG_MATERIA")));

		}

		return  materias;
	}

	public int kill(int id) throws Exception {

		stmt=conn.prepareStatement("DELETE FROM TS_T_MATERIA WHERE ID_MATERIA=?");
		stmt.setInt(1, id);
		return stmt.executeUpdate();
	}


	public int update(Materia obj) throws Exception {

		return 0;
	}

	public int updateNome(Materia m,String nomeNovo)throws SQLException{
		stmt=conn.prepareStatement("UPDATE TS_T_MATERIA SET NOME_MATERIA=? WHERE ID_MATERIA=?" );
		stmt.setString(1, nomeNovo);
		stmt.setInt(2, m.getId_materia());
		return stmt.executeUpdate();
	}

	public int updateUrlImg(Materia materia, String urlImg) throws SQLException{

		stmt=conn.prepareStatement("UPDATE TS_T_MATERIA SET URLIMG_MATERIA=? WHERE ID_MATERIA=?" );
		stmt.setString(1, urlImg);
		stmt.setInt(2, materia.getId_materia());
		return stmt.executeUpdate();

	}

	public int updateEmenta(Materia m,String novaEmenta)throws SQLException{
		stmt=conn.prepareStatement("UPDATE TS_T_MATERIA set EMENTA_MATERIA=? WHERE ID_MATERIA=?");
		stmt.setString(1, novaEmenta);
		stmt.setInt(2, m.getId_materia());
		return stmt.executeUpdate();
	}


	public void close() throws SQLException {
		conn.close();

	}

	public ArrayList<Materia> getMateriasFromCursoId(int id_curso) throws Exception {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		stmt = conn.prepareStatement("SELECT ID_MATERIA, NOME_MATERIA, EMENTA_MATERIA, URLIMG_MATERIA FROM TS_T_CURSO_MATERIA INNER JOIN TS_T_CURSO ON TS_T_CURSO_MATERIA.FK_ID_CURSO = TS_T_CURSO.ID_CURSO INNER JOIN TS_T_MATERIA ON TS_T_MATERIA.ID_MATERIA = TS_T_CURSO_MATERIA.FK_ID_MATERIA WHERE FK_ID_CURSO = ?");
		stmt.setInt(1, id_curso);
		rs = stmt.executeQuery();

		while(rs.next()) {
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String ementa = rs.getString(3);
			String urlImg = rs.getString(4);
			materias.add(new Materia(id,nome,ementa,urlImg));

		}

		return materias;
	}




}
