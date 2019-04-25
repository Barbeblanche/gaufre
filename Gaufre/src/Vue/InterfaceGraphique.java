package Vue;

import java.util.ArrayList;


import Controler.Controler;
import Model.Coup;
import Model.Jeu;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.text.*;

public class InterfaceGraphique extends Application {
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 600;
	BorderPane root = new BorderPane();
	Controler controler;
	Rectangle[][] plateauGraphique;
	Text joueurCourant;
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Gaufre");
		primaryStage.setFullScreen(false);
		controler = new Controler();
		initPlateauGauche();
		initMenuDroite();
		

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();

	}
	public InterfaceGraphique() {
		
	}
	
	private void initPlateauGauche() {
		plateauGraphique = new Rectangle[10][10];
		TilePane pane = new TilePane();
		
		pane.setHgap(3);
		pane.setVgap(3);
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Rectangle r = new Rectangle();
				r.setHeight(50);
				r.setWidth(50);
				if (i ==0 && j ==0) {
					r.setFill(Color.DARKGREEN);  //Case Poison
				}else {
					r.setFill(Color.DARKGOLDENROD);
				}
				
				
				plateauGraphique[i][j] = r;
				
				//Pour montrer le coup qui va être joué (cases en surbrillance) 
				//Variables qui servent à avoir la position du rectangle selectionné (car impossible d'utiliser i et j dans le handler)
				final int I =i;
				final int J =j;
				plateauGraphique[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						for (int x = I; x < 10; x ++) {
							for (int y = J; y < 10; y++) {
								if (controler.getJeu().plateau[x][y] == controler.getJeu().REMPLIE) {
									plateauGraphique[x][y].setFill(Color.LIGHTGREY);
								}
							}
						}
					}
				});
				plateauGraphique[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
					
					@Override
					public void handle(MouseEvent event) {
						for (int x = I; x < 10; x ++) {
							for (int y = J; y < 10; y++) {
								if (controler.getJeu().plateau[x][y] == controler.getJeu().REMPLIE) {
									plateauGraphique[x][y].setFill(Color.DARKGOLDENROD);
								}
							}
						}
					}
				});
				pane.getChildren().add(r);
			}
		}
		
		pane.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				int l = (int) event.getY() / 50;
				int c = (int) event.getX() / 50;
				
				//System.out.println("i = " + l + " j = " + c);

				Coup coup = new Coup(l, c);
				
				//Ecran fin de partie avec bouton rejouer
				if (controler.joue(coup) == 1) {
					pane.getChildren().clear();
					Text finPartie = new Text(100, 100, "Partie Terminée ! " + controler.getCourant().getNom() + " a perdu !" );
					finPartie.setTextAlignment(TextAlignment.CENTER);
					Button rejouer = new Button("Rejouer");
					rejouer.setAlignment(Pos.CENTER);
					rejouer.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							controler = new Controler();
							initPlateauGauche();
							initMenuDroite();
						}
					});
					
					finPartie.setFont(new Font(15));
					pane.getChildren().add(finPartie);
					pane.getChildren().add(rejouer);
				}
				majPlateau();
				
			}
		});
	
		
		root.setLeft(pane);
		
	}
	
	//Met le plateauGraphique à jour en fonction du plateau dans Jeu
	private void majPlateau() {
		for (int i =0; i<10; i++) {
			for (int j =0; j<10; j++) {
				if (controler.getJeu().plateau[i][j] == controler.getJeu().VIDE) {
					plateauGraphique[i][j].setFill(Color.DARKGRAY);
				}else if (controler.getJeu().plateau[i][j] == controler.getJeu().REMPLIE) {
					plateauGraphique[i][j].setFill(Color.DARKGOLDENROD);
				}
			}
		}
		joueurCourant.setText("Joueur courant : \n" + controler.getCourant().getNom());
	}
	
	private void initMenuDroite() {
		root.setPrefSize(WIDTH, HEIGHT);
	
		//******* MENU DROITE ********
		VBox menu = new VBox();
		menu.setPrefWidth(WIDTH / 5);
		menu.setPrefHeight(HEIGHT);
	    menu.setPadding(new Insets(HEIGHT/4, 50, HEIGHT/4, 50));
	    
	    menu.setSpacing(10);
		
	    joueurCourant = new Text("Joueur courant : \n" + controler.getCourant().getNom());
	    joueurCourant.setFill(Color.RED);
	    
		Button b_annuler = new Button("Annuler");
		b_annuler.setAlignment(Pos.CENTER);
		b_annuler.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				controler.precedent();
				majPlateau();
			}
		});
		
		Button b_refaire = new Button("Refaire");
		b_refaire.setAlignment(Pos.CENTER);
		b_refaire.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				controler.refaire();
				majPlateau();
			}
		});
		Button b_nvPartie = new Button("New Game");
		b_nvPartie.setAlignment(Pos.CENTER);
		b_nvPartie.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				controler = new Controler();
				majPlateau();
			}
		});
		
		Button b_save = new Button("Sauvegarder");
		b_save.setAlignment(Pos.CENTER);
		
		Button b_load = new Button("Charger");
		b_load.setAlignment(Pos.CENTER);
		
		menu.getChildren().add(joueurCourant);
		menu.getChildren().add(b_annuler);
		menu.getChildren().add(b_refaire);
		menu.getChildren().add(b_save);
		menu.getChildren().add(b_load);
		menu.getChildren().add(b_nvPartie);
		menu.setStyle("-fx-border-style: solid");
		
		root.setRight(menu);
	}

}
