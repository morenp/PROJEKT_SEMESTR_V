package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	private String databaseIP;
	private String databasePort;
	private String databaseUser;
	private String databasePassword;
	private Connection conn;
	
	public DatabaseConnection(String databaseIP, String databasePort, String databaseUser, String databasePassword) 
	{
		super();
		this.databaseIP = databaseIP;
		this.databasePort = databasePort;
		this.databaseUser = databaseUser;
		this.databasePassword = databasePassword;
	}

	public void connect() // Metoda tworz¹ca po³¹czenie z baz¹ danych
	{
		try
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Sterowniki za³adowane!");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@"+databaseIP+":"+databasePort+":orcl",databaseUser,databasePassword);
			System.out.println("Po³¹czenie nawi¹zane\n");
			
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void disconnect()
	{
		try {
			conn.close();
			System.out.println("Roz³¹czono z baz¹ danych!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String executeQuery(String query)
	{
		Statement a;
		String answer = "";
		
		try {
			
			a = conn.createStatement();
			System.out.println("KWERENDA : "+ query);
			ResultSet res = a.executeQuery(query);
			int i=1;
			String tmp;
			while(res.next())
			{	
				answer += res.getString(i);	
				i++;
			}
			answer +="\n__END__";
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return answer;
	}
}
