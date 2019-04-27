package Controler;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

import Model.*;


public class Controler {
	String save;
	Jeu jeu;
	IA_Random ia;
	Joueur j1,j2;
	private Joueur courant;
	public Controler() {
		//jeu = Jeu.getInstance(); Bug au niveau de rejouer
		jeu = new Jeu();
		ia = new IA_Random();
		j1 = new Joueur("Joueur 1",jeu);
		j2 = new Joueur("Joueur 2",jeu);
		setCourant(j1);
		save = this.getClass().getClassLoader().getResource("Save.txt").getPath();
	}
	public Controler(Jeu j) {
		setJeu(j);
		ia = new IA_Random();
		setCourant(j1);
	}
	
	
	public int joue(Coup coup) {
		int res = getCourant().jouer(coup);
		if (res == 0) {
			if (getCourant() == j1) {
				setCourant(j2);
			}else {
				setCourant(j1);
			}
		}
		return res;
	}
	
	/*private void click(Coup coup) {
		getJeu().joue(coup);
	}*/
	
	public boolean coupPossible(Coup coup) {
		return (getJeu().coupPossible(coup));
	}
	
	public void precedent() {
		courant.precedent();
	}
	
	public void refaire() {
		courant.refaire();
	}
	
	public void affiche() {
		getJeu().affiche();
	}

	public void save() throws IOException {

		System.out.println(save);
		
		FileWriter fileWriter = new FileWriter(new File(save));
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    
	    String s = "";
	    for(int i = 0; i < 10; i++) {
	    	for (int j = 0; j < 10; j++) {
	    		s += getJeu().plateau[i][j] + " ";
	    	}
	    }
	    printWriter.write(s);
	    printWriter.close();
		
	}
	
	public void load() throws IOException {
		File file = new File(save); 
	    @SuppressWarnings("resource")
		Scanner sc = new Scanner(file); 
	  
	    int plateau[][] = new int[10][10];
	    int l = 0, c = 0;
	    
	    while (sc.hasNextInt()) {
	    	while(l < 10) {
	    		c = 0;
	    		while (c < 10) {
	    			plateau[l][c] = sc.nextInt();
	    			c++;
	    		}
	    		l++;
	    	}
	    } 
	    getJeu().plateau = plateau;
	    j1.coups = new Stack<Coup>();
	    j2.coups = new Stack<Coup>();
	    j1.dernierCoup = null;
	    j2.dernierCoup = null;
	}
	public Jeu getJeu() {
		return jeu;
	}
	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}
	public Joueur getCourant() {
		return courant;
	}
	public void setCourant(Joueur courant) {
		this.courant = courant;
	}
}
