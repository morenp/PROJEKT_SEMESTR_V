package model;

import java.io.IOException;

import controler.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Panel {

	private Parent root = null;
	private Scene scene = null;
	private Parent ancestorPage = null;
	private Scene ancestorScene = null;
	private MainController mc;

	public Panel(String PanelName, MainController mc) {

		try {
			root = FXMLLoader.load(getClass().getResource(Main.Sdevelop + PanelName + "Panel.fxml"));
			// System.out.println(root);
			root.setStyle("-fx-background-image: url(" + Main.image + ")");
			setMc(mc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource(Main.Sdevelop + "application.css").toExternalForm());
	}

	public Scene getScene() {
		return scene;
	}

	public MainController getMc() {
		return mc;
	}

	public void setMc(MainController mc) {
		this.mc = mc;
	}

	// ----------------- ANCESTOR ----------------------------------------------
	public Parent getAncestorPage() {
		return ancestorPage;
	}

	public void setAncestorPage(Parent ancestorPage) {
		this.ancestorPage = ancestorPage;
	}

	public Scene getAncestorScene() {
		return ancestorScene;
	}

	public void setAncestorScene(Scene ancestorScene) {
		this.ancestorScene = ancestorScene;
	}
	// -------------------------------------------------------------------------

}
