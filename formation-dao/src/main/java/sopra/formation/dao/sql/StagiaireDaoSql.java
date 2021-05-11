package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;

public class StagiaireDaoSql implements IStagiaireDao {

	@Override
	public List<Stagiaire> findAll() {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT id, disc, civilite, nom, prenom, email, telephone, rue, complement, code_postal, ville, dt_naissance, niveau_etude FROM personne");
			rs = ps.executeQuery();

			while (rs.next()) {
				String disc = rs.getString("disc");
				if(disc.equals("STAGIAIRE")) {
					Long id = rs.getLong("id");
					String civilite = rs.getString("civilite");
					String nom = rs.getString("nom");
					String prenom = rs.getString("prenom");
					String email = rs.getString("email");
					String telephone = rs.getString("telephone");
					String rue = rs.getString("rue");
					String complement = rs.getString("complement");
					String code_postal = rs.getString("code_postal");
					String ville = rs.getString("ville");
					java.util.Date dt_naissance = rs.getTimestamp("dt_naissance");
					String niveau_etude = rs.getString("niveau_etude");

					Adresse adr = new Adresse(rue, complement, code_postal, ville);
					Stagiaire pers = new Stagiaire(id, email);
					
					pers.setCivilite(Civilite.valueOf(civilite));
					pers.setNom(nom);
					pers.setPrenom(prenom);
					pers.setTelephone(telephone);
					pers.setDtNaissance(dt_naissance);
					pers.setNiveauEtude(NiveauEtude.valueOf(niveau_etude));
					pers.setAdresse(adr);
					stagiaires.add(pers);
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
			ps = conn.prepareStatement("SELECT disc, civilite, nom, prenom, email, telephone, rue, complement, code_postal, ville, dt_naissance, niveau_etude FROM personne WHERE id = ?");
			
			ps.setLong(1, id);
			
			rs = ps.executeQuery();

			if (rs.next()) {
				String civilite = rs.getString("civilite");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String complement = rs.getString("complement");
				String code_postal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				java.util.Date dt_naissance = rs.getTimestamp("dt_naissance");
				String niveau_etude = rs.getString("niveau_etude");

				stagiaire = new Stagiaire(id, email);
				Adresse adr = new Adresse(rue, complement, code_postal, ville);
				
				stagiaire.setCivilite(Civilite.valueOf(civilite));
				stagiaire.setNom(nom);
				stagiaire.setPrenom(prenom);
				stagiaire.setTelephone(telephone);
				stagiaire.setDtNaissance(dt_naissance);
				stagiaire.setNiveauEtude(NiveauEtude.valueOf(niveau_etude));
				stagiaire.setAdresse(adr);
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
			ps = conn.prepareStatement("INSERT INTO personne (disc, civilite, nom, prenom, email, telephone, rue, complement, code_postal, ville, dt_naissance, niveau_etude) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, "STAGIAIRE");
			ps.setString(2, obj.getCivilite().toString());
			ps.setString(3, obj.getNom());
			ps.setString(4, obj.getPrenom());
			ps.setString(5, obj.getEmail());
			ps.setString(6, obj.getTelephone());
			ps.setString(7, obj.getAdresse().getRue());
			ps.setString(8, obj.getAdresse().getComplement());
			ps.setString(9, obj.getAdresse().getCodePostal());
			ps.setString(10, obj.getAdresse().getVille());
			
			java.util.Date dt = new java.util.Date(obj.getDtNaissance().getTime());
			
			ps.setDate(11, (Date) dt);
			ps.setString(12, obj.getCivilite().toString());
			
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
			ps = conn.prepareStatement("UPDATE personne SET disc=?, civilite=?, nom=?, prenom=?, email=?, telephone=?, rue=?, complement=?, code_postal=?, ville=?, dt_naissance=?, niveau_etude=? WHERE id = ?");
						
			ps.setString(1, "STAGIAIRE");
			ps.setString(2, obj.getCivilite().toString());
			ps.setString(3, obj.getNom());
			ps.setString(4, obj.getPrenom());
			ps.setString(5, obj.getEmail());
			ps.setString(6, obj.getTelephone());
			ps.setString(7, obj.getAdresse().getRue());
			ps.setString(8, obj.getAdresse().getComplement());
			ps.setString(9, obj.getAdresse().getCodePostal());
			ps.setString(10, obj.getAdresse().getVille());
			//ps.setDate(11, obj.getDtNaissance());
			ps.setString(12, obj.getCivilite().toString());
			ps.setLong(13, obj.getId());
			
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
			ps = conn.prepareStatement("DELETE FROM personne WHERE id= ?");
			
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
