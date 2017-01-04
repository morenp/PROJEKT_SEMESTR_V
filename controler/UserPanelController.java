package controler;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Main;
import model.User;
import observe.Observer;


public class UserPanelController extends Controller implements Observer{


	@FXML private Label lblNames;
    @FXML private Button btnLogOut;
    @FXML private Button btnMyProfile;
    @FXML private User user;

    @FXML private UserProfilePanelController userProfilePanelController;
 
 
// **************** INTERNAL METHODS *****************************************************
       
    
    
    
    @FXML
    void initialize()
    {  
    	user= new User(this);
 
    	// Jesli aktualnie obslugujacy kontroler jest instancja klasu login kontroler uzytkownik jest logowany
    	// na podstawie odpowiedzi z serwera 
    	if(Main.getActualController() instanceof LoginController)
    	{
    		user.createAppUser(Main.getMainController().getLoginController().getLogin().getResp());
    	}
    	
    	//Jesli aktualnie obslugujacy kontroler jest instancja klasy RegistrationController wtedy oznaczato
    	//ze uzytkownik ma zostac zalogowany odrazu po rejestracji
    	else if(Main.getActualController() instanceof RegistrationController)
    	{
    		user.createAppUser(Main.getMainController().getRegistrationController().getAppUser());
    	}
    }
    
    public void logOut(ActionEvent event)
    {
    	Main.setAppUser(null);
        super.backToMainMenu(event);
    }    
    
    public void myProfile(ActionEvent event)
    {
    	userProfilePanelController = (UserProfilePanelController) createView("UserProfile",event,this); 	
    }

	@Override
	public void update() 
	{
		lblNames.setText(user.getAppUser().getName() +" " + user.getAppUser().getSecondName() );		      			
	}

	public User getUser() {
		return user;
	}
	
	
}
