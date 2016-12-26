package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.Information;

public class InformationPanelController extends Controller {

	@FXML
	private Button btnBack;
	@FXML
	private Text txtWelcomeText;
	@FXML
	private Information information;

	public void back(ActionEvent event) {
		System.out.println("BACK");
		super.back(event);
	}

}
