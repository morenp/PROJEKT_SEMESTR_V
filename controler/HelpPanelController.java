package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.HelpPanel;


public class HelpPanelController {
	
	@FXML
	private  Button btnBack;
	
	@FXML
	private Text txtWelcomeText;
	
	
	

	
	public void back(ActionEvent event)
	{	
		Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(HelpPanel.getAncestorScene());
		primaryStage.show();
	}

}
