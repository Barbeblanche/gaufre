package Model;

import java.util.Stack;

public class Jeu {
	public final int REMPLIE = 1;
	public final int VIDE = 0;
	public final int POISON = 2;
	
	public int[][] plateau;
	public Stack<Coup> coups;
	public Coup dernierCoup;
	
	public Jeu() {
		plateau = new int[10][10];
		coups = new Stack<Coup>();
		initTableau(plateau,10,10);
		dernierCoup = null;
	}
	
	public void initTableau(int [][] tab,int x,int y) {
		for (int i = 0; i < x; i ++) {
			for (int j = 0; j < y; j++) {
				tab[i][j] = REMPLIE;
			}
		}
		tab[0][0] = POISON;
	}
	
	public boolean coupPossible (Coup coup) {
		return (plateau[coup.l][coup.c] == REMPLIE || plateau[coup.l][coup.c] == POISON);
	}
	
	
	public int joue(Coup coup) {
		int res=-1;
		if (coupPossible(coup)) {
			coups.push(coup);
			if (plateau[coup.l][coup.c]== POISON) {
				res = 1;
			}else {
				for (int i = coup.l; i < 10; i++) {
					for (int j = coup.c; j < 10; j++) {
						plateau[i][j] = VIDE;
						res = 0;
					}
				}
			}
			
			
		}
		return res;
		
	}
	
	public void precedent() {
		if (!coups.empty()) {
			dernierCoup = coups.pop();
			initTableau(plateau,10,10);
			Stack<Coup> tmp = new Stack<Coup>();
			tmp = coups;
			while (!tmp.empty()) {
				joue(tmp.pop());
			}
		}else {
			System.out.println("Jouer un coup avant");
		}
	}
	
	public void refaire() {
		if (dernierCoup != null) {
			joue(dernierCoup);
		}else {
			System.out.println("Annule un coup avant");
		}
	}
	

	public void affiche() {
		String s = "";
		for (int l = 0; l < 10; l++) {
			s += "\n";
			for (int c = 0; c < 10; c++) {
				switch(plateau[l][c]) {
				
				case(REMPLIE):
					s += "| O ";
					break;
				
				case(VIDE):
					s += "|   ";
					break;
					
				case(POISON):
					s += "| X ";
				break;
				}
			}
		}
		
		System.out.println(s);
	}
	

}
