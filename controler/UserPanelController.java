package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Login;

public class UserPanelController {

	@FXML
	private Text txtWelcomeText;
	
	@FXML
	private Button btnBack;
	
	
	
	public void back(ActionEvent event)
	{	
		Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(Login.getAncestorScene());
		primaryStage.show();
	}
	
	
}