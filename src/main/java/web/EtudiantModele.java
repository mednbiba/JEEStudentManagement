package web;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Etudiant;

public class EtudiantModele {
	List<Etudiant> ets = new ArrayList<>();
	private String rechercheDpt;

	public List<Etudiant> getEts() {
		return ets;
	}

	public void setEts(List<Etudiant> ets) {
		this.ets = ets;
	}

	public String getRechercheDpt() {
		return rechercheDpt;
	}

	public void setRechercheDpt(String rechercheDpt) {
		this.rechercheDpt = rechercheDpt;
	}
	

}
