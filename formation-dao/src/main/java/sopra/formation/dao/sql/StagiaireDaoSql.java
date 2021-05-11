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
import sopra.formation.dao.IEvaluationDao;
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
			ps = conn.prepareStatement("SELECT * FROM personne WHERE disc=stagiaire");
			rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				Civilite civilite = Civilite.valueOf(rs.getString("civilite"));
				NiveauEtude niveauEtude = NiveauEtude.valueOf(rs.getString("niveau_etude"));
				Date dtNaissance = rs.getDate("dt_naissance");
				Adresse adresse = new Adresse(rs.getString("rue"), rs.getString("complement"),
						rs.getString("codepostal"), rs.getString("ville"));

				Stagiaire stagiaire = new Stagiaire(id, civilite, nom, prenom, email, telephone, dtNaissance,
						niveauEtude, null, null);
				Long evaluationId = rs.getLong("evaluation_id");
				if (!(rs.wasNull())) {
					IEvaluationDao evaluationDao = Application.getInstance().getEvaluationDao();
					stagiaire.setEvaluation(evaluationDao.findById(evaluationId));
				}
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
		Stagiaire stagiaire = new Stagiaire();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT * FROM personne WHERE disc=stagiaire and id=?");
			ps.setLong(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				Civilite civilite = Civilite.valueOf(rs.getString("civilite"));
				NiveauEtude niveauEtude = NiveauEtude.valueOf(rs.getString("niveau_etude"));
				Date dtNaissance = rs.getDate("dt_naissance");
				Adresse adresse = new Adresse(rs.getString("rue"), rs.getString("complement"),
						rs.getString("codepostal"), rs.getString("ville"));
				Long evaluationId = rs.getLong("evaluation_id");
				if (!(rs.wasNull())) {
					IEvaluationDao evaluationDao = Application.getInstance().getEvaluationDao();
					stagiaire.setEvaluation(evaluationDao.findById(evaluationId));
				}
				stagiaire = new Stagiaire(id, civilite, nom, prenom, email, telephone, dtNaissance, niveauEtude, null,
						null);
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
			ps = conn.prepareStatement(
					"INSERT INTO personne (disc, civilite, nom, prenom,email,telephone, rue,complement,code_postal,ville,dt_naissance,niveau_etude,evaluation_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, "stagiaire");
			ps.setString(2, String.valueOf( obj.getCivilite()));
			ps.setString(3, obj.getNom());
			ps.setString(4, obj.getPrenom());
			ps.setString(5, obj.getEmail());
			ps.setString(6, obj.getTelephone());
			ps.setString(7, obj.getAdresse().getRue());
			ps.setString(8, obj.getAdresse().getComplement());
			ps.setString(9, obj.getAdresse().getCodePostal());
			ps.setString(10,obj.getAdresse().getVille());
			java.sql.Date javaSqlDate = new java.sql.Date(obj.getDtNaissance().getTime());
			ps.setDate(11,javaSqlDate);
			ps.setString(12,String.valueOf(obj.getNiveauEtude()));
			ps.setLong(13, obj.getEvaluation().getId());
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				rs = ps.getGeneratedKeys();
				if(rs.next()) {
					Long id = rs.getLong(1);
					obj.setId(id);
				}
			

			}

		}catch(

	SQLException e)
	{
		e.printStackTrace();
	}finally
	{
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
			ps = conn.prepareStatement(
					"Update personne Set disc = ?, civilite= ?, nom= ?, prenom= ?,email= ?,telephone= ?, rue= ?,complement= ?,codepostal= ?,ville= ?,dt_naissance= ?,niveau_etude= ? WHERE id = ?",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, "stagiaire");
			ps.setString(2, String.valueOf( obj.getCivilite()));
			ps.setString(3, obj.getNom());
			ps.setString(4, obj.getPrenom());
			ps.setString(5, obj.getEmail());
			ps.setString(6, obj.getTelephone());
			ps.setString(7, obj.getAdresse().getRue());
			ps.setString(8, obj.getAdresse().getComplement());
			ps.setString(9, obj.getAdresse().getCodePostal());
			ps.setString(10,obj.getAdresse().getVille());
			java.sql.Date javaSqlDate = new java.sql.Date(obj.getDtNaissance().getTime());
			ps.setDate(11,javaSqlDate);
			ps.setString(12,String.valueOf(obj.getNiveauEtude()));
			ps.setLong(13, obj.getId());
			
			int rows = ps.executeUpdate();
			
			if(rows != 1) {
				// TODO renvoyer une exception
			}

			

		}catch(

	SQLException e)
	{
		e.printStackTrace();
	}finally
	{
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
			ps = conn.prepareStatement(
					"DELETE FROM personne WHERE id = ? and disc = stagiaire",
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setLong(1, id);
			
			int rows = ps.executeUpdate();
			
			if(rows != 1) {
				// TODO renvoyer une exception
			}

			

		}catch(

	SQLException e)
	{
		e.printStackTrace();
	}finally
	{
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
