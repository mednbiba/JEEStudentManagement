package web;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Etudiant;

public class EtudiantModele {
	List<Etudiant> ets = new ArrayList<>();

	public List<Etudiant> getEts() {
		return ets;
	}

	public void setEts(List<Etudiant> ets) {
		this.ets = ets;
	}
	

}
