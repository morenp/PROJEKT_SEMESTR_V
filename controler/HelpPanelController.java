package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.Help;


public class HelpPanelController extends Controller {


	@FXML private Button btnBack;
    @FXML private Text txtWelcomeText;
    @FXML private Help help;

    public void back(ActionEvent event)
    {	
         super.back(event);
    }

}
