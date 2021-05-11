package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IUEDao;
import sopra.formation.model.Filiere;
import sopra.formation.model.Formateur;
import sopra.formation.model.Matiere;
import sopra.formation.model.Salle;
import sopra.formation.model.UE;

public class UEDaoSql implements IUEDao {

	@Override
	public List<UE> findAll() {
		List<UE> ues = new ArrayList<UE>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"SELECT id, code, duree, ordre, filiere_id, matiere_id, formateur_id, salle_id FROM ue");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				Integer code = resultSet.getInt("code");
				Integer duree = resultSet.getInt("duree");
				Integer ordre = resultSet.getInt("ordre");
				Long idFiliere = resultSet.getLong("filiere_id");
				Long idMatiere = resultSet.getLong("matiere_id");
				Long idFormateur = resultSet.getLong("formateur_id");
				Long idSalle = resultSet.getLong("salle_id");

				UE ue = new UE(id, code, duree, ordre);

				if (idFiliere != null) {
					Filiere filiere = Application.getInstance().getFiliereDao().findById(idFiliere);

					ue.setFiliere(filiere);
				}

				if (idMatiere != null) {
					Matiere matiere = Application.getInstance().getMatiereDao().findById(idMatiere);

					ue.setMatiere(matiere);
				}

				if (idFormateur != null) {
					Formateur formateur = Application.getInstance().getFormateurDao().findById(idFormateur);

					ue.setFormateur(formateur);
				}

				if (idSalle != null) {
					Salle salle = Application.getInstance().getSalleDao().findById(idSalle);

					ue.setSalle(salle);
				}

				ues.add(ue);
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

		return ues;
	}

	@Override
	public UE findById(Long id) {
		UE ue = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"SELECT code, duree, ordre, filiere_id, matiere_id, formateur_id, salle_id FROM ue WHERE id = ?");

			preparedStatement.setLong(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Integer code = resultSet.getInt("code");
				Integer duree = resultSet.getInt("duree");
				Integer ordre = resultSet.getInt("ordre");
				Long idFiliere = resultSet.getLong("filiere_id");
				Long idMatiere = resultSet.getLong("matiere_id");
				Long idFormateur = resultSet.getLong("formateur_id");
				Long idSalle = resultSet.getLong("salle_id");

				ue = new UE(id, code, duree, ordre);

				if (idFiliere != null) {
					Filiere filiere = Application.getInstance().getFiliereDao().findById(idFiliere);

					ue.setFiliere(filiere);
				}

				if (idMatiere != null) {
					Matiere matiere = Application.getInstance().getMatiereDao().findById(idMatiere);

					ue.setMatiere(matiere);
				}

				if (idFormateur != null) {
					Formateur formateur = Application.getInstance().getFormateurDao().findById(idFormateur);

					ue.setFormateur(formateur);
				}

				if (idSalle != null) {
					Salle salle = Application.getInstance().getSalleDao().findById(idSalle);

					ue.setSalle(salle);
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

		return ue;
	}

	@Override
	public void create(UE obj) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"INSERT INTO ue (code, duree, ordre, filiere_id, matiere_id, formateur_id, salle_id) VALUES (global_seq.nextval,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, obj.getCode());
			preparedStatement.setInt(2, obj.getDuree());
			preparedStatement.setInt(3, obj.getOrdre());

			if (obj.getFiliere() != null && obj.getFiliere().getId() != null) {
				preparedStatement.setLong(4, obj.getFiliere().getId());
			} else {
				preparedStatement.setNull(4, Types.INTEGER);
			}

			if (obj.getMatiere() != null && obj.getMatiere().getId() != null) {
				preparedStatement.setLong(5, obj.getMatiere().getId());
			} else {
				preparedStatement.setNull(5, Types.INTEGER);
			}

			if (obj.getFormateur() != null && obj.getFormateur().getId() != null) {
				preparedStatement.setLong(6, obj.getFormateur().getId());
			} else {
				preparedStatement.setNull(6, Types.INTEGER);
			}

			if (obj.getSalle() != null && obj.getSalle().getId() != null) {
				preparedStatement.setLong(7, obj.getSalle().getId());
			} else {
				preparedStatement.setNull(7, Types.INTEGER);
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
	public void update(UE obj) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement(
					"UPDATE ue SET code = ?, duree = ?, ordre = ?, filiere_id = ?, matiere_id = ?, formateur_id = ?, salle_id = ? WHERE id = ?");

			preparedStatement.setInt(1, obj.getCode());
			preparedStatement.setInt(2, obj.getDuree());
			preparedStatement.setInt(3, obj.getOrdre());

			if (obj.getFiliere() != null && obj.getFiliere().getId() != null) {
				preparedStatement.setLong(4, obj.getFiliere().getId());
			} else {
				preparedStatement.setNull(4, Types.INTEGER);
			}

			if (obj.getMatiere() != null && obj.getMatiere().getId() != null) {
				preparedStatement.setLong(5, obj.getMatiere().getId());
			} else {
				preparedStatement.setNull(5, Types.INTEGER);
			}

			if (obj.getFormateur() != null && obj.getFormateur().getId() != null) {
				preparedStatement.setLong(6, obj.getFormateur().getId());
			} else {
				preparedStatement.setNull(6, Types.INTEGER);
			}

			if (obj.getSalle() != null && obj.getSalle().getId() != null) {
				preparedStatement.setLong(7, obj.getSalle().getId());
			} else {
				preparedStatement.setNull(7, Types.INTEGER);
			}

			preparedStatement.setLong(8, obj.getId());

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
	public void delete(UE obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = Application.getInstance().getConnection();

			preparedStatement = connection.prepareStatement("DELETE ue WHERE id = ?");

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
