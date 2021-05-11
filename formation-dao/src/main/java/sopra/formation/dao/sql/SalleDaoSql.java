package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.ISalleDao;
import sopra.formation.model.Adresse;
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
			ps = conn.prepareStatement(
					"SELECT id, nom, capacite, video_projecteur, rue, complement, code_postal, ville FROM salle");
			rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String nom = rs.getString("nom");
				Integer capacite = rs.getInt("capacite");
				Boolean videoProjecteur = rs.getString("video_projecteur").contentEquals("O") ? true : false;
				String rue = rs.getString("rue");
				String complement = rs.getString("complement");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");

				Salle salle = new Salle(id, nom, capacite, videoProjecteur);
				salle.setAdr(new Adresse(rue, complement, codePostal, ville));

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
			ps = conn.prepareStatement(
					"SELECT nom, capacite, video_projecteur, rue, complement, code_postal, ville FROM salle WHERE id = ?");

			ps.setLong(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				String nom = rs.getString("nom");
				Integer capacite = rs.getInt("capacite");
				Boolean videoProjecteur = rs.getString("video_projecteur").contentEquals("O") ? true : false;
				String rue = rs.getString("rue");
				String complement = rs.getString("complement");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");

				salle = new Salle(id, nom, capacite, videoProjecteur);
				salle.setAdr(new Adresse(rue, complement, codePostal, ville));
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
			ps = conn.prepareStatement(
					"INSERT INTO salle (nom, capacite, video_projecteur, rue, complement, code_postal, ville) VALUES (?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, obj.getNom());
			ps.setInt(2, obj.getCapacite());
			ps.setString(3, obj.getVideoProjecteur() ? "O" : "N");
			
			if(obj.getAdr() != null) {
				ps.setString(4, obj.getAdr().getRue());
				ps.setString(5, obj.getAdr().getComplement());
				ps.setString(6, obj.getAdr().getCodePostal());
				ps.setString(7, obj.getAdr().getVille());
			} else {
				ps.setNull(4, Types.VARCHAR);
				ps.setNull(5, Types.VARCHAR);
				ps.setNull(6, Types.VARCHAR);
				ps.setNull(7, Types.VARCHAR);
			}

			int rows = ps.executeUpdate();

			if (rows > 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
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
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement(
					"UPDATE salle SET nom = ?, capacite = ?, video_projecteur = ?, rue = ?, complement = ?, code_postal = ?, ville = ? WHERE id = ?");

			ps.setString(1, obj.getNom());
			ps.setInt(2, obj.getCapacite());
			ps.setString(3, obj.getVideoProjecteur() ? "O" : "N");
			
			if(obj.getAdr() != null) {
				ps.setString(4, obj.getAdr().getRue());
				ps.setString(5, obj.getAdr().getComplement());
				ps.setString(6, obj.getAdr().getCodePostal());
				ps.setString(7, obj.getAdr().getVille());
			} else {
				ps.setNull(4, Types.VARCHAR);
				ps.setNull(5, Types.VARCHAR);
				ps.setNull(6, Types.VARCHAR);
				ps.setNull(7, Types.VARCHAR);
			}
			
			ps.setLong(8, obj.getId());

			int rows = ps.executeUpdate();

			if (rows != 1) {
				//TODO exception
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
