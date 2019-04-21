package Controler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

import Model.Coup;
import Model.Jeu;

public class Controler {
	String save;
	Jeu jeu;
	IA_Random ia;
	
	public Controler() {
		jeu = Jeu.getInstance();
		ia = new IA_Random();
		save = this.getClass().getClassLoader().getResource("Save.txt").getPath();
	}
	public Controler(Jeu j) {
		jeu = j;
		ia = new IA_Random();
	}
	
	
	public int joue(Coup coup) {
		int res = jeu.joue(coup);
		//Coup coupIA = ia.getCoup();
		
		return res;
	}
	
	private void click(Coup coup) {
		jeu.joue(coup);
	}
	
	public boolean coupPossible(Coup coup) {
		return (jeu.coupPossible(coup));
	}
	
	public void precedent() {
		jeu.precedent();
	}
	
	public void refaire() {
		jeu.refaire();
	}
	
	public void affiche() {
		jeu.affiche();
	}

	public void save() throws IOException {

		System.out.println(save);
		
		FileWriter fileWriter = new FileWriter(new File(save));
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    
	    String s = "";
	    for(int i = 0; i < 10; i++) {
	    	for (int j = 0; j < 10; j++) {
	    		s += jeu.plateau[i][j] + " ";
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
	    jeu.plateau = plateau;
	    jeu.coups = new Stack<Coup>();
	    jeu.dernierCoup = null;
	}
}
