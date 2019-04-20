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
				if (controler.joue(coup) == 1) {
					pane.getChildren().clear();
					Text t = new Text(200, 300, "Partie Terminée ! " + controler.getCourant().getNom() + " a perdu !" );
					t.setFont(new Font(15));
					pane.getChildren().add(t);
				}
				majPlateau();
				joueurCourant.setText("Joueur courant : \n" + controler.getCourant().getNom());
			}
		});
	
		
		root.setLeft(pane);
		
	}
	
	//Met le plateauGraphique à jour en fonction du plateau dans Jeu
	private void majPlateau() {
		for (int i =0; i<10; i++) {
			for (int j =0; j<10; j++) {
				if (controler.getJeu().plateau[i][j] == controler.getJeu().VIDE) {
					plateauGraphique[i][j].setFill(Color.LIGHTGREY);
				}else if (controler.getJeu().plateau[i][j] == controler.getJeu().REMPLIE) {
					plateauGraphique[i][j].setFill(Color.DARKGOLDENROD);
				}
			}
		}
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
		
		Button b_save = new Button("Sauvegarder");
		b_save.setAlignment(Pos.CENTER);
		
		Button b_load = new Button("Charger");
		b_load.setAlignment(Pos.CENTER);
		
		menu.getChildren().add(joueurCourant);
		menu.getChildren().add(b_annuler);
		menu.getChildren().add(b_refaire);
		menu.getChildren().add(b_save);
		menu.getChildren().add(b_load);
		menu.setStyle("-fx-border-style: solid");
		
		root.setRight(menu);
	}

}
