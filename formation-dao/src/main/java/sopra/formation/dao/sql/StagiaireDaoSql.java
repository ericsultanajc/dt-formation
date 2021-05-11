package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Stagiaire;

public class StagiaireDaoSql implements IStagiaireDao{

	@Override
	public List<Stagiaire> findAll() {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT id, disc, civilite, nom, prenom, email, telephone, dt_naissance, niveau_etude, rue, complement, code_postal, ville, filiere_id, evuation_id FROM stagiaire");
			rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String civilite = rs.getString("civilite");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				Date dt_naissance = rs.getDate("dt_naissance");
				Integer niveau_etude = rs.getInt("niveau_etude");
				String rue = rs.getString("rue");
				String complement = rs.getString("complement");
				String code_postal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				Integer filiere_id = rs.getInt("filiere_id");
				Integer evaluation_id = rs.getInt("evaluation_id");
				
				Stagiaire stagiaire = new Stagiaire(id, civilite, nom, prenom, email, dt_naissance, niveau_etude);
				stagiaire.setAdresse(rue, complement, code_postal, ville);
				stagiaire.setFiliere(filiere_id);
				stagiaire.setEvaluation(evaluation_id);

				stagiaires.add(stagiaire);
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
		
		return stagiaires;
	}

	@Override
	public Stagiaire findById(Long id) {
		Stagiaire stagiaire = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT civilite, nom, prenom, email, telephone FROM stagiaire WHERE id = ?");
			
			ps.setLong(1, id);
			
			rs = ps.executeQuery();

			if (rs.next()) {
				String civilite = rs.getString("civilite");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");

				stagiaire = new Stagiaire(id, civilite, nom, prenom, email, telephone);
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
		
		return stagiaire;
	}

	@Override
	public void create(Stagiaire obj) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("INSERT INTO stagiaire (civilite, nom, prenom, email, telephone, dt_naissance, niveau_etude) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
						
			ps.setInt(1, obj.getCivilite());
			ps.setString(2, obj.getNom());
			ps.setString(3, obj.getPrenom());
			ps.setString(4, obj.getEmail());
			ps.setString(5, obj.getTelephone());
			ps.setDate(6, obj.getDtNaissance());
			ps.setInt(7,obj.getNiveauEtude());
			
			
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
	public void update(Stagiaire obj) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("UPDATE stagiaire SET civilite = ?, nom = ?, prenom = ? WHERE id = ?");
						
			ps.setInt(1, obj.getCivilite());
			ps.setString(2, obj.getNom());
			ps.setString(3, obj.getPrenom());
			
			
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

	@Override
	public void delete(Stagiaire obj) {
		deleteById(obj.getId());
		
	}

	@Override
	public void deleteById(Long id) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("DELETE FROM stagiaire WHERE id= ?");
			
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
