package Model;

public class Joueur {
	private String nom;
	Jeu jeu;
	public Joueur(Jeu j) {
		setNom("Joueur");
		jeu = j;
	}
	
	public Joueur(String m, Jeu j) {
		setNom(m);
		jeu = j;
	}
	
	public int jouer(Coup c) {
		return jeu.joue(c);
	}

	public String getNom() {
		return nom;
	}

	void setNom(String nom) {
		this.nom = nom;
	}
}
