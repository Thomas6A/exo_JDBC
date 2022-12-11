package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
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
	
	public static void Recherche_date_prep() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez le jour en chiffre:");
		int jour = input.nextInt();
		System.out.println("Entrez le mois en chiffre:");
		int mois = input.nextInt();
		System.out.println("Entrez l'année:");
		int annee = input.nextInt();
		Calendar cal = Calendar.getInstance();
		cal.set(annee, mois-1, jour);
		Date date = cal.getTime();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			PreparedStatement myStmt = con.prepareStatement("select nom,prenom from emp where embauche = ?");
			myStmt.setDate(1,(java.sql.Date) date);
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
	
	public static void Recherche_chaine_prep() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez nom:");
		String nom = input.next();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			PreparedStatement myStmt = con.prepareStatement("select nom,prenom from emp where nom like '% ? %'");
			myStmt.setString(1, nom);
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

	public static void Recherche_servsal_prep() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez le service:");
		String service = input.next();
		System.out.println("Entrez le salaire");
		int salaire = input.nextInt();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			PreparedStatement myStmt = con.prepareStatement("select nom,emploi,sal,emp.noserv from emp inner join serv on emp.noserv = serv.noserv where service = ? and sal > ?");
			myStmt.setString(1, service);
			myStmt.setInt(2, salaire);
			ResultSet rs = myStmt.executeQuery();
			while (rs.next()) {
				String Nom = rs.getString("nom");
				String emploi = rs.getString("emploi");
				int sal = rs.getInt("sal");
				int noserv = rs.getInt("noserv");
				System.out.println(
						"Nom : " + Nom + " Emploi : " + emploi + " Salaire : " + sal + " numéro de service " + noserv);
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

	public static void Ajout_emp_prep() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez le numéro d'employé");
		int noemp = input.nextInt();
		System.out.println("Entrez le nom:");
		String nom = input.next();
		System.out.println("Entrez le prenom");
		String prenom = input.next();
		System.out.println("Entrez le emploi:");
		String emploi = input.next();
		System.out.println("Entrez le supérieur");
		int sup = input.nextInt();
		System.out.println("Entrez le jour d'embauche en chiffre:");
		int jour = input.nextInt();
		System.out.println("Entrez le mois d'embauche en chiffre:");
		int mois = input.nextInt();
		System.out.println("Entrez l'année d'embauche:");
		int annee = input.nextInt();
		Calendar cal = Calendar.getInstance();
		cal.set(annee, mois-1, jour);
		Date date = cal.getTime();
		System.out.println("Entrez le salaire");
		int salaire = input.nextInt();
		System.out.println("Entrez la commission");
		int comm = input.nextInt();
		System.out.println("Entrez le numéro de service");
		int noserv = input.nextInt();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			PreparedStatement myStmt = con.prepareStatement("insert into emp (noemp,nom,prenom,emploi,sup,embauche,sal,comm,noserv) values (?,?,?,?,?,?,?,?,?)");
			myStmt.setInt(1, noemp);
			myStmt.setString(2, nom);
			myStmt.setString(3, prenom);
			myStmt.setString(4, emploi);
			myStmt.setInt(5, sup);
			myStmt.setDate(6, (java.sql.Date) date);
			myStmt.setInt(7, salaire);
			myStmt.setInt(8, comm);
			myStmt.setInt(3, noserv);
			myStmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		input.close();

	}

	public static void Modifier_emp() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez le nom:");
		String nom = input.next();
		System.out.println("Entrez le prenom");
		String prenom = input.next();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select nom,prenom from emp where nom = '" + nom + "' and prenom = '" + prenom + "'");
			if (rs.isBeforeFirst()) {
				System.out.println("Entrez le nouveau numéro d'employé");
				int noemp = input.nextInt();
				System.out.println("Entrez le nouveau nom:");
				String Nnom = input.next();
				System.out.println("Entrez le nouveau prenom");
				String Nprenom = input.next();
				System.out.println("Entrez le nouvel emploi:");
				String emploi = input.next();
				System.out.println("Entrez le nouveau supérieur");
				int sup = input.nextInt();
				System.out.println("Entrez le nouveau jour d'embauche en chiffre:");
				int jour = input.nextInt();
				System.out.println("Entrez le nouveau mois d'embauche en chiffre:");
				int mois = input.nextInt();
				System.out.println("Entrez la nouvelle année d'embauche:");
				int annee = input.nextInt();
				System.out.println("Entrez le nouveau salaire");
				int salaire = input.nextInt();
				System.out.println("Entrez la nouvelle commission");
				int comm = input.nextInt();
				System.out.println("Entrez le nouveau numéro de service");
				int noserv = input.nextInt();
				st.executeUpdate("update emp set noemp = " + noemp + ", nom = '" + Nnom + "', prenom = '" + Nprenom
						+ "', emploi = '" + emploi + "', sup = " + sup + ", embauche = '" + annee + "-" + mois + "-"
						+ jour + "', sal = " + salaire + ", comm = " + comm + ", noserv = " + noserv + " where nom = '"
						+ nom + "' and prenom = '" + prenom + "'");
				System.out.println("Employé modifié");
			} else {
				System.out.println("Cet employé n'existe pas");
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		input.close();
	}

	public static void Suppr_emp() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez le nom:");
		String nom = input.next();
		System.out.println("Entrez le prenom");
		String prenom = input.next();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select nom,prenom from emp where nom = '" + nom + "' and prenom = '" + prenom + "'");
			if (rs.isBeforeFirst()) {
				st.executeUpdate("delete from emp where nom = '" + nom + "' and prenom = '" + prenom + "'");
				System.out.println("Employé supprimé");
			} else {
				System.out.println("Cet employé n'existe pas");
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		input.close();
	}

}
