import java.util.Scanner;

import Model.Jeu;

public class Gaufre_Textuelle {
	public static void main(String args[]) {
		Jeu jeu = new Jeu();
		
		System.out.println("Veuillez choisir une case : ");
		Scanner sc = new Scanner(System.in);
	    int l, c;
	    
	    while (true) {
		    jeu.affiche();
		    l = sc.nextInt();
		    c = sc.nextInt();
		    jeu.joue(l, c);
	    }
	}
}
