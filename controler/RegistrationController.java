package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RegistrationController {
	
	
	
	@FXML
	private Button btnRegistration;
	
	@FXML
	private  Button btnBack;
	
	@FXML
	private Text txtWelcomeText;
	
	

	public void register(ActionEvent event)
	{
		System.out.println("Zarejestruj siê");
		/*if((txtUserName.getText().equals("user")) && (txtPassword.getText().equals("password")))
		{
			lblStatus.setText("Login Seccess");
			System.out.println("Zalogowano");
		}
		else
		{
			lblStatus.setText("Login Failed");
		}
		*/
	}
	
	public void back(ActionEvent event)
	{	
		Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(MainController.r.getAncestorScene());
		primaryStage.show();
	}
	
	
	
	
}
