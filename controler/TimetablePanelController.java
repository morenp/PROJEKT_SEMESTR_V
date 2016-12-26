package controler;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.Timetable;

public class TimetablePanelController extends Controller {


	@FXML private Text txtWelcomeText;
	@FXML private Button btnBack;
	@FXML private Timetable timetable;
      
    public void back(ActionEvent event)
    {	
         super.back(event);
    }
	
}
