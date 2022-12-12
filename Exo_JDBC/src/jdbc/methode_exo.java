package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class methode_exo {
	public static void Affiche_list() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select nom,prenom from emp");
			while (rs.next()) {
				String Nom = rs.getString("nom");
				String Prenom = rs.getString("prenom");
				System.out.println("Nom : " + Nom + " Prenom : " + Prenom);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void Emp_serv5() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select nom,prenom from emp where noserv = 5");
			while (rs.next()) {
				String Nom = rs.getString("nom");
				String Prenom = rs.getString("prenom");
				System.out.println("Nom : " + Nom + " Prenom : " + Prenom);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void Emp_servInfo() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"select nom,prenom from emp inner join serv on emp.noserv = serv.noserv where service = 'INFORMATIQUE'");
			while (rs.next()) {
				String Nom = rs.getString("nom");
				String Prenom = rs.getString("prenom");
				System.out.println("Nom : " + Nom + " Prenom : " + Prenom);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void Recherche_nom() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez nom:");
		String nom = input.next();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from emp where nom = '" + nom + "'");
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
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void Recherche_date() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez le jour en chiffre:");
		int jour = input.nextInt();
		System.out.println("Entrez le mois en chiffre:");
		int mois = input.nextInt();
		System.out.println("Entrez l'année:");
		int annee = input.nextInt();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"select nom,prenom from emp where embauche = '" + annee + "-" + mois + "-" + jour + "'");
			while (rs.next()) {
				String Nom = rs.getString("nom");
				String Prenom = rs.getString("prenom");
				System.out.println("Nom : " + Nom + " Prenom : " + Prenom);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void Recherche_chaine() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez nom:");
		String nom = input.next();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select nom,prenom from emp where nom like '%" + nom + "%'");
			while (rs.next()) {
				String Nom = rs.getString("nom");
				String Prenom = rs.getString("prenom");
				System.out.println("Nom : " + Nom + " Prenom : " + Prenom);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void Recherche_servsal() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez le service:");
		String service = input.next();
		System.out.println("Entrez le salaire");
		int salaire = input.nextInt();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/briefexo", "postgres",
					"Simplon59");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"select nom,emploi,sal,emp.noserv from emp inner join serv on emp.noserv = serv.noserv where service = '"
							+ service + "' and sal > " + salaire);
			while (rs.next()) {
				String Nom = rs.getString("nom");
				String emploi = rs.getString("emploi");
				int sal = rs.getInt("sal");
				int noserv = rs.getInt("noserv");
				System.out.println(
						"Nom : " + Nom + " Emploi : " + emploi + " Salaire : " + sal + " numéro de service " + noserv);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void Ajout_emp() {
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
			Statement st = con.createStatement();
			st.executeUpdate("insert into emp (noemp,nom,prenom,emploi,sup,embauche,sal,comm,noserv) values (" + noemp
					+ ", '" + nom + "', '" + prenom + "', '" + emploi + "', " + sup + ", '" + annee + "-" + mois + "-"
					+ jour + "', " + salaire + ", " + comm + ", " + noserv + ")");
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
	}

}
