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

public class InterfaceGraphique extends Application {
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 600;
	BorderPane root = new BorderPane();
	Controler controler;
	Jeu jeu;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Gaufre");
		primaryStage.setFullScreen(false);
		
		initPlateauGauche();
		initMenuDroite();
		

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	private void initPlateauGauche() {
		Rectangle[][] rectangles = new Rectangle[10][10];
		TilePane pane = new TilePane();
		
		pane.setHgap(3);
		pane.setVgap(3);
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Rectangle r = new Rectangle();
				r.setHeight(50);
				r.setWidth(50);
				
				r.setFill(Color.DARKGOLDENROD);
				
				rectangles[i][j] = r;
				
				pane.getChildren().add(r);
			}
		}
		
		pane.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				int l = (int) event.getX() / 50;
				int c = (int) event.getY() / 50;
				System.out.println("i = " + l + " j = " + c);

				Coup coup = new Coup(l, c);
				controler.joue(coup);
				
			}
		});
	
		
		root.setLeft(pane);
		
	}
	
	private void initMenuDroite() {
		root.setPrefSize(WIDTH, HEIGHT);
	
		//******* MENU DROITE ********
		VBox menu = new VBox();
		menu.setPrefWidth(WIDTH / 5);
		menu.setPrefHeight(HEIGHT);
	    menu.setPadding(new Insets(HEIGHT/4, 50, HEIGHT/4, 50));
	    
	    menu.setSpacing(10);
		
		Button b_annuler = new Button("Annuler");
		b_annuler.setAlignment(Pos.CENTER);
	
		
		Button b_refaire = new Button("Refaire");
		b_refaire.setAlignment(Pos.CENTER);
		
		Button b_save = new Button("Sauvegarder");
		b_save.setAlignment(Pos.CENTER);
		
		Button b_load = new Button("Charger");
		b_load.setAlignment(Pos.CENTER);
		
		
		menu.getChildren().add(b_annuler);
		menu.getChildren().add(b_refaire);
		menu.getChildren().add(b_save);
		menu.getChildren().add(b_load);
		menu.setStyle("-fx-border-style: solid");
		
		root.setRight(menu);
	}

}
