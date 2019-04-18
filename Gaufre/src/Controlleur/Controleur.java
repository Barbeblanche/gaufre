package Controlleur;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.sun.javafx.application.LauncherImpl;

import Vue.InterfaceGraphique;
import Model.Coup;
import Model.Jeu;
import javafx.application.Application;

public class Controleur {
	Jeu jeu;
	
	public Controleur() {
		jeu = new Jeu();
	}
	
	public int joue(Coup coup) {
		return (jeu.joue(coup));
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
	   FileWriter fileWriter = new FileWriter("Save");
	   PrintWriter printWriter = new PrintWriter(fileWriter);
	   
	   printWriter.close();
	}
}
