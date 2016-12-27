package model;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import controler.Controller;
import controler.MainController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import mainClasses.*;

public class Main extends Application {

	public static String time;
	public static String date;

	static boolean develop = false;

	public static String Sdevelop = "";
	public static String image;
	static MainController mainController;
	private static Controller actualController;
	
	private static boolean appUserExist = false;
	private static AppUser appUser = null;
	static Client client = null;
	private static Parent root = null;
	private static Scene scene = null;
	private static Stage stage = null;

	@Override
	public void start(Stage primaryStage) throws IOException {

		stage = primaryStage;

		image = "view/tweed.jpg";
		if (develop) {
			Sdevelop = "../view/";
		} else {
			Sdevelop = "/view/";

		}

		Main.client = new Client("192.168.43.242", 5001);
		Main.client.start();

		javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader();
		System.out.println(path());
		System.out.println(Sdevelop+"MainPanel.fxml");
		root = loader.load(getClass().getResource(Sdevelop + "MainPanel.fxml").openStream());

		root.setStyle("-fx-background-image: url(" + image + ")");
		mainController = loader.getController();
		client.setScreenController(mainController);

		scene = new Scene(root);

		scene.getStylesheets().add(getClass().getResource(Sdevelop + "application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				if (client != null)
					client.stopAllTasks();
				Platform.exit();
			}
		});
	}

	public static void main(String[] args) {
		launch(args);

	}

	public static Client getClient() {
		return client;
	}

	public static Parent getRoot() {
		return root;
	}

	public static Scene getScene() {
		return scene;
	}

	public String path() {
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		return s;
	}

	public static AppUser getAppUser() {
		return appUser;
	}

	public static void setAppUser(AppUser appUser) {
		Main.appUser = appUser;
		if (Main.appUser == null) {
			Main.appUserExist = false;
		} else {
			Main.appUserExist = true;
		}

	}

	public static boolean isAppUserExist() {
		return appUserExist;
	}

	public void setAppUserExist(boolean appUserExist) {
		Main.appUserExist = appUserExist;
	}

	public static MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainnController) {
		mainController = mainnController;
	}

	public static Stage getStage() {
		return stage;
	}

	public static Controller getActualController() {
		return actualController;
	}

	public static void setActualController(Controller actualController) {
		Main.actualController = actualController;
	}

}
