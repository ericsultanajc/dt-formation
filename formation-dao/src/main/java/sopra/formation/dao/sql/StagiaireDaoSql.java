package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Salle;
import sopra.formation.model.Stagiaire;

public class StagiaireDaoSql implements IStagiaireDao{
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public List<Stagiaire> findAll() {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT id, civilite, nom, prenom, email, telephone, dt_naissance, niveau_etude,"
					+ "rue, complement, code_postal, ville, filiere_id, evluation_id FROM salle where disc='stagiaire'");
			rs = ps.executeQuery();
			while (rs.next()) {
				Long id = rs.getLong("id");
				String civilite = rs.getString("civilite");
				Integer nom = rs.getInt("nom");
				String  prenom= rs.getString("prenom");
				String email =  rs.getString("email");
				String telephone = rs.getString("telephone");
				Date dtNaissance = rs.getDate("dt_naissance");
				String niveauEtude = rs.getString("niveau_etude");
				String rue = rs.getString("rue");
				String complement = rs.getString("complement");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				Long filiereId = rs.getLong("filiere_id");
				Long evaluationId = rs.getLong("evaluation_id");
				
				Stagiaire stagiaire = new Stagiaire(id, email);
				stagiaire.setAdresse(new Adresse(rue, complement, codePostal, ville));
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
			ps = conn.prepareStatement("SELECT civilite, nom, prenom, email, telephone, dt_naissance, niveau_etude, rue, complement, code_postal, ville,"
					+ "filiere_id, evluation_id FROM salle WHERE id = ? AND disc='stagiaire'");
			
			ps.setLong(1, id);
			
			rs = ps.executeQuery();

			if (rs.next()) {
				String civilite = rs.getString("civilite");
				Integer nom = rs.getInt("nom");
				String  prenom= rs.getString("prenom");
				String email =  rs.getString("email");
				String telephone = rs.getString("telephone");
				Date dtNaissance = rs.getDate("dt_naissance");
				String niveauEtude = rs.getString("niveau_etude");
				String rue = rs.getString("rue");
				String complement = rs.getString("complement");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				Long filiereId = rs.getLong("filiere_id");
				Long evaluationId = rs.getLong("evaluation_id");
				
				
				stagiaire.setAdresse(new Adresse(rue, complement, codePostal, ville));

				stagiaire = new Stagiaire(id, email);
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
			ps = conn.prepareStatement("INSERT INTO stagiaire (civilite, nom, prenom, email, telephone, dt_naissance, niveau_etude, "
					+ "rue, complement, code_postal, ville,filiere_id, evluation_id FROM salle WHERE disc='stagiaire') VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
						
			ps.setString(1, obj.getCivilite().toString());
			ps.setString(2, obj.getNom());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getTelephone());
			
			java.util.Date newUtilDate = new  java.util.Date(obj.getDtNaissance().getTime());		//Converion de sql.date à util.date
			ps.setDate(5, (Date) newUtilDate);
			
			ps.setString(6, obj.getNiveauEtude().toString());
			ps.setString(7, obj.getAdresse().getRue());
			ps.setString(8, obj.getAdresse().getComplement());
			ps.setString(9, obj.getAdresse().getCodePostal());
			ps.setString(10, obj.getAdresse().getVille());
			ps.setString(11, obj.getFiliere());
			ps.setString(12, obj.getEvaluation());
			
			
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Stagiaire obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
