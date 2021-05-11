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
import sopra.formation.model.Matiere;

public class MatiereDaoSql implements IMatiereDao {

	@Override
	public List<Matiere> findAll() {
		List<Matiere> matieres = new ArrayList<Matiere>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement("SELECT id, nom, duree FROM matiere");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String nom = resultSet.getString("nom");
				Integer duree = resultSet.getInt("duree");

				Matiere matiere = new Matiere(id, nom, duree);

				matieres.add(matiere);
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

		return matieres;
	}

	@Override
	public Matiere findById(Long id) {
		Matiere matiere = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement("SELECT nom, duree FROM matiere WHERE id = ?");

			preparedStatement.setLong(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String nom = resultSet.getString("nom");
				Integer duree = resultSet.getInt("duree");

				matiere = new Matiere(id, nom, duree);
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

		return matiere;
	}

	@Override
	public void create(Matiere obj) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement("INSERT INTO matiere (nom, duree) VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setInt(2, obj.getDuree());

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
	public void update(Matiere obj) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement("UPDATE matiere SET nom = ?, duree = ? WHERE id = ?");

			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setInt(2, obj.getDuree());
			preparedStatement.setLong(3, obj.getId());

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

	public void delete(Matiere obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement("DELETE matiere WHERE id = ?");

			preparedStatement.setLong(1, id);

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
	public List<Matiere> findAllByFormateurById(Long idFormateur) {
		List<Matiere> matieres = new ArrayList<Matiere>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement("SELECT m.id, m.nom, m.duree FROM matiere m JOIN competence c ON m.id = c.matiere_id WHERE c.formateur_id = ?");

			preparedStatement.setLong(1, idFormateur);
			
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String nom = resultSet.getString("nom");
				Integer duree = resultSet.getInt("duree");

				Matiere matiere = new Matiere(id, nom, duree);

				matieres.add(matiere);
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

		return matieres;
	}

}
