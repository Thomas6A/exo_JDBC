package jdbc;

import java.util.Scanner;

public class Exo9_prep {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Séléctionner un des choix suivants");
		System.out.println("1 - Afficher la liste des employés");
		System.out.println("2 - Afficher le détail d'un employé");
		System.out.println("3 - Ajouter un employé");
		System.out.println("4 - Modifier un employé à partir de son nom et prénom");
		System.out.println("5 - Supprimer un employé à partir de son nom et prénom");
		System.out.println("6 - Fermer le programme");
		int choix = input.nextInt();
		switch (choix) {
		case 1:
			methode_exo.Affiche_list();
			main(null);
		case 2:
			Methode_exo_prepared.Recherche_nom_prep();
			main(null);
		case 3:
			Methode_exo_prepared.Ajout_emp_prep();
			main(null);
		case 4:
			Methode_exo_prepared.Modifier_emp_prep();
			main(null);
		case 5:
			Methode_exo_prepared.Suppr_emp_prep();
			main(null);
		case 6:
			System.exit(0);
			break;
		}
		input.close();

	}
}
