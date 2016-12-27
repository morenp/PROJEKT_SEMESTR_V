import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.sql.SQLException;

import database.DatabaseConnection;
import database.DatabaseQuery;

public class ServerTCPThread extends Thread {
	String separator = "@@";
	Socket mySocket;
	private BufferedReader in; // strumienie gniazda
	private PrintWriter out; // komunikacji z klientem
	private DatabaseConnection oracle; // po³¹czenie z baz¹ danych
	private DatabaseQuery dq = new DatabaseQuery();
	private String IP ;
	public ServerTCPThread(Socket socket) {
		super(); // konstruktor klasy Thread
		mySocket = socket;
		IP = socket.getInetAddress().getHostAddress();
		
	}

	public void run() // program w¹tku
	{
		try {

			in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
			out = new PrintWriter(mySocket.getOutputStream(), true);
			
			System.out.println("Connected Client IP: " + IP);
			System.out.println("Connection established");
			oracle = new DatabaseConnection("127.0.0.1", "1521", "railway", "qwerty");
			oracle.connect();
			

			// obs³uga ¿¹dania
			while (true) {
				serviceRequest();
			}

		} catch (SocketException e) {
			System.out.println("Uzytkownik zakonczyl polaczenie z serwerem");
		} catch (Exception e) {

			System.err.println(e);
		} finally {
			try {
				mySocket.close();
				System.out.println("Connection closed User IP : " + IP );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			oracle.disconnect();
		}
	}

	// metoda obs³ugi ¿adania
	private void serviceRequest() throws IOException 
	{
		Datagram d = new Datagram(); // Utworzenie datagramu
		
		String query = "";
		query = in.readLine(); // Odczytanie danych 
		query =d.unpack(query); // rozpakowanie danych z formy datagramu 
		System.out.println("Polecenie odebrane przez serwer : " + query);
		
		
		
		String[] data = query.split(separator);
		String command = data[0];
		String dane="";
		
		switch(command)
		{
			case "execute":
			{
				int id = Integer.parseInt(data[1]);
				String name = data[2];
				String lastName = data[3];
				String address = data[4];
				String phoneNumber = data[5];
	
				try {
					oracle.executeUserProfileUpdate(id, name, lastName, address, phoneNumber);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("error in serverTCPThread executeUserProfileUpdate");
				}
				break;
			}
			case "createUser":
			{
				String name = data[1];
				String lastName = data[2];
				String address = data[3];
				String phoneNumber = data[4];
				String email = data[5];
				String password = data[6];
				
				try {
					System.out.println("WSTAWIAM usera");
					oracle.executeUserInsert( name, lastName, address, phoneNumber, email, password);
					dane = "create_complited";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("error in serverTCPThread executeUserInsert");
				}
				break;
				
			}
			case "check":
			{				
				String email = data[1];
				query = dq.getEmailExistingQuery(email);
				dane = oracle.executeQuery(query);
				System.out.println("DANE");
				break;
			}	
			
			
			case "valid":		
			{
				String password = data[2];
				String parametr = data[3];
				query = "SELECT u.email from users u where u.email = " + "\'" + data[1] + "\'";

				// Pobranie adresu email z bazy
				String email = oracle.executeQuery(query);
				System.out.println("LOGOWANIE DLA MAILA : " + email);
 
				System.out.println("Porownanie " + email +"::" + data[1]);
				if (email.equals(data[1])) 
				{
					
					query = "SELECT u.password from users u where u.email = " + "\'" + data[1] + "\'";
					String passwordHash = oracle.executeQuery(query);
					System.out.println("Password hash: " + passwordHash);
					
					
					try {
						if(PasswordHash.check(password, passwordHash))
						{
							query = dq.getUserQuery(email, password, parametr);
							dane = oracle.executeQuery(query);
							System.out.println("Server dane : " + dane);
						}
						else 
						{
						  dane = "wrong_password";
						  System.out.println("wrong_password  + g:" + email);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} 
				else 
				{
					if (email.equals("")) 
					{
						dane = "not_exist";
						System.out.println("not_exist");
					}
				}
				break;
			}
			
			
			
			
		}		
		
		
			Datagram datagram = new Datagram();
			datagram.create(dane);
			System.out.println("SERWER wysyla : " +  datagram.toString());
			out.println(datagram.toString());
		
		
	}
}