package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class methode_exo {
	public static void Exo2(Connection con){
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select nom,prenom from emp");
			while (rs.next()){
				String Nom = rs.getString("nom");
				String Prenom = rs.getString("prenom");
				System.out.println("Nom : "+Nom+" Prenom : "+Prenom);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void Exo3(Connection con) {
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select nom,prenom from emp where noserv = 5");
			while (rs.next()){
				String Nom = rs.getString("nom");
				String Prenom = rs.getString("prenom");
				System.out.println("Nom : "+Nom+" Prenom : "+Prenom);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
