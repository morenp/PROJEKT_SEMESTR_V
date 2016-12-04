package controler;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Help;
import model.Information;
import model.Login;
import model.Panel;
import model.Registration;
import model.Search;
import model.Timetable;



public class MainController {

    static Panel hp;
    static Login l;
    static Search s;
    static Registration r;
    static Timetable tt;
    static Information i;
    
    
	
	@FXML
	private Button btnLogIn;
	
	@FXML
	private Button btnRegister;
	
	@FXML
	private  Button btnSearch;
	
	@FXML
	private  Button btnTimetable;
	
	@FXML
	private  Button btnInformation;
	
	@FXML
	private  Button btnHelp;
	
	@FXML
	private Button btnExit;
	

	public void login(ActionEvent event) throws IOException
	{
		l = new Login();
		buttonControl(l,event);
		
	}
	
	public void register(ActionEvent event) throws IOException
	{
		r = new Registration();
		buttonControl(r,event);
		
	}
	
	public void search(ActionEvent event)
	{
		s = new Search();
		buttonControl(s,event);
	}
	
	public void timetable(ActionEvent event)
	{
		tt = new Timetable(); 
		buttonControl(tt,event);
	}
	
	
	public void information(ActionEvent event)
	{
		i = new Information(); 
		buttonControl(i,event);
	}
	
	public void help(ActionEvent event)
	{
		hp = new Help();
		buttonControl(hp,event);
	}
	
	public void exit(ActionEvent event) throws IOException
	{
		
		System.exit(0);
	}
	
	
	
	// Internal methods
	private void buttonControl(Panel panel, ActionEvent event)
	{
		Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		panel.setAncestorPage(((Node) event.getSource()).getParent());
		panel.setAncestorScene(((Node) event.getSource()).getScene());
		
		primaryStage.setScene(panel.getScene());
		primaryStage.show();
	}



	
	

	
	
	
	
}
