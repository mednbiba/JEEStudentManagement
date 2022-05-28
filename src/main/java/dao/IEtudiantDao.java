package dao;

import java.util.List;

import metier.entities.Etudiant;

public interface IEtudiantDao {
	public Etudiant save(Etudiant e);
	public List<Etudiant> etudiants();
	public Etudiant getEtudiant(int id);
	public Etudiant updateEtudiant(Etudiant e);
	public void deleteEtudiant(int id);

}
