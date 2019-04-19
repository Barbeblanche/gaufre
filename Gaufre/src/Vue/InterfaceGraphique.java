package Vue;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class InterfaceGraphique extends Application {
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 600;
	BorderPane root = new BorderPane();
	
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
		VBox box = new VBox();
		ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
		
		for (int i = 0; i < 10; i++) {
			Rectangle r = new Rectangle(HEIGHT/10, (WIDTH/5)*4/10);
			rectangles.add(r);
		}
		
		for (Rectangle r : rectangles)
			box.getChildren().add(r);
		
		root.setLeft(box);
		
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
