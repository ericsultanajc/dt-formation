package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.ISalleDao;
import sopra.formation.model.Matiere;
import sopra.formation.model.Salle;

public class SalleDaoSql implements ISalleDao {

	@Override
	public List<Salle> findAll() {
		List<Salle> salles = new ArrayList<Salle>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT id, nom, capacite, video_projecteur, rue, complement, code_postal, ville FROM salle");
			rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String nom = rs.getString("nom");
				Integer capacite = rs.getInt("capacite");
				String video_projecteur = rs.getString("video_projecteur");
				String rue = rs.getString("rue");
				String complement = rs.getString("complement");
				String code_postal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				
				

				Salle salle = new Salle(id, nom, capacite, video_projecteur, rue, complement, code_postal, ville);

				salles.add(salle);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return salles;
	}

	@Override
	public Salle findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Salle obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Salle obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Salle obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
