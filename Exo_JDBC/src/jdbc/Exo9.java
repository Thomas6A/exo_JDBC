package jdbc;

import java.util.Scanner;

public class Exo9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Séléctionner un des choix suivants");
			System.out.println("1 - Afficher la liste des employés");
			System.out.println("2 - Afficher le détail d'un employé");
			System.out.println("3 - Ajouter un employé");
			System.out.println("4 - Modifier un employé à partir de son nom et prénom");
			System.out.println("5 - Supprimer un employé à partir de son nom et prénom");
			System.out.println("6 - Fermer le programme");
			int choix = input.nextInt();
			if (choix == 1) {
				methode_exo.Affiche_list();
				continue;
			} else if (choix == 2) {
				methode_exo.Recherche_nom();
				continue;
			} else if (choix == 3) {
				methode_exo.Ajout_emp();
				continue;
			} else if (choix == 4) {
				methode_exo.Modifier_emp();
				continue;
			} else if (choix == 5) {
				methode_exo.Suppr_emp();
				continue;
			}else if(choix == 6) {
				break;
			}
		} while (true);
		input.close();

	}

}
