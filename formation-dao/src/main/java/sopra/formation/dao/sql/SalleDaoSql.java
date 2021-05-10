package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.ISalleDao;
import sopra.formation.model.Evaluation;
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
			ps = conn.prepareStatement("SELECT ID, NOM, CAPACITE, VIDEO_PROJECTEUR, RUE, COMPLEMENT, CODE_POSTAL, VILLE FROM salle");
			rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("ID");
				String nom = rs.getString("NOM");
				Integer capacite = rs.getInt("CAPACITE");
				Boolean videoProjecteur = rs.getString("VIDEO_PROJECTEUR").contentEquals("O") ? true : false ;

				Salle salle = new Salle(nom, capacite, videoProjecteur);

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
