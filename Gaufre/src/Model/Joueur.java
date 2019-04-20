package Model;

import java.util.Stack;

public class Joueur {
	private String nom;
	Jeu jeu;
	public Stack<Coup> coups;
	public Coup dernierCoup;
	
	public Joueur(Jeu j) {
		setNom("Joueur");
		jeu = j;
		coups = new Stack<Coup>();
		dernierCoup = null;
	}
	
	public Joueur(String m, Jeu j) {
		setNom(m);
		jeu = j;
		coups = new Stack<Coup>();
		dernierCoup = null;
	}
	
	public int jouer(Coup c) {
		return jeu.joue(c,coups);
	}
	
	public void precedent() {
		jeu.precedent(coups,dernierCoup);
	}
	
	public void refaire() {
		jeu.refaire(dernierCoup, coups);
	}
	public String getNom() {
		return nom;
	}

	void setNom(String nom) {
		this.nom = nom;
	}
}
