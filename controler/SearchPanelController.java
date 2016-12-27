package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.Search;

public class SearchPanelController extends Controller {


	@FXML private Text txtWelcomeText;
	@FXML private Button btnBack;
    @FXML private Search search ;
    

    @FXML 
    void initialize()
    {
    	super.initialize();
    }
    
  public void back(ActionEvent event)
  {	
       super.back(event);
  }
   	
}
