package Model;

public class Jeu {
	final int REMPLIE = 1;
	final int VIDE = 0;
	final int POISON = 2;
	
	int[][] plateau;
	
	
	public Jeu() {
		plateau = new int[10][10];
		for (int i = 0; i < 10; i ++) {
			for (int j = 0; j < 10; j++) {
				plateau[i][j] = REMPLIE;
			}
		}
		plateau[0][0] = POISON;
	}
	
	private boolean coupPossible (int l, int c) {
		return (plateau[l][c] == REMPLIE);
	}
	
	public void joue(int l, int c) {
		if (coupPossible(l,c)) {
			for (int i = l; i < 10; i++) {
				for (int j = c; j < 10; j++) {
					plateau[i][j] = VIDE;
				}
			}
		}
	}
}
