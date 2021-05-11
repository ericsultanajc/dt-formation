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
import sopra.formation.dao.IFiliereDao;
import sopra.formation.dao.IFormateurDao;
import sopra.formation.model.Dispositif;
import sopra.formation.model.Filiere;
import sopra.formation.model.Formateur;

public class FiliereDaoSql implements IFiliereDao {

	@Override
	public List<Filiere> findAll() {
		List<Filiere> filieres = new ArrayList<Filiere>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"SELECT id, intitule, promotion, dt_debut, duree, dispositif, referent_id FROM filiere");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String intitule = resultSet.getString("intitule");
				String promotion = resultSet.getString("promotion");
				Date dtDebut = resultSet.getDate("dt_debut");
				Integer duree = resultSet.getInt("duree");
				Dispositif dispositif = Dispositif.valueOf(resultSet.getString("dispositif"));
				Long idReferent = resultSet.getLong("referent_id");

				Filiere filiere = new Filiere(id, intitule, promotion, dtDebut, duree, dispositif);

				if (idReferent != null) {
					IFormateurDao formateurDao = Application.getInstance().getFormateurDao();

					Formateur formateur = formateurDao.findById(idReferent);
					filiere.setReferent(formateur);
				}

				filieres.add(filiere);
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

		return filieres;
	}

	@Override
	public Filiere findById(Long id) {
		Filiere filiere = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"SELECT intitule, promotion, dt_debut, duree, dispositif, referent_id FROM filiere WHERE id = ?");

			preparedStatement.setLong(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String intitule = resultSet.getString("intitule");
				String promotion = resultSet.getString("promotion");
				Date dtDebut = resultSet.getDate("dt_debut");
				Integer duree = resultSet.getInt("duree");
				Dispositif dispositif = Dispositif.valueOf(resultSet.getString("dispositif"));
				Long idReferent = resultSet.getLong("referent_id");

				filiere = new Filiere(id, intitule, promotion, dtDebut, duree, dispositif);

				if (idReferent != null) {
					IFormateurDao formateurDao = Application.getInstance().getFormateurDao();

					Formateur formateur = formateurDao.findById(idReferent);
					filiere.setReferent(formateur);
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

		return filiere;
	}

	@Override
	public void create(Filiere obj) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"INSERT INTO filiere (intitule, promotion, dt_debut, duree, dispositif, referent_id) VALUES (?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, obj.getIntitule());
			preparedStatement.setString(2, obj.getPromotion());
			if (obj.getDtDebut() != null) {
				preparedStatement.setDate(3, new java.sql.Date(obj.getDtDebut().getTime()));
			} else {
				preparedStatement.setNull(3, Types.DATE);
			}
			preparedStatement.setInt(4, obj.getDuree());
			if (obj.getDispositif() != null) {
				preparedStatement.setString(5, obj.getDispositif().toString());
			} else {
				preparedStatement.setNull(5, Types.VARCHAR);
			}

			if (obj.getReferent() != null && obj.getReferent().getId() != null) {
				preparedStatement.setLong(6, obj.getReferent().getId());
			} else {
				preparedStatement.setNull(6, Types.INTEGER);
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
	public void update(Filiere obj) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"UPDATE filiere SET intitule = ?, promotion = ?, dt_debut = ?, duree = ?, dispositif = ?, referent_id = ? WHERE id = ?");

			preparedStatement.setString(1, obj.getIntitule());
			preparedStatement.setString(2, obj.getPromotion());
			if (obj.getDtDebut() != null) {
				preparedStatement.setDate(3, new java.sql.Date(obj.getDtDebut().getTime()));
			} else {
				preparedStatement.setNull(3, Types.DATE);
			}
			preparedStatement.setInt(4, obj.getDuree());
			if (obj.getDispositif() != null) {
				preparedStatement.setString(5, obj.getDispositif().toString());
			} else {
				preparedStatement.setNull(5, Types.VARCHAR);
			}

			if (obj.getReferent() != null && obj.getReferent().getId() != null) {
				preparedStatement.setLong(6, obj.getReferent().getId());
			} else {
				preparedStatement.setNull(6, Types.INTEGER);
			}

			preparedStatement.setLong(7, obj.getId());

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
	public void delete(Filiere obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement("DELETE filiere WHERE id = ?");

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

}
