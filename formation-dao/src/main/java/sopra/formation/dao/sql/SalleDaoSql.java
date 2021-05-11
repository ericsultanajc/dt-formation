package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.ISalleDao;
import sopra.formation.model.Matiere;
import sopra.formation.model.Salle;

public class SalleDaoSql implements ISalleDao{

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
				Boolean videoProjecteur = rs.getString("video_projecteur").contentEquals("O") ? true : false;
				String rue = rs.getString("rue");
				String complement = rs.getString("complement)");
				String code_postal = rs.getNString("code_postal");
				String ville = rs.getString("ville");

				Salle salle = new Salle(id, nom, capacite, videoProjecteur);
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
		Salle salle = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT nom, capacite, videoProjecteur FROM salle WHERE id = ?");
			
			ps.setLong(1, id);
			
			rs = ps.executeQuery();

			if (rs.next()) {
				String nom = rs.getString("nom");
				Integer capacite = rs.getInt("capacite");
				Boolean videoProjecteur = rs.getString("video_projecteur").contentEquals("O") ? true : false;
			
				salle = new Salle(id, nom, capacite, videoProjecteur);
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
		return salle;
	}

	@Override
	public void create(Salle obj) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("INSERT INTO salle (nom, capacite, video_projecteur) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
						
			ps.setString(1, obj.getNom());
			ps.setInt(2, obj.getCapacite());
			ps.setBoolean(3, obj.getVideoProjecteur());
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				rs = ps.getGeneratedKeys();
				if(rs.next()) {
					Long id = rs.getLong(1);
					obj.setId(id);
				}
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
	}

	@Override
	public void update(Salle obj) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("UPDATE salle SET nom = ?, capacite = ?,, videoProjecteur = ? WHERE id = ?");
						
			ps.setString(1, obj.getNom());
			ps.setInt(2, obj.getCapacite());
			ps.setBoolean(3, obj.getVideoProjecteur());
			
			int rows = ps.executeUpdate();
			
			if(rows != 1) {
				// TODO renvoyer une exception
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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
	}

	@Override
	public void delete(Salle obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("DELETE FROM salle WHERE id= ?");
			
			ps.setLong(1, id);
			
			int rows = ps.executeUpdate();
			
			if(rows != 1) {
				// TODO renvoyer une exception
			}
		

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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
	}

}
