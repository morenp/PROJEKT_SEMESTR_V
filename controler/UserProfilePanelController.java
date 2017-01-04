package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import mainClasses.AppUser;
import model.Main;
import model.UserProfile;
import observe.Observer;

public class UserProfilePanelController extends Controller implements Observer{

	@FXML private UserProfile userProfile;	
	@FXML private Button btnEdit;
    @FXML private Button btnCommit;
    @FXML private Button btnBack;
    @FXML private Text txtWelcomeText;
    @FXML private TextField txtName;
    @FXML private TextField txtSecondName;
    @FXML private TextField txtAddress;
    @FXML private TextField txtPhoneNumber;
    @FXML private TextField txtEmail;
    @FXML private Label lblProcess;
    @FXML private Label lblName;
    @FXML private Label lblSecondName;
    
    @FXML
    void initialize()
    {
    	super.initialize();
    	userProfile = new UserProfile(this);
    	Main.getMainController().setUserProfilePanelController(this);
    	Main.getMainController().getUserPanelController().getUser().addObserver(this);
    	update();
    }
    
    public void commit(ActionEvent event)
    {
    	//POWROT DO OPCJI WYLACZONEJ EDYCJI
    	txtEmail.setDisable(false);
    	
    	//USTAWIENIE POL TEKSTOWYCH
    	userProfile.change(txtName.getText(),txtSecondName.getText(),txtAddress.getText(),txtPhoneNumber.getText());
    	

    	
    	// POINFORMOWANIE OBSERWATOROW O ZAISTNIALEJ ZMIANIE
    	Main.getMainController().getUserPanelController().getUser().informObservers();
    	
    	// ZATWIERDZENIE ZAMIAN W BAZIE DANYCH
    	AppUser appUser = Main.getMainController().getUserPanelController().getUser().getAppUser();
    	
    	String status = Main.getClient().executeUserProfileUpdate(appUser);	
    	// USTWAIENIE LABELA INFORMUJACEGO
    	
    	if(status.equals("update_complited"))
        	lblProcess.setText("Zmiana danych przebiegla pomyslnie!");
    	else
        	lblProcess.setText("Zmiana danych nie powiodla sie!");	
    }
    
    public void edit(ActionEvent event)
    {   	
    	txtName.setEditable(true);
    	txtSecondName.setEditable(true);
    	txtAddress.setEditable(true);
    	txtPhoneNumber.setEditable(true);
    	txtEmail.setDisable(true);    	 	
    }
    
    public void back(ActionEvent event)
    {	
         super.back(event);
    }
//******************** GETTERS AND SETTERS ******************************
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public void update() 
	{	
    	txtName.setText(userProfile.getAppUser().getName());
    	txtSecondName.setText(userProfile.getAppUser().getSecondName());
    	txtAddress.setText(userProfile.getAppUser().getAddress());
    	txtPhoneNumber.setText(userProfile.getAppUser().getPhoneNumber());
    	txtEmail.setText(userProfile.getAppUser().getEmail());  
	}

    
    
    
}
