package Vue;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXML_controler {
	InterfaceGraphique inter;
	@FXML
	private Button jcj;
	
	@FXML
	private Button jcIA;
	
	@FXML
	private Button regles;
	
	public FXML_controler() {
		
	}
	
	@FXML
	private void initialize() {
		jcj.setOnAction((event) -> {
			inter = new InterfaceGraphique();
			Stage stage = new Stage();
			try {
				inter.start(stage);
				((Node)(event.getSource())).getScene().getWindow().hide();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		jcIA.setOnAction((event) -> {
			jcIA.setText("Not implemented");
		});
		
		regles.setOnAction((event) -> {
			regles.setText("Not implemented");
		});
		
	}
	

}
