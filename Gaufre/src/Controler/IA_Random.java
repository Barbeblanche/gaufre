package Controler;

import java.util.Random;

import Model.Coup;
import Model.Jeu;

public class IA_Random extends IA {
	Random r;
	
	public IA_Random (Jeu j) {
		r = new Random();
		this.j = j;
		
	}
	public Coup getCoup(){
		Coup coup = new Coup();
		Coup coupBas = new Coup(0,1);
		Coup coupGauche = new Coup(1,0);
		if( j.coupPossible(coupBas) || j.coupPossible(coupGauche) ) {		//on peut jouer un coup non perdant
			do{
				coup.l = r.nextInt(9);
				coup.c = r.nextInt(9);
			} while((coup.l == 0 && coup.c == 0) || !j.coupPossible(coup));		
		}
		else {
			coup.l = 0;
			coup.c = 0;
		}
		System.out.println("L'IA aurait joué " + coup.l + " " + coup.c);
		return coup;
	}
}
