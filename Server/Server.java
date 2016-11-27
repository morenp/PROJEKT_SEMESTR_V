
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import database.*;




public class Server {

	private String host = "127.0.0.1";
    private int port = 5001;
    private InetSocketAddress isa ;
	private ServerSocket serverSocket; 
	private boolean serverIsRunning; // flaga dzia³ania servera
	private Socket conn; // gniazdo 
	private BufferedReader in; // strumienie gniazda
	private PrintWriter out;    // komunikacji z klientem
	private DatabaseConnection oracle; // po³¹czenie z baz¹ danych
	
	public static void main(String args[])
	{
		Server s = new Server();
		s.run();
	}
	
	public Server() {
		super();
		serverIsRunning = false;
	}

	public void run()
	{
		isa = new InetSocketAddress(host,port);	
		try 
		{
			// Utworzenie gniazda serwera
			serverSocket = new ServerSocket();
			// Zwi¹zanie gniazda serwera z adresem hostu i portu 
			serverSocket.bind(isa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		serverIsRunning = true;
		System.out.println("Serwer started!");
		System.out.println("at port: " + serverSocket.getLocalPort());
		System.out.println("bind address: " + serverSocket.getInetAddress());
		
		while(serverIsRunning)
		{
			// akceptacja po³¹czenia
			// utworzenie gniazda komunikacji z po³¹czonym klientem 
			try 
			{
				conn = serverSocket.accept();
				
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				out = new PrintWriter(conn.getOutputStream(),true);
				
				System.out.println("Welcome on server!");
				System.out.println("Connection established");
				oracle = new DatabaseConnection("127.0.0.1","1521","railway","qwerty");
				oracle.connect();
				// obs³uga ¿¹dania
				while(true)
				{
					serviceRequest();
				}
			} 
			catch(SocketException e)
			{
				System.out.println("Roz³¹czono z serwerem");
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				oracle.disconnect();
			}
		}	
		if(!serverIsRunning)
		{
			System.out.println("Sewer zakoñczy³ pracê!");
		}
	}
	
	// metoda obs³ugi ¿adania
	private void serviceRequest() throws IOException
	{
		
		String tmp="";; 
		String query="";
		while((tmp=in.readLine())!=null)
		{
					query+=tmp;
					if(query!="")
						break;
		}
		
		String[] info = query.split(" ");
		System.out.println(info[0]);
		System.out.println(info[1]);
		System.out.println(info[2]);
		
		
		
		
		if(info[0].equals("valid"))
		{
			query="SELECT u.email from users u where u.email = "+"\'"+info[1]+"\'";
			
			
			String email = oracle.executeQuery(query);
			System.out.println("HERE:"+email);
			
			
			if(email.equals(info[1]+"\n__END__"))
			{
				query = "SELECT XMLELEMENT(\"name\",name) || XMLELEMENT(\"last_name\",last_name) as xml_users from users u where u.email = "+"\'"+info[1]+"\'"+"AND u.password = "+ "\'"+info[2]+"\'";                   ;
				String dane = oracle.executeQuery(query);
				
				if(dane.equals("\n__END__") )
				{
					out.println("wrong_password"+"\n__END__");
					System.out.println("wrong_password  + g:"+email + "jj");
				}
				else
				{	
					out.printf(dane+"\n__END__");
				}
			}
			else
			{
				if(email.equals("\n__END__"))
				{
					out.println("not_exist"+"\n__END__");
					System.out.println("not_exist");
				}
			}
		}
		else
		{
			String result = oracle.executeQuery(query);
			System.out.println("Zwrocono:" + result);
			out.println(result+"\n__END__");
			
		}	
	}
	
	
}