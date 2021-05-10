package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Matiere;
import sopra.formation.model.Matiere;
import sopra.formation.model.Matiere;

public class MatiereDaoSql implements IMatiereDao {
	@Override
	public List<Matiere> findAll() {
		List<Matiere> matieres = new ArrayList<Matiere>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT id, nom, duree FROM matiere");
			rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String nom = rs.getString("nom");
				Integer duree = rs.getInt("duree");

				Matiere matiere =  new Matiere(id, nom, duree);

				matieres.add(matiere);
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
		
		return matieres;
	}
	
	@Override
	public Matiere findById(Long id) {
		Matiere matiere = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT id, nom, duree FROM matiere WHERE id = ?");
			
			ps.setLong(1, id);
			
			rs = ps.executeQuery();

			if (rs.next()) {
				String nom = rs.getString("nom");
				Integer duree = rs.getInt("duree");

				matiere = new Matiere(id, nom, duree);
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
		
		return matiere;
	}
	
	@Override
	public void create(Matiere obj) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("INSERT INTO matiere (nom, duree) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
			

			ps.setString(1, obj.getNom());
			ps.setInt(2, obj.getDuree());
			
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
	public void update(Matiere obj) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("UPDATE matiere SET nom = ?, duree = ? WHERE id = ?");
						
			ps.setString(1, obj.getNom());
			ps.setInt(2, obj.getDuree());
			ps.setLong(4, obj.getId());
			
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
	public void delete(Matiere obj) {
		deleteById(obj.getId());
	}
	
	@Override
	public void deleteById(Long id) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("DELETE FROM matiere WHERE id= ?");
			
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
