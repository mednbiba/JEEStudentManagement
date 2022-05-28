package dao;

import java.util.List;

import metier.entities.Etudiant;

public class TestDao {

	public static void main(String[] args) {
		
		// Insert Test
		EtudiantDaoImp edao= new EtudiantDaoImp();
		Etudiant et= edao.save(new Etudiant("ali","mustapha"));
		System.out.println(et);
		//Get List Test
		List<Etudiant> ets = edao.etudiants();
		for (Etudiant e : ets) {
			System.out.println(e.getId()+e.getNom()+e.getPrenom());
			System.out.println(e);
		}
	}

}
