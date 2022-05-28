package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Etudiant;
import metier.SingletonConnection;

public class EtudiantDaoImp implements IEtudiantDao {

	@Override
	public Etudiant save(Etudiant e) {
		Connection con =SingletonConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO STUDENT (nom,prenom) VALUES (?,?) ");
			ps.setString(1, e.getNom());
			ps.setString(2, e.getPrenom());
			ps.executeUpdate();
			//Add SQL here
		}catch(SQLException x) {
			x.printStackTrace();
			
		}
		
		return e;
	}

	@Override
	public List<Etudiant> etudiants() {
		List<Etudiant> etudiants=new ArrayList<Etudiant>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Etudiant e = new Etudiant();
				e.setId(rs.getInt("id"));
				e.setNom(rs.getString("nom"));
				e.setPrenom(rs.getString("prenom"));
				etudiants.add(e);}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
		return etudiants;
	}

	@Override
	public Etudiant getEtudiant(int id) {
		Connection conn=SingletonConnection.getConnection();
		Etudiant e = new Etudiant();
		try {
			PreparedStatement ps = conn.prepareStatement("select from student where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				e.setId(rs.getInt("id"));
				e.setNom(rs.getString("nom"));
				e.setPrenom(rs.getString("prenom"));
			}
		}catch(SQLException x) {
			x.printStackTrace();
		}
		
		
		
		//return 
		return e;
	}

	@Override
	public Etudiant updateEtudiant(Etudiant e) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE STUDENT SET nom=?,prenom=? WHERE ID=?");
			ps.setString(1, e.getNom());
			ps.setString(2,e.getPrenom());
			ps.setInt(2, e.getId());
			ps.executeUpdate();
			ps.close();
		} catch(SQLException x) {
			x.printStackTrace();
		}
		return e;
	}

	@Override
	public void deleteEtudiant(int id) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM STUDNET WHERE ID=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
