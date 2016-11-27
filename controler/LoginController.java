package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainClasses.User;
import model.Login;
import model.Main;
import model.UserPanel;

import org.apache.commons.validator.routines.EmailValidator;

public class LoginController {


	//private String user = "user";
	//private String password = "pass";
	
	@FXML
	private Label lblStatus;

	@FXML
	private Text txtWelcomeText;
	
	@FXML
	private TextField txtUserName;
	
	
	@FXML
	private TextField txtPassword;
	
	@FXML
	private Button btnBack;

	public void login(ActionEvent event)
	{/*
			String query= "SELECT XMLELEMENT(\"name\",name) || XMLELEMENT(\"last_name\",last_name) as xml_users from users u where u.user_id = 1";
		    
		   
		    String email="";
		    
		    String password="";
		    
		    query = "SELECT XMLELEMENT(\"email\",email) || XMLELEMENT(\"password\",password) as xml_users from users u where u.user_email = "+email;
		    
		    
		    
		    */
		
		 	// POLE  EMAIL FORMULARZA
	    	String email = txtUserName.getText();
	    	// POLE HAS£O FORMULARZA 
	    	String password = txtPassword.getText();
	    	
	    	// Validator adresu email 
	    	EmailValidator ev = EmailValidator.getInstance();
	    	
	    	
	    	
	    	// Wys³anie do serwera danych logowania
			
			
			String resp;// = Main.client.doSearch(query);
		
			if(ev.isValid(email) && !password.equals(""))
			{
				resp = Main.getClient().login(email, password);
			    System.out.println("RESP : " + resp);
			    if(!resp.equals("wrong_password"))
			    {
			    	if(resp.equals("not_exist"))
			    	{
			    		lblStatus.setText("U¿ytkownik o podanym adresie email nie istnieje");
			    	}
			    	else		
			    	{
			    		System.out.println(resp);
			    		
			    		// Utworzenie instancji klasy user
			    		//User user = new User();
			    		//Main.setUser(user);
			    		
			    		
				    	
				        	
						lblStatus.setText("Login Success");
						System.out.println("Zalogowano");
							
						Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
								
						UserPanel up = new UserPanel();
						up.setAncestorPage(((Node) event.getSource()).getParent());
						up.setAncestorScene(((Node) event.getSource()).getScene());
		
						primaryStage.setScene(up.getScene());
						primaryStage.show();
			    	}
				}
				else
				{
					lblStatus.setText("Wrong Password");
				}	   
			}else
			{
				if(!ev.isValid(email))
					lblStatus.setText("B³êdny adres email!");
				else
					if(password.equals(""))
						lblStatus.setText("Nie podano has³a!");
				
					
			}
	}
	
	public void back(ActionEvent event)
	{	
		Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(Login.getAncestorScene());
		primaryStage.show();
	}
	
}
