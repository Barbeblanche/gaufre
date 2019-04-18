package Vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InterfaceGraphique extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Gaufre");
		primaryStage.setFullScreen(true);
		
		Canvas canvas = new Canvas();
		Pane vue = new Pane(canvas);
		vue.setPrefSize(600, 400);
		
		HBox boiteScene = new HBox();
		boiteScene.getChildren().add(vue);
		
		Scene scene = new Scene(boiteScene);
		primaryStage.setScene(scene);
		primaryStage.show();


	}

}
