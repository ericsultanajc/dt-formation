package sopra.formation.dao.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IPersonneDao;
import sopra.formation.model.Personne;

public class PersonneDaoSql implements IPersonneDao {

	@Override
	public List<Personne> findAll() {
		List<Personne> personnes = new ArrayList<Personne>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = Application.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT id, disc, civilite, nom, prenom, email, telephone, dt_naissance, "
					+ "niveau_etude, referent, experience, rue, complement, code_postal, ville, filiere_id, evaluation_id FROM personne");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		return personnes;
	}

	@Override
	public Personne findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Personne obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Personne obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Personne obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
