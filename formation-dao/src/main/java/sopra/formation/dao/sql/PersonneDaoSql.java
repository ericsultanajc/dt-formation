package sopra.formation.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Salle;
import sopra.formation.model.Stagiaire;

public class PersonneDaoSql implements IStagiaireDao {

	@Override
	public List<Stagiaire> findAll() {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT ID, DISC, CIVILITE, NOM, PRENOM, EMAIL, TELEPHONE, DT_NAISSANCE, NIVEAU_ETUDE, REFERENT, EXPERIENCE, RUE, COMPLEMENT, CODE_POSTAL, VILL, FILIERE_ID, EVALUATION_ID FROM personne");
			rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("ID");
				String disc = rs.getString("NOM");
				
				
				
				String nom = rs.getString("NOM");
				Integer capacite = rs.getInt("CAPACITE");
				Boolean videoProjec = rs.getString("VIDEO_PROJECTEUR").contentEquals("O") ? true : false;
				String rue = rs.getString("RUE");
				String complement = rs.getString("COMPLEMENT");
				String codePostal = rs.getString("CODE_POSTAL");
				String ville = rs.getString("VILLE");

				Salle salle = new Salle(id, nom, capacite, videoProjec);
				salle.setAdr(new Adresse(rue, complement, codePostal, ville));

				salles.add(salle);
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

		return salles;
	}
	}

	@Override
	public Stagiaire findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Stagiaire obj) {
		// TODO Auto-generated method stub
		
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
