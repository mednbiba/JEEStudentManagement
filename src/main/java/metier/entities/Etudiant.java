package metier.entities;

import java.io.Serializable;

public class Etudiant implements Serializable {
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private int id;
private String nom;
private String prenom;
private String departement;

public Etudiant() {
	super();
}
public Etudiant(String nom,String prenom,String Departement) {
	super();
	this.nom=nom;
	this.prenom=prenom;
	this.departement=Departement;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
@Override
public String toString() {
	return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
}
public String getDepartement() {
	return departement;
}
public void setDepartement(String departement) {
	this.departement = departement;
}


}
