package mainClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread implements Runnable
{
	private String host;
	private int port;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public Client(String host, int port)
	{
		this.host=host;
		this.port=port;
		socket = new Socket();
	}
	public void run()
	{
		//query = "SELECT name from users where user_id = 1";
		try 
		{
			// Utworzenie adresów
		      InetAddress inetadr = InetAddress.getByName(host);
		      InetSocketAddress conadr = new InetSocketAddress(inetadr, port);
		      socket.connect(conadr);
			
		    // Pobranie strumienia wejœciowego gniazda
		    // Nak³adamy dekodowanie i buforowanie
		      in = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
		      out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
		      
		   // Okreslenie maksymalnego czasu oczekiwania na odczyt danych z serwera
		     // socket.setSoTimeout(500);	      		     		    
		}
		catch(ConnectException e )
		{
			System.out.println("Serwer jest wy³¹czony!");
		}
		catch (UnknownHostException exc) 
		{
	        System.out.println("Nieznany host: " + host);
	    }
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	//Zakoñczenie po³¹czenia z serwerem 
	public void close()
	{
		  // Zamkniêcie strumienia i gniazda
	      try {
			in.close();
			 socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}
	// Wyszukanie w bazie danych 		
	public String doSearch(String query)
	{
		String resp = "";
		String tmp = "";
		out.println(query);
		
		
		while (tmp != "__end__" )
		{
			try {
				tmp = in.readLine();
				if(!tmp.equals("__end__"))
				resp += tmp;
				else
				{
					break;
				}
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return resp;
	}

	public String login(String email, String password)
	{
		out.println("valid " + email + " " +password);
		
		String resp="";
		String tmp="";
		while (!tmp.equals("__END__"))
		{
			System.out.println("odczytuje");
			try {
				tmp = in.readLine();
				System.out.println(tmp);
				if(!tmp.equals("__END__"))
				resp += tmp;
				else
				{
					break;
				}
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Poza while");
	return resp;
	}
	
	
}
