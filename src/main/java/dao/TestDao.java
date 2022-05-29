package dao;

import java.util.List;

import metier.entities.Etudiant;

public class TestDao {

	public static void main(String[] args) {
		
		// Insert Test
		EtudiantDaoImp edao= new EtudiantDaoImp();
		//Etudiant et= edao.save(new Etudiant("ali","mustapha","departement"));
		//System.out.println(et);
		//Get List Test
		List<Etudiant> ets = edao.etudiantsdpt("electronique");
		for (Etudiant e : ets) {
			System.out.println(e);
		}
	}

}
