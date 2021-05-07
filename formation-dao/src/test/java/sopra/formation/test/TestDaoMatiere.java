package sopra.formation.test;



import java.io.IOException;
import java.util.List;

import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.file.csv.MatiereDaoCsv;
import sopra.formation.model.Matiere;


public class TestDaoMatiere {
	
	
	public static void main(String[] args) {
		
		IMatiereDao matiereDao = new MatiereDaoCsv("matieres.txt");

		List<Matiere> matieres = matiereDao.findAll();
		for (Matiere matiere : matieres) {
			System.out.println(matiere);
		}

		System.out.println(matiereDao.findById(2L));
		
		Matiere matiere = new Matiere(4L, "XML", 4);
		
		matiereDao.create(matiere);
		System.out.println(matieres);
		
		matiere.setDuree(63);
		System.out.println(matiere);

	}

}
