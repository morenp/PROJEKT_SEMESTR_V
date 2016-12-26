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
    	
    	System.out.println("JESTEM klasa : " + Main.getActualController());
    	if(Main.getActualController() instanceof LoginController)
    	{
    		user.createAppUser(Main.getMainController().getLoginController().getLogin().getResp());
    		System.out.println("A1");
    	}
    	else if(Main.getActualController() instanceof RegistrationController)
    	{
    		user.createAppUser(Main.getMainController().getRegistrationController().getAppUser());
    		System.out.println("A2");
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
