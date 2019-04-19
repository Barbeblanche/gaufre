package Vue;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class InterfaceGraphique extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Gaufre");
		primaryStage.setFullScreen(false);
		
		Canvas canvas = new Canvas();
		Pane vue = new Pane(canvas);
		vue.setPrefSize(600, 400);
		
		Group groupe = new Group();
		groupe.getChildren().add(vue);
		//Rectangle[10][10] plateau;
		for(int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				Rectangle r = new Rectangle(i+50,j+50,50,50);
				r.setStroke(Color.BLACK);
				r.setFill(Color.ORANGE);
				groupe.getChildren().add(r);
			}
		}
		//Rectangle r = new Rectangle(0,50,50,50);
		//r.setStroke(Color.BLACK);
		//r.setFill(Color.ORANGE);
		
		Scene scene = new Scene(groupe);
		primaryStage.setScene(scene);
		primaryStage.show();


	}

}
