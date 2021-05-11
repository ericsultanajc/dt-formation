package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Personne;
import sopra.formation.model.Stagiaire;

public class StagiaireDaoSql implements IStagiaireDao {
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public List<Stagiaire> findAll() {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT id, civilite, nom, prenom, email, telephone, dt_naissance, "
					+ "niveau_etude, rue, complement, code_postal, ville"
					+ "FROM personne WHERE disc LIKE 'stagiaire%'");
			
			while(rs.next()) {
				Long id = rs.getLong("id");
				Civilite civilite = Civilite.valueOf(rs.getString("civilite"));
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				Date dtNaissance = null;
				try {
					dtNaissance = (Date) sdf.parse(rs.getString("dt_naissance"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				NiveauEtude niveauEtude = NiveauEtude.valueOf(rs.getString("nibeau_etude"));
				String rue = rs.getString("rue");
				String complement = rs.getString("complement");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				
				Stagiaire stagiaire = new Stagiaire(id, civilite, nom, prenom, email, telephone, dtNaissance, niveauEtude);
				stagiaire.setCivilite(civilite);
				stagiaire.setNom(nom);
				stagiaire.setPrenom(prenom);
				stagiaire.setDtNaissance(dtNaissance);
				stagiaire.setNiveauEtude(niveauEtude);
				
				Adresse adresse = new Adresse(rue, complement, codePostal, ville);

				stagiaire.setAdresse(adresse);
				
				stagiaires.add(stagiaire);
			}
			
		} catch(SQLException e) {
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
			ps = conn.prepareStatement("SELECT civilite, nom, prenom, email, telephone, dt_naissance, "
					+ "niveau_etude, rue, complement, code_postal, ville"
					+ "FROM personne WHERE disc LIKE 'stagiaire%' AND id = ?");
			
			ps.setLong(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Civilite civilite = Civilite.valueOf(rs.getString("civilite"));
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				Date dtNaissance = null;
				try {
					dtNaissance = (Date) sdf.parse(rs.getString("dt_naissance"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				NiveauEtude niveauEtude = NiveauEtude.valueOf(rs.getString("nibeau_etude"));
				String rue = rs.getString("rue");
				String complement = rs.getString("complement");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				
				stagiaire.setCivilite(civilite);
				stagiaire.setNom(nom);
				stagiaire.setPrenom(prenom);
				stagiaire.setDtNaissance(dtNaissance);
				stagiaire.setNiveauEtude(niveauEtude);
				
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
			ps = conn.prepareStatement("INSERT INTO personne"
					+ "(disc, civilite, nom, prenom, email, telephone, dt_naissance, "
					+ "niveau_etude, rue, complement, code_postal, ville)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, "stagiaire");
			ps.setString(2, obj.getCivilite().toString());
			ps.setString(3, obj.getNom());
			ps.setString(4, obj.getPrenom());
			ps.setString(5, obj.getEmail());
			ps.setString(6, obj.getTelephone());
			
			System.out.println(sdf2.format(obj.getDtNaissance()));
			
			ps.setDate(7, java.sql.Date.valueOf(sdf2.format(obj.getDtNaissance())));
			ps.setString(8, obj.getNiveauEtude().toString());
			
			if(obj.getAdresse() != null) {
				ps.setString(9,obj.getAdresse().getRue());
				ps.setString(10,obj.getAdresse().getComplement());
				ps.setString(11,obj.getAdresse().getCodePostal());
				ps.setString(12,obj.getAdresse().getVille());
			}
			else {
				ps.setNull(9, Types.VARCHAR);
				ps.setNull(10, Types.VARCHAR);
				ps.setNull(11, Types.VARCHAR);
				ps.setNull(12, Types.VARCHAR);
			}
			
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
			ps = conn.prepareStatement("UPDATE personne"
					+ "(disc = ?, civilite = ?, nom = ?, prenom = ?, email = ?, telephone = ?, dt_naisassance = ?, "
					+ "niveau_etude = ?, rue = ?, complement = ?, code_postal = ?, ville = ?)"
					+ "WHERE id = ?");
			
			ps.setString(1, "stagiaire");
			ps.setString(2, obj.getCivilite().toString());
			ps.setString(3, obj.getNom());
			ps.setString(4, obj.getPrenom());
			
			System.out.println(obj.getEmail());
			
			
			ps.setString(5, obj.getEmail());
			ps.setString(6, obj.getTelephone());
			ps.setDate(7, java.sql.Date.valueOf(sdf2.format(obj.getDtNaissance())));
			ps.setString(8, obj.getNiveauEtude().toString());
			
			if(obj.getAdresse() != null) {
				ps.setString(9,obj.getAdresse().getRue());
				ps.setString(10,obj.getAdresse().getComplement());
				ps.setString(11,obj.getAdresse().getCodePostal());
				ps.setString(12,obj.getAdresse().getVille());
			}
			else {
				ps.setNull(9, Types.VARCHAR);
				ps.setNull(10, Types.VARCHAR);
				ps.setNull(11, Types.VARCHAR);
				ps.setNull(12, Types.VARCHAR);
			}
			
			System.out.println(obj.getId());
			
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
