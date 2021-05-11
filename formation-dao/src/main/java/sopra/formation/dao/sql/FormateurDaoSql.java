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
import sopra.formation.dao.IFormateurDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.Filiere;
import sopra.formation.model.Formateur;
import sopra.formation.model.Matiere;


public class FormateurDaoSql implements IFormateurDao {

	@Override
	public List<Formateur> findAll() {
		List<Formateur> formateurs = new ArrayList<Formateur>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"SELECT id, civilite, nom, prenom, email, telephone, referent, experience, rue, complement, code_postal, ville FROM personne WHERE disc = ?");

			preparedStatement.setString(1, "Formateur");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				Civilite civilite = Civilite.valueOf(resultSet.getString("civilite"));
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				String email = resultSet.getString("email");
				String telephone = resultSet.getString("telephone");
				Boolean referent = resultSet.getString("referent").contentEquals("O") ? true : false;
				Integer experience = resultSet.getInt("experience");
				String rue = resultSet.getString("rue");
				String complement = resultSet.getString("complement");
				String codePostal = resultSet.getString("code_postal");
				String ville = resultSet.getString("ville");
				

				Formateur formateur = new Formateur(id, civilite, nom, prenom, email, telephone, referent, experience);

				Adresse adresse = new Adresse(rue, complement, codePostal, ville);
				formateur.setAdresse(adresse);
				
				List<Matiere> competences = Application.getInstance().getMatiereDao().findAllByFormateurById(id);
				
				formateur.setCompetences(competences);
				
				formateurs.add(formateur);
				
				
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

		return formateurs;
	}

	@Override
	public Formateur findById(Long id) {
		Formateur formateur = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"SELECT civilite, nom, prenom, email, telephone, referent, experience, rue, complement, code_postal, ville FROM personne WHERE disc = ? AND id = ?");

			preparedStatement.setString(1, "Formateur");
			preparedStatement.setLong(2, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Civilite civilite = Civilite.valueOf(resultSet.getString("civilite"));
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				String email = resultSet.getString("email");
				String telephone = resultSet.getString("telephone");
				Boolean referent = resultSet.getString("referent").contentEquals("O") ? true : false;
				Integer experience = resultSet.getInt("experience");
				String rue = resultSet.getString("rue");
				String complement = resultSet.getString("complement");
				String codePostal = resultSet.getString("code_postal");
				String ville = resultSet.getString("ville");
				

				formateur = new Formateur(id, civilite, nom, prenom, email, telephone, referent, experience);

				Adresse adresse = new Adresse(rue, complement, codePostal, ville);
				formateur.setAdresse(adresse);
				
							
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

		return formateur;
	}

	@Override
	public void create(Formateur obj) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementCompetences = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"INSERT INTO personne (disc, civilite, nom, prenom, email, telephone, referent, experience, rue, complement, code_postal, ville, matiere_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, "Formateur");

			if (obj.getCivilite() != null) {
				preparedStatement.setString(2, obj.getCivilite().toString());
			} else {
				preparedStatement.setNull(2, Types.VARCHAR);
			}

			preparedStatement.setString(3, obj.getNom());
			preparedStatement.setString(4, obj.getPrenom());
			preparedStatement.setString(5, obj.getEmail());
			preparedStatement.setString(6, obj.getTelephone());
			preparedStatement.setString(7, obj.getReferent() ? "O" : "N");
			if (obj.getExperience() != null) {
				preparedStatement.setInt(8, obj.getExperience());
			} else {
				preparedStatement.setNull(8, Types.INTEGER);
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
			
			

			int rows = preparedStatement.executeUpdate();

			if (rows == 1) {
				resultSet = preparedStatement.getGeneratedKeys();

				if (resultSet.next()) {
					Long id = resultSet.getLong(1);

					obj.setId(id);
				}

				preparedStatementCompetences = connection
						.prepareStatement("INSERT INTO competence (formateur_id, matiere_id) VALUES (?,?)");
				
				for (Matiere matiere : obj.getCompetences()) {
					if (matiere.getId() != null) {
						preparedStatementCompetences.setLong(1, obj.getId());
						preparedStatementCompetences.setLong(2, matiere.getId());

						preparedStatementCompetences.executeUpdate();
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatementCompetences.close();
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Formateur obj) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementCompetences = null;
		PreparedStatement preparedStatementCompetencesDelete = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"UPDATE personne SET civilite = ?, nom = ?, prenom = ?, email = ?, telephone = ?, referent = ?, experience = ?, rue = ?, complement = ?, code_postal = ?, ville = ? WHERE disc = ? AND id = ?");

			if (obj.getCivilite() != null) {
				preparedStatement.setString(1, obj.getCivilite().toString());
			} else {
				preparedStatement.setNull(1, Types.VARCHAR);
			}

			preparedStatement.setString(2, obj.getNom());
			preparedStatement.setString(3, obj.getPrenom());
			preparedStatement.setString(4, obj.getEmail());
			preparedStatement.setString(5, obj.getTelephone());
			preparedStatement.setString(6, obj.getReferent() ? "O" : "N");
			preparedStatement.setInt(7, obj.getExperience());

			Date dtNaissance = new Date();

			preparedStatement.setDate(8, new java.sql.Date(dtNaissance.getTime()));

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

			preparedStatement.setString(12, "Formateur");
			preparedStatement.setLong(13, obj.getId());

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {
				preparedStatementCompetencesDelete = connection
						.prepareStatement("DELETE FROM competence WHERE formateur_id = ?");

				preparedStatementCompetencesDelete.setLong(1, obj.getId());

				preparedStatementCompetencesDelete.executeUpdate();

				preparedStatementCompetences = connection
						.prepareStatement("INSERT INTO competence (formateur_id, matiere_id) VALUES (?,?)");

				
				for (Matiere matiere : obj.getCompetences()) {
					if (matiere.getId() != null) {
						preparedStatementCompetences.setLong(1, obj.getId());
						preparedStatementCompetences.setLong(2, matiere.getId());

						preparedStatementCompetences.executeUpdate();
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatementCompetencesDelete.close();
				preparedStatementCompetences.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Formateur obj) {
		deleteById(obj.getId());

	}

	@Override
	public void deleteById(Long id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement("DELETE personne WHERE disc = ? AND id = ?");

			preparedStatement.setString(1, "Formateur");
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
