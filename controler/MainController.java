package controler;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.HelpPanel;
import model.Login;
import model.Registration;
import model.UserPanel;


public class MainController {

	@FXML
	private Button btnLogIn;
	
	@FXML
	private Button btnRegister;
	
	@FXML
	private  Button btnHelp;
	
	@FXML
	private Button btnExit;
	
	public void login(ActionEvent event) throws IOException
	{

		
		Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		Login l = new Login();
		l.setAncestorPage(((Node) event.getSource()).getParent());
		l.setAncestorScene(((Node) event.getSource()).getScene());

		
		primaryStage.setScene(l.getScene());
		primaryStage.show();
		
	}
	
	public void register(ActionEvent event) throws IOException
	{
		Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		Registration r = new Registration();
		r.setAncestorPage(((Node) event.getSource()).getParent());
		r.setAncestorScene(((Node) event.getSource()).getScene());

		
		primaryStage.setScene(r.getScene());
		primaryStage.show();
		
	}
	
	public void help(ActionEvent event)
	{
		Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		HelpPanel hp = new HelpPanel();
		hp.setAncestorPage(((Node) event.getSource()).getParent());
		hp.setAncestorScene(((Node) event.getSource()).getScene());

		primaryStage.setScene(hp.getScene());
		primaryStage.show();
	}
	
	public void exit(ActionEvent event) throws IOException
	{
		
		System.exit(0);
	}
	

	
	

	
	
	
	
}
