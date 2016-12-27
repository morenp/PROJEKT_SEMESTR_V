package database;
import java.sql.CallableStatement;
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
	private DatabaseQuery dq;

	
	public Connection getConn() {
		return conn;
	}

	public DatabaseConnection(String databaseIP, String databasePort, String databaseUser, String databasePassword) 
	{
		super();
		
		this.databaseIP = databaseIP;
		this.databasePort = databasePort;
		this.databaseUser = databaseUser;
		this.databasePassword = databasePassword;
		dq = new DatabaseQuery();
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
		
		String answer = "";
		
		try {
			
			Statement a = conn.createStatement();		
			ResultSet res = a.executeQuery(query);
			
			int i=1;
			while(res.next())
			{	
				answer += res.getString(i);	
				i++;
			}
			//answer +="\n__END__";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return answer;
	}

	public String executeUserProfileUpdate(int id, String name, String lastName, String address, String phoneNumber ) throws SQLException {
		CallableStatement cstmt = null;
		try {
			
			
			cstmt = conn.prepareCall(dq.getUserUpdateQuery());
			cstmt.setInt(1, id);
			cstmt.setString(2,name);
			cstmt.setString(3,lastName);
			cstmt.setString(4,address);
			cstmt.setString(5,phoneNumber);
			cstmt.execute();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			cstmt.close();
		}
		
		return null;
	}
	
	public String executeUserInsert(String name, String lastName, String address, String phoneNumber, String email, String password ) throws SQLException {
		CallableStatement cstmt = null;
		try {
						
			cstmt = conn.prepareCall(dq.getUserInsertQuery());
			System.out.println("Wykonuje insssert" );
			cstmt.setString(1,name);
			cstmt.setString(2,lastName);
			cstmt.setString(3,email);
			cstmt.setString(4,password);
			cstmt.setString(5,address);
			cstmt.setString(6,phoneNumber);

			cstmt.execute();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			cstmt.close();
		}
		
		return null;
	}
	
	
}
