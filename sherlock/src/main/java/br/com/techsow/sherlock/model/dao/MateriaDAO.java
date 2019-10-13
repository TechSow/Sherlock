package br.com.techsow.sherlock.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.techsow.sherlock.model.entities.Materia;
import br.com.techsow.sherlock.model.interfaces.repository.IMateriaRepository;
import br.com.techsow.sherlock.model.services.ConnectionFactory;

public class MateriaDAO extends BaseDAO implements IMateriaRepository{

	public MateriaDAO() throws Exception{
		conn = ConnectionFactory.getConnection();
	}
	
	
	public int add(Materia obj) throws SQLException {
		stmt=con.prepareStatement("insert into TS_T_MATERIA(ID_MATERIA,TS_T_CURSO_ID_CURSO,NOME,EMENTA)VALUES(?,?,?,?)");
		stmt.setInt(1, m.getId());
		stmt.setInt(2, m.getId_curso().getId());
		stmt.setString(3, m.getNome());
		stmt.setString(4, m.getEmenta());
		return stmt.executeUpdate();
		return 0;
	}

	
	public Materia getById(int id) throws Exception {
		
		return null;
	}

	
	public int kill(int id) throws Exception {
		
		return 0;
	}

	
	public int update(Materia obj) throws Exception {
		
		return 0;
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
