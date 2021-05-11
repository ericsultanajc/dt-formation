package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Filiere;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;

public class StagiaireDaoSql implements IStagiaireDao {

	@Override
	public List<Stagiaire> findAll() {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"SELECT id, civilite, nom, prenom, email, telephone, dt_naissance, niveau_etude, rue, complement, code_postal, ville, evaluation_id, filiere_id FROM personne WHERE disc = ?");

			preparedStatement.setString(1, "Stagiaire");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				Civilite civilite = Civilite.valueOf(resultSet.getString("civilite"));
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				String email = resultSet.getString("email");
				String telephone = resultSet.getString("telephone");
				Date dtNaissance = resultSet.getDate("dt_naissance");
				NiveauEtude niveauEtude = NiveauEtude.valueOf(resultSet.getString("niveau_etude"));
				String rue = resultSet.getString("rue");
				String complement = resultSet.getString("complement");
				String codePostal = resultSet.getString("code_postal");
				String ville = resultSet.getString("ville");
				Long idEvaluation = resultSet.getLong("evaluation_id");
				Long idFiliere = resultSet.getLong("filiere_id");

				Stagiaire stagiaire = new Stagiaire(id, civilite, nom, prenom, email, telephone, dtNaissance,
						niveauEtude);

				Adresse adresse = new Adresse(rue, complement, codePostal, ville);
				stagiaire.setAdresse(adresse);

				if (idEvaluation != null) {
					Evaluation evaluation = Application.getInstance().getEvaluationDao().findById(idEvaluation);

					stagiaire.setEvaluation(evaluation);
				}

				if (idFiliere != null) {
					Filiere filiere = Application.getInstance().getFiliereDao().findById(idFiliere);

					stagiaire.setFiliere(filiere);
				}

				stagiaires.add(stagiaire);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		}

		return stagiaires;
	}

	@Override
	public Stagiaire findById(Long id) {
		Stagiaire stagiaire = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"SELECT civilite, nom, prenom, email, telephone, dt_naissance, niveau_etude, rue, complement, code_postal, ville, evaluation_id, filiere_id FROM personne WHERE disc = ? AND id = ?");

			preparedStatement.setString(1, "Stagiaire");
			preparedStatement.setLong(2, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Civilite civilite = Civilite.valueOf(resultSet.getString("civilite"));
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				String email = resultSet.getString("email");
				String telephone = resultSet.getString("telephone");
				Date dtNaissance = resultSet.getDate("dt_naissance");
				NiveauEtude niveauEtude = NiveauEtude.valueOf(resultSet.getString("niveau_etude"));
				String rue = resultSet.getString("rue");
				String complement = resultSet.getString("complement");
				String codePostal = resultSet.getString("code_postal");
				String ville = resultSet.getString("ville");
				Long idEvaluation = resultSet.getLong("evaluation_id");
				Long idFiliere = resultSet.getLong("filiere_id");

				stagiaire = new Stagiaire(id, civilite, nom, prenom, email, telephone, dtNaissance, niveauEtude);

				Adresse adresse = new Adresse(rue, complement, codePostal, ville);
				stagiaire.setAdresse(adresse);

				if (idEvaluation != null) {
					Evaluation evaluation = Application.getInstance().getEvaluationDao().findById(idEvaluation);

					stagiaire.setEvaluation(evaluation);
				}

				if (idFiliere != null) {
					Filiere filiere = Application.getInstance().getFiliereDao().findById(idFiliere);

					stagiaire.setFiliere(filiere);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		}

		return stagiaire;
	}

	@Override
	public void create(Stagiaire obj) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"INSERT INTO personne (disc, civilite, nom, prenom, email, telephone, dt_naissance, niveau_etude, rue, complement, code_postal, ville, evaluation_id, filiere_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, "Stagiaire");

			if (obj.getCivilite() != null) {
				preparedStatement.setString(2, obj.getCivilite().toString());
			} else {
				preparedStatement.setNull(2, Types.VARCHAR);
			}

			preparedStatement.setString(3, obj.getNom());
			preparedStatement.setString(4, obj.getPrenom());
			preparedStatement.setString(5, obj.getEmail());
			preparedStatement.setString(6, obj.getTelephone());
			if (obj.getDtNaissance() != null) {
				preparedStatement.setDate(7, new java.sql.Date(obj.getDtNaissance().getTime()));
//				preparedStatement.setDate(7, java.sql.Date.valueOf(sdf.format(obj.getDtNaissance()))); via String => yyyy-MM-dd
			} else {
				preparedStatement.setNull(7, Types.DATE);
			}
			if (obj.getNiveauEtude() != null) {
				preparedStatement.setString(8, obj.getNiveauEtude().toString());
			} else {
				preparedStatement.setNull(8, Types.VARCHAR);
			}

			if (obj.getAdresse() != null) {
				preparedStatement.setString(9, obj.getAdresse().getRue());
				preparedStatement.setString(10, obj.getAdresse().getComplement());
				preparedStatement.setString(11, obj.getAdresse().getCodePostal());
				preparedStatement.setString(12, obj.getAdresse().getVille());
			} else {
				preparedStatement.setNull(9, Types.VARCHAR);
				preparedStatement.setNull(10, Types.VARCHAR);
				preparedStatement.setNull(11, Types.VARCHAR);
				preparedStatement.setNull(12, Types.VARCHAR);
			}

			if (obj.getEvaluation() != null && obj.getEvaluation().getId() != null) {
				preparedStatement.setLong(13, obj.getEvaluation().getId());
			} else {
				preparedStatement.setNull(13, Types.INTEGER);
			}
			if (obj.getFiliere() != null && obj.getFiliere().getId() != null) {
				preparedStatement.setLong(14, obj.getFiliere().getId());
			} else {

			preparedStatement.setNull(14, Types.INTEGER);
			}

			int rows = preparedStatement.executeUpdate();

			if (rows == 1) {
				resultSet = preparedStatement.getGeneratedKeys();

				if (resultSet.next()) {
					Long id = resultSet.getLong(1);

					obj.setId(id);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Stagiaire obj) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"UPDATE personne SET civilite = ?, nom = ?, prenom = ?, email = ?, telephone = ?, dt_naissance = ?, niveau_etude = ?, rue = ?, complement = ?, code_postal = ?, ville = ?, evaluation_id = ?, filiere_id = ? WHERE disc = ? AND id = ?");

			if (obj.getCivilite() != null) {
				preparedStatement.setString(1, obj.getCivilite().toString());
			} else {
				preparedStatement.setNull(1, Types.VARCHAR);
			}

			preparedStatement.setString(2, obj.getNom());
			preparedStatement.setString(3, obj.getPrenom());
			preparedStatement.setString(4, obj.getEmail());
			preparedStatement.setString(5, obj.getTelephone());
			if (obj.getDtNaissance() != null) {
				preparedStatement.setDate(6, new java.sql.Date(obj.getDtNaissance().getTime()));
			} else {
				preparedStatement.setNull(6, Types.DATE);
			}
			if (obj.getNiveauEtude() != null) {
				preparedStatement.setString(7, obj.getNiveauEtude().toString());
			} else {
				preparedStatement.setNull(7, Types.VARCHAR);
			}

			if (obj.getAdresse() != null) {
				preparedStatement.setString(8, obj.getAdresse().getRue());
				preparedStatement.setString(9, obj.getAdresse().getComplement());
				preparedStatement.setString(10, obj.getAdresse().getCodePostal());
				preparedStatement.setString(11, obj.getAdresse().getVille());
			} else {
				preparedStatement.setNull(8, Types.VARCHAR);
				preparedStatement.setNull(9, Types.VARCHAR);
				preparedStatement.setNull(10, Types.VARCHAR);
				preparedStatement.setNull(11, Types.VARCHAR);
			}

			if (obj.getEvaluation() != null && obj.getEvaluation().getId() != null) {
				preparedStatement.setLong(12, obj.getEvaluation().getId());
			} else {
				preparedStatement.setNull(12, Types.INTEGER);
			}
			
			if (obj.getFiliere() != null && obj.getFiliere().getId() != null) {
				preparedStatement.setLong(13, obj.getFiliere().getId());
			} else {


			preparedStatement.setNull(13, Types.INTEGER);
			}

			preparedStatement.setString(14, "Stagiaire");
			preparedStatement.setLong(15, obj.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException | NullPointerException e) {
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
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement("DELETE personne WHERE disc = ? AND id = ?");

			preparedStatement.setString(1, "Stagiaire");
			preparedStatement.setLong(2, id);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		}
	}

}
