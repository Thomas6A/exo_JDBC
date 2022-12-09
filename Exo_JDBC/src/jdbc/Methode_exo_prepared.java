package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Methode_exo_prepared {
	public static void Emp_serv5_prep() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			PreparedStatement myStmt = con.prepareStatement("select nom,prenom from emp where noserv = ?");
			myStmt.setInt(1, 5);
			ResultSet rs = myStmt.executeQuery();
			while (rs.next()) {
				String Nom = rs.getString("nom");
				String Prenom = rs.getString("prenom");
				System.out.println("Nom : " + Nom + " Prenom : " + Prenom);
			}
			rs.close();
			myStmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void Emp_servInfo_prep() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			PreparedStatement myStmt = con.prepareStatement(
					"select nom,prenom from emp inner join serv on emp.noserv = serv.noserv where service = ?");
			myStmt.setString(1, "INFORMATIQUE");
			ResultSet rs = myStmt.executeQuery();
			while (rs.next()) {
				String Nom = rs.getString("nom");
				String Prenom = rs.getString("prenom");
				System.out.println("Nom : " + Nom + " Prenom : " + Prenom);
			}
			rs.close();
			myStmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static void Recherche_nom_prep() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez nom:");
		String nom = input.next();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			PreparedStatement myStmt = con.prepareStatement("select * from emp where nom = ?");
			myStmt.setString(1, nom);
			ResultSet rs = myStmt.executeQuery();
			while (rs.next()) {
				String Nom = rs.getString("nom");
				String Prenom = rs.getString("prenom");
				String Emploi = rs.getString("emploi");
				int Superieur = rs.getInt("sup");
				String embauche = rs.getString("embauche");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int noserv = rs.getInt("noserv");
				System.out.println("Nom : " + Nom + " Prenom : " + Prenom + " Emploi : " + Emploi + " Supérieur : "
						+ Superieur + " Embauche : " + embauche + " Salaire : " + sal + " Commission : " + comm
						+ " Numéro de service : " + noserv);
			}
			rs.close();
			myStmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		input.close();

	}
	
	public static void Recherche_date() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez le jour en chiffre:");
		int jour = input.nextInt();
		System.out.println("Entrez le mois en chiffre:");
		int mois = input.nextInt();
		System.out.println("Entrez l'année:");
		int annee = input.nextInt();
		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(annee+"-"+mois+"-"+jour);
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			PreparedStatement myStmt = con.prepareStatement("select nom,prenom from emp where embauche = ?");
			myStmt.setDate(1, date);
			ResultSet rs = myStmt.executeQuery();
			while (rs.next()) {
				String Nom = rs.getString("nom");
				String Prenom = rs.getString("prenom");
				System.out.println("Nom : " + Nom + " Prenom : " + Prenom);
			}
			rs.close();
			myStmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		input.close();

	}

}
