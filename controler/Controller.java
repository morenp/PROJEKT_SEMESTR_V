package controler;

import java.io.IOException;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Main;
import observe.Observer;

/** Klasa nadrzedna po której dziedzicz¹ wszystkie kontrolery */
public class Controller {

	@FXML
	private Label lblTime;
	@FXML
	private Label lblDate;

	private Parent root = null;
	private Stage primaryStage = null;
	private Scene scene = null;
	private Scene ancestorScene = null;
	private Controller ancestorController = null;
	private PauseTransition pause = new PauseTransition(javafx.util.Duration.millis(10));
	private MainController ParentController;
	private Controller controller;

	FXMLLoader loader;

	/**
	 * @param event
	 */
	public void backToMainMenu(ActionEvent event) {
		pause.stop();
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(Main.getScene());
		primaryStage.show();
	}

	
	/**
	 * @param event
	 */
	public void back(ActionEvent event) {
		pause.stop();
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(ancestorScene);
		primaryStage.show();
	}

	public void refreshView() {
		Stage primaryStage = Main.getStage();
		primaryStage.setScene(getScene());
		primaryStage.show();
		System.out.println("CLASS: " + ancestorController.getClass());
	}

	@FXML
	void initialize() {

		pause.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setTime();
				setDate();
				pause.setDuration(Duration.seconds(1));
				pause.play();
			}

		});
		pause.play();
	}

	public Controller createView(String PanelName, ActionEvent event, Controller ancestor) {
		primaryStage = Main.getStage();
		setParentController(Main.getMainController());
		loader = new javafx.fxml.FXMLLoader();

		try {
			root = loader.load(getClass().getResource(Main.Sdevelop + PanelName + "Panel.fxml").openStream());
			root.setStyle("-fx-background-image: url(" + Main.image + ")");
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(Main.Sdevelop + "application.css").toExternalForm());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		controller = loader.getController();

		controller.setAncestorScene(((Node) event.getSource()).getScene());
		primaryStage.setScene(scene);
		primaryStage.show();
		controller.setAncestorController(ancestor);

		return controller;
	}

	private void setTime() {
		lblTime.setText(Main.time);
	}

	private void setDate() {
		lblDate.setText(Main.date);
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Scene getAncestorScene() {
		return ancestorScene;
	}

	public void setAncestorScene(Scene ancestorScene) {
		this.ancestorScene = ancestorScene;
	}

	public void setAncestorController(Controller controller) {
		ancestorController = controller;
	}

	public Controller getController() {
		return controller;
	}
	
	public MainController getMainController() {
		return ParentController;
	}
	// INTERNAL METHODS 
	
	public void setParentController(MainController parent) {
		ParentController = parent;
	}
	
}
