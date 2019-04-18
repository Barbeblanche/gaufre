package Controlleur;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.sun.javafx.application.LauncherImpl;

import Vue.InterfaceGraphique;
import Model.Coup;
import Model.Jeu;
import javafx.application.Application;

public class Controleur {
	final static String save = "/home/p/pontonnr/git/Gaufre/Gaufre/config/Save";
	Jeu jeu;
	
	public Controleur() {
		jeu = new Jeu();
	}
	
	public boolean joue(Coup coup) {
		return (jeu.joue(coup));
	}
	
	public void affiche() {
		jeu.affiche();
	}

	public void save() throws IOException {
		
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
	}
}
