import java.util.Scanner;

import Controlleur.Controleur;
import Model.Coup;
import Model.Jeu;

public class Gaufre_Textuelle {
	final static int ANNULER = -1;
	final static int REFAIRE = -2;
	final static int SAVE = -3;
	final static int LOAD = -4;
	
	public static void main(String args[]) {
		Controleur controleur = new Controleur();
		
		System.out.println("Veuillez choisir une case : ");
		Scanner sc = new Scanner(System.in);
	    int l, c;
	    
	    while (true) {
	    	controleur.affiche();
		    l = sc.nextInt();
		    c = sc.nextInt();
		    
		    if (l == SAVE || c == SAVE) {
		    	
		    } else if (l == LOAD || c == LOAD) {
		    	
		    }else if (l== ANNULER || c == ANNULER) {
		    	System.out.println("Test");
		    	controleur.precedent();
		    }else if (l== REFAIRE || c == REFAIRE) {
		    	
		    }else {
		    	Coup coup = new Coup(l,c);
			    controleur.joue(coup);
		    }
		    
		    
	    }
	}
}
