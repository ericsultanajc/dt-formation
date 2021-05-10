package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.model.Matiere;

public class MatiereDaoSql implements IMatiereDao {

	@Override
	public List<Matiere> findAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT ID, COMPORTEMENTALE, TEHCNIQUE, COMMENTAIRES FROM evaluation");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Long id = rs.getLong("id");
				Integer comportementale = rs.getInt("COMPORTEMENTALE");
				Integer technique = rs.getInt("TECHNIQUE");
				String commentaire = rs.getString("COMMENTAIRES");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(conn != null) {
					conn.close();
				}
				if(ps != null) {
					ps.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Matiere findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Matiere obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Matiere obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Matiere obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
