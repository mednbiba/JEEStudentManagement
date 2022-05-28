package metier.entities;

import java.io.Serializable;

public class Etudiant implements Serializable {
private int id;
private String nom;
private String prenom;

public Etudiant() {
	super();
}
public Etudiant(String nom,String prenom) {
	super();
	this.nom=nom;
	this.prenom=prenom;
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
}
