import java.io.IOException;
import java.util.Scanner;

import Controlleur.Controleur;
import Model.Coup;
import Model.Jeu;

public class Gaufre_Textuelle {
	final static int ANNULER = -1;
	final static int REFAIRE = -2;
	final static int SAVE = -3;
	final static int LOAD = -4;
	
	public static void main(String args[]) throws IOException {
		Controleur controleur = new Controleur();
		
		System.out.println("Veuillez choisir une case : ");
		Scanner sc = new Scanner(System.in);
	    int l, c;
	    
	    controleur.affiche();

	    while (true) {
	    	controleur.affiche();
		    l = sc.nextInt();
		    c = sc.nextInt();
		    
		    if (l == SAVE || c == SAVE) {
		    	controleur.save();
		    } 
		    
		    else if (l == LOAD || c == LOAD) {
		    	controleur.load();
			    controleur.affiche();
			    
		    }
		    
		    else if (l== ANNULER || c == ANNULER) {
		    	controleur.precedent();
		    }
		    
		    else if (l== REFAIRE || c == REFAIRE) {
		    	controleur.refaire();
		    }
		    
		    else {
		    	Coup coup = new Coup(l,c);
			    if (controleur.joue(coup) == 1) {
			    	System.out.println("Partie terminée!");
			    	return;
			    }  
		    }
	  
	    }
	}
}
