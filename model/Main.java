package model;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import mainClasses.*;




public class Main extends Application {
	
	
	private static User user = null;
	static Client client = null;
	private static Parent root = null;
	private static Scene scene = null;
	

	 //static Server server = null;
	
	@Override
	public void start(Stage primaryStage) throws IOException {

			
		//	server = new Server();
		//	server.setDaemon(true); // proces jako daemon
		//	server.start();
			
			Main.client = new Client("127.0.0.1",5001);
			Main.client.start();
			
			root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			primaryStage.setResizable(false); // wy��czenie mo�liwo�ci maksymalizacji okna
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

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		Main.user = user;
	}
}