package controler;

import java.io.IOException;
import java.time.ZonedDateTime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Main;

public class MainController extends Controller {

	@FXML
	private HelpPanelController helpPanelController;
	@FXML
	private TimetablePanelController timetablePanelController;
	@FXML
	private InformationPanelController informationPanelController;
	@FXML
	private SearchPanelController searchPanelController;
	@FXML
	private RegistrationController registrationController;
	@FXML
	private UserPanelController userPanelController;
	@FXML
	private LoginController loginController;
	@FXML
	private UserProfilePanelController userProfilePanelController;

	@FXML
	private Button btnLogIn;
	@FXML
	private Button btnRegister;
	@FXML
	private Button btnSearch;
	@FXML
	private Button btnTimetable;
	@FXML
	private Button btnInformation;
	@FXML
	private Button btnHelp;
	@FXML
	private Button btnExit;

	@FXML
	private Label lblTime;
	@FXML
	private Label lblDate;

	public void login(ActionEvent event) throws IOException {
		if (isLogged()) {
			System.out.println("Jestes zalogowany");
			userPanelController.createView("User", event, this);

		} else {
			loginController = (LoginController) createView("Login", event, this);
		}

	}

	public void register(ActionEvent event) throws IOException {

		registrationController = (RegistrationController) createView("Registration", event, this);
		
	}

	public void search(ActionEvent event) {
		searchPanelController = (SearchPanelController) createView("Search", event, this);
	
	}

	public void timetable(ActionEvent event) {
		timetablePanelController = (TimetablePanelController) createView("Timetable", event, this);
		
	}

	public void information(ActionEvent event) {
		informationPanelController = (InformationPanelController) createView("Information", event, this);
	
	}

	public void help(ActionEvent event) {
		helpPanelController = (HelpPanelController) createView("Help", event, this);
	
	}

	public void exit(ActionEvent event) throws IOException {
		System.exit(0);
	}

	public void setTime() {

		ZonedDateTime zdt = ZonedDateTime.now();
		String time = String.format("%1$02d:%2$02d", zdt.getHour(), zdt.getMinute());
		lblTime.setText(time);
		Main.time = time;
		String date = zdt.getDayOfWeek() + ", " + Integer.toString(zdt.getDayOfMonth()) + " " + zdt.getMonth() + " "
				+ Integer.toString(zdt.getYear());
		lblDate.setText(date);
		Main.date = date;

	}

	public String getTime() {
		return lblTime.getText();
	}

	public String getDate() {
		return lblDate.getText();
	}

	private boolean isLogged() {
		if (Main.isAppUserExist())
			return true;
		else
			return false;
	}
	/*
	 * public Object createView(String PanelName, ActionEvent event) { Scene
	 * scene = null;
	 * 
	 * javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(); Parent
	 * root;
	 * 
	 * try { root =
	 * loader.load(getClass().getResource(Main.Sdevelop+PanelName+"Panel.fxml").
	 * openStream()); root.setStyle("-fx-background-image: url("+ Main.image
	 * +")"); scene = new Scene(root);
	 * scene.getStylesheets().add(getClass().getResource(Main.Sdevelop+
	 * "application.css").toExternalForm()); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * Controller controller = loader.getController();
	 * 
	 * Stage primaryStage = (Stage)((Node)
	 * event.getSource()).getScene().getWindow();
	 * controller.setAncestorScene(((Node) event.getSource()).getScene());
	 * primaryStage.setScene(scene); primaryStage.show();
	 * 
	 * controller.setController(this); return controller; }
	 * 
	 */

// ***************** CONTROLLERS GETTERS AND SETTERS ************************

	public HelpPanelController getHelpPanelController() {
		return helpPanelController;
	}

	public TimetablePanelController getTimetablePanelController() {
		return timetablePanelController;
	}

	public InformationPanelController getInformationPanelController() {
		return informationPanelController;
	}

	public SearchPanelController getSearchPanelController() {
		return searchPanelController;
	}

	public RegistrationController getRegistrationController() {
		return registrationController;
	}

	public UserPanelController getUserPanelController() {
		return userPanelController;
	}

	public void setUserPanelController(Controller controller) {
		userPanelController = (UserPanelController) controller;
	}

	public UserProfilePanelController getUserProfilePanelController() {
		return userProfilePanelController;
	}

	public void setUserProfilePanelController(UserProfilePanelController userProfilePanelController) {
		this.userProfilePanelController = userProfilePanelController;
	}

	public void setUserPanelController(UserPanelController userPanelController) {
		this.userPanelController = userPanelController;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

}
