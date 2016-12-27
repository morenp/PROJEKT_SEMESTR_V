package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import mainClasses.AppUser;
import model.Main;
import model.Registration;

/** Obsluguje proces rejestracji */
public class RegistrationController extends Controller {

	@FXML
	private Text txtWelcomeText;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtLastName;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtAddress;
	@FXML
	private PasswordField txtPassword1;
	@FXML
	private TextField txtPhoneNumber;
	@FXML
	private Button btnRegistration;
	@FXML
	private Button btnBack;
	@FXML
	private Label lblTime;
	@FXML
	private Label lblDate;
	@FXML
	private PasswordField txtPassword2;
	@FXML
	private Label lblName;
	@FXML
	private Label lblLastName;
	@FXML
	private Label lblPassword;
	@FXML
	private Label lblEmail;
	@FXML
	private Label lblAddress;
	@FXML
	private Label lblPhoneNumber;
	
	private Registration registration;
	
	@FXML
	void initialize() {
		Main.setActualController(this);
		registration = new Registration();
		
	}

	public void back(ActionEvent event) {
	    super.back(event);
	}

	@FXML
	public void register(ActionEvent event) 
{

		boolean nameOK = false;
		boolean lastNameOK = false;
		boolean passwordOK = false;
		boolean emailOK = false;
		boolean addressOK = false;
		boolean phoneNumberOK = false;
		
		int nameStatus = 0;
		int lastNameStatus = 0;
		int passwordStatus = 0;
		int emailStatus = 0;
		int addressStatus = 0;
		int phoneNumberStatus = 0;
		
	
	
// *************** NAME VALIDATION *************************************************
		nameStatus = registration.setName(txtName.getText());
		switch(nameStatus)
		{
			case 1:
			{
				nameOK = true;
				lblName.setText("");
				break;
			}
			case -1:
			{
				lblName.setTextFill(Color.web("#ff0033"));
				lblName.setText("Podaj swoje imie!");
				break;
			}
		}
		
// *************** LASTNAME VALIDATION *************************************************
		lastNameStatus = registration.setLastName(txtLastName.getText());
		switch(lastNameStatus)
		{
			case 1:
			{
				lastNameOK = true;
				lblLastName.setText("");
				break;
			}
			case -1:
			{
				lblLastName.setTextFill(Color.web("#ff0033"));
				lblLastName.setText("Podaj swoje nazwisko!");
				break;
			}
		}
				
// *************** PASSWORD VALIDATION *************************************************
		passwordStatus = registration.setPassword(txtPassword1.getText(), txtPassword2.getText());	
		switch(passwordStatus)
		{		
			case 1:
			{
				passwordOK=true;
				lblPassword.setTextFill(Color.LIME);
				lblPassword.setText("Poprawnie wprowadzono has³o");
				break;	
			}
			case -1:
			{
				lblPassword.setTextFill(Color.web("#ff0033"));
				lblPassword.setText("Hasla musza byc identyczne!");
				break;
			}
			case -2:
			{
				lblPassword.setTextFill(Color.web("#ff0033"));
				lblPassword.setText("Haslo musi mieæ od 8 do 30 znaków!");
				break;
			}
		}
// *************** EMAIL VALIDATION  *************************************************
		
		emailStatus = registration.setEmail(txtEmail.getText());
		switch(emailStatus)
		{
			case 1:
			{
				emailOK = true;
				lblEmail.setTextFill(Color.LIME);
				lblEmail.setText("Poprawny adres email");
				break;
			}
			case -1:
			{
				lblEmail.setTextFill(Color.web("#ff0033"));
				lblEmail.setText("Podaj poprawny adres email!");
				break;
			}
			case -2:
			{
				lblEmail.setTextFill(Color.web("#ff0033"));
				lblEmail.setText("Ten mail jest juz zarejestrowany!");
				break;
			}
		}
// *************** ADDRESS VALIDATION *************************************************
		addressStatus = registration.setAddress(txtAddress.getText());
		switch(addressStatus)
		{
			case 1:
			{
				addressOK = true;
				lblAddress.setText("");
				break;
			}
			case -1:
			{
				lblAddress.setTextFill(Color.web("#ff0033"));
				lblAddress.setText("Podaj swoje adres!");
				break;
			}
		}
				
// *************** PHONENUMBER VALIDATION *************************************************
		phoneNumberStatus = registration.setPhoneNumber(txtPhoneNumber.getText());
		switch(phoneNumberStatus)
		{
			case 1:
			{
				phoneNumberOK = true;
				lblPhoneNumber.setText("");
				break;
			}
			case -1:
			{
				lblPhoneNumber.setTextFill(Color.web("#ff0033"));
				lblPhoneNumber.setText("Podaj numer telefonu!");
				break;
			}
		}	
		
//************************************************************************************

		if(nameOK && lastNameOK && passwordOK && emailOK && addressOK && phoneNumberOK)
		{
			if(registration.register())
			{
				UserPanelController userPanelController =(UserPanelController) createView("User",event,this);
				Main.getMainController().setUserPanelController(userPanelController);
				System.out.println("Rejestracja przebiegla pomyslnie!");
			}
			else
			{
				System.out.println("Rejestracja nie powiodla sie!");
			}
		}
		
	}
	
	public AppUser getAppUser() {
		return registration.getAppUser();
	}
}