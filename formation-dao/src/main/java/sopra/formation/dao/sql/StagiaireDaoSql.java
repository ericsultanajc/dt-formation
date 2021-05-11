package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.NiveauEtude;
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
			ps = conn.prepareStatement("SELECT id, civilite, nom, prenom, email, dtNaissance, niveauEtude, rue, complement, codePostal, ville FROM stagiaire");
			rs = ps.executeQuery();
			
			


			while (rs.next()) {
				Long id = rs.getLong("id");
				Civilite civilite = Civilite.valueOf(rs.getString("civilite")) ;
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				Date dtNaissance = rs.getTimestamp("dtNaissance");
				
				NiveauEtude niveauEtude = NiveauEtude.valueOf(rs.getString("niveauEtude")) ;

				Stagiaire stagiaire = new Stagiaire(id, email);
				stagiaire.setCivilite(civilite);
				stagiaire.setNom(nom);
				stagiaire.setPrenom(prenom);
				stagiaire.setDtNaissance(dtNaissance);
				stagiaire.setNiveauEtude(niveauEtude);
				
				String rue = rs.getString("rue");
				String complement = rs.getString("complement");
				String codePostal = rs.getString("codePostal");
				String ville = rs.getString("ville");
				
				Adresse adresse = new Adresse(rue, complement, codePostal, ville);

				stagiaire.setAdresse(adresse);

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
			ps = conn.prepareStatement("SELECT civilite, nom, prenom, email, dtNaissance, niveauEtude, rue, complement, codePostal, ville FROM stagiaire WHERE id = ?");
			
			ps.setLong(1, id);
			
			rs = ps.executeQuery();

			if (rs.next()) {
				Civilite civilite = Civilite.valueOf(rs.getString("civilite")) ;
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				Date dtNaissance = rs.getTimestamp("dtNaissance");
				NiveauEtude niveauEtude = NiveauEtude.valueOf(rs.getString("niveauEtude")) ;

				stagiaire = new Stagiaire(id, email);
				stagiaire.setCivilite(civilite);
				stagiaire.setNom(nom);
				stagiaire.setPrenom(prenom);
				stagiaire.setDtNaissance(dtNaissance);
				stagiaire.setNiveauEtude(niveauEtude);
				
				String rue = rs.getString("rue");
				String complement = rs.getString("complement");
				String codePostal = rs.getString("codePostal");
				String ville = rs.getString("ville");
				
				Adresse adresse = new Adresse(rue, complement, codePostal, ville);

				stagiaire.setAdresse(adresse);
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
			ps = conn.prepareStatement("INSERT INTO stagiaire (civilite, nom, prenom, email, dtNaissance, niveauEtude, rue, complement, codePostal, ville) VALUES (?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
						
			ps.setString(1, obj.getCivilite().toString());
			ps.setString(2, obj.getNom());
			ps.setString(3, obj.getPrenom());
			ps.setString(4, obj.getEmail());
			ps.setDate(5, new java.sql.Date(obj.getDtNaissance().getTime()));
			ps.setString(6, obj.getNiveauEtude().toString());
			
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
			ps = conn.prepareStatement("UPDATE stagiaire SET comportementale = ?, technique = ?, commentaires = ? WHERE id = ?");
						
			ps.setInt(1, obj.getComportemental());
			ps.setInt(2, obj.getTechnique());
			ps.setString(3, obj.getCommentaires());
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
	public void delete(Stagiaire obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("DELETE FROM evaluation WHERE id= ?");
			
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
