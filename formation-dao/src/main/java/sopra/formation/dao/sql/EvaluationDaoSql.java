package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IEvaluationDao;
import sopra.formation.model.Evaluation;

public class EvaluationDaoSql implements IEvaluationDao {

	@Override
	public List<Evaluation> findAll() {
		List<Evaluation> evaluations = new ArrayList<Evaluation>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT id, comportementale, technique, commentaires FROM evaluation");
			rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				Integer comportementale = rs.getInt("comportementale");
				Integer technique = rs.getInt("technique");
				String commentaires = rs.getString("commentaires");

				Evaluation evaluation = new Evaluation(id, comportementale, technique, commentaires);

				evaluations.add(evaluation);
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
		
		return evaluations;
	}

	@Override
	public Evaluation findById(Long id) {
		Evaluation evaluation = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT comportementale, technique, commentaires FROM evaluation WHERE id = ?");
			
			ps.setLong(1, id);
			
			rs = ps.executeQuery();

			if (rs.next()) {
				Integer comportementale = rs.getInt("comportementale");
				Integer technique = rs.getInt("technique");
				String commentaires = rs.getString("commentaires");

				evaluation = new Evaluation(id, comportementale, technique, commentaires);
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
		
		return evaluation;
	}

	@Override
	public void create(Evaluation obj) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("INSERT INTO evaluation (comportementale, technique, commentaires) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
						
			ps.setInt(1, obj.getComportemental());
			ps.setInt(2, obj.getTechnique());
			ps.setString(3, obj.getCommentaires());
			
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
	public void update(Evaluation obj) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("UPDATE evaluation SET comportementale = ?, technique = ?, commentaires = ? WHERE id = ?");
						
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
	public void delete(Evaluation obj) {
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

	@Override
	public List<Evaluation> findAllByTechnique(Integer technique) {
		List<Evaluation> evaluations = new ArrayList<Evaluation>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			
			ps = conn.prepareStatement("SELECT id, comportementale, commentaires FROM evaluation WHERE technique = ?");
			
			ps.setInt(1, technique);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				Integer comportementale = rs.getInt("comportementale");
				String commentaires = rs.getString("commentaires");

				Evaluation evaluation = new Evaluation(id, comportementale, technique, commentaires);

				evaluations.add(evaluation);
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
		
		return evaluations;
	}

}
