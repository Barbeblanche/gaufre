package Model;

import java.util.Stack;

public class Jeu {
	final int REMPLIE = 1;
	final int VIDE = 0;
	final int POISON = 2;
	
	int[][] plateau;
	Stack<Coup> coups;
	Coup dernierCoup;
	
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
	private boolean coupPossible (Coup coup) {
		return (plateau[coup.l][coup.c] == REMPLIE);
	}
	
	public boolean joue(Coup coup) {
		if (coupPossible(coup)) {
			coups.push(coup);
			for (int i = coup.l; i < 10; i++) {
				for (int j = coup.c; j < 10; j++) {
					plateau[i][j] = VIDE;
				}
			}
		}
		
		return (coupPossible(coup));
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
