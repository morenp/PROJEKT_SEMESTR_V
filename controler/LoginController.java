package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Login;
import model.Main;

/** Obsluguje proces logowania */
public class LoginController extends Controller {


	@FXML private Login login;

	@FXML private Label lblTime;
    @FXML private Label lblDate;
    @FXML private Label lblStatus;
	@FXML private Text txtWelcomeText;
	@FXML private TextField txtUserName;
	@FXML private TextField txtPassword;
	@FXML private Button btnBack;
	@FXML private Button btnLogIn;
	
	
	@FXML 
    void initialize()
	{
		//Main.getMainController().setLoginController(this);
		Main.setActualController(this);
		login = new Login();
	}
	
    public void back(ActionEvent event)
    {	
         super.back(event);
    }
	
	public void login(ActionEvent event)
	{
	
		
		String email = txtUserName.getText();
    	String password = txtPassword.getText();
		
		int loginStatus = login.login(email, password);
		
		switch(loginStatus)
		{
		
			case 1:
			{
				lblStatus.setText("Login Success");
				
				if(login.getUser().getAppUser().getStatus().equals("user"))
				{
					UserPanelController userPanelController =(UserPanelController) createView("User",event,this);
					super.getMainController().setUserPanelController(userPanelController);	
				}
				else if(login.getUser().getAppUser().getStatus().equals("admin"))
				{
					// Miejsce na utwozenie kontrolera odpowiedzialnego za panel administratora
					System.out.println("Tworze panel administratora");
				}

				break;
			}
			
			
			
			case -1:
			{
				lblStatus.setText("Uzytkownik o podanym adresie email nie istnieje");
				break;
			}
			case -2:
			{
				lblStatus.setText("Bledny adres email!");
				break;
			}
			
			
			case -3:
			{
				lblStatus.setText("Bledne haslo!");	 
				break;
			}
			
			case -4:
			{
				lblStatus.setText("Nie podano hasla!");	
				break;
			}
		
		}
    	
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}

