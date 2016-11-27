package model;

import java.io.IOException;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Login {

	private  Parent root = null;
	private  Scene scene = null;
	private  static Parent ancestorPage = null;
	private  static Scene ancestorScene = null;
	
	public Login()
	{
			try {
				root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
	}

	public Scene getScene()
	{
		return scene;
	}
	
//----------------- ANCESTOR ----------------------------------------------
	public static Parent getAncestorPage() {
		return ancestorPage;
	}

	public void setAncestorPage(Parent ancestorPage) {
		Login.ancestorPage = ancestorPage;
	}

	public static Scene getAncestorScene() {
		return ancestorScene;
	}

	public void setAncestorScene(Scene ancestorScene) {
		Login.ancestorScene = ancestorScene;
	}
//-------------------------------------------------------------------------	

}