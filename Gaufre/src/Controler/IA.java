package Controler;

import Model.*;

public abstract class IA {
	Jeu j;
	Controler control;
	
	abstract public Coup getCoup();
}