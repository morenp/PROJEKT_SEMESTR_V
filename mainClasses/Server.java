package mainClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


import database.*;



public class Server {

	private String host = "127.0.0.1";
    private int port = 5001;
    private InetSocketAddress isa ;
	private ServerSocket serverSocket;
	private boolean serverIsRunning;
	private Socket conn; // gniazdo 
	private BufferedReader in; // strumienie gniazda
	private PrintWriter out;    // komunikacji z klientem
	
	public static void main(String args[])
	{
		System.out.println("HELLO");
		//Server s = new Server();
		//s.run();
	}
	
	public Server() {
		super();
		serverIsRunning = false;
	}

	public void run()
	{
		
		
		isa = new InetSocketAddress(host,port);
		
		// Utworzenie gniazda serwera
		try 
		{
			serverSocket = new ServerSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Zwi¹zanie gniazda serwera z adresem hostu i portu 
		try 
		{
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
				
				in = new BufferedReader(
						 new InputStreamReader(
								 conn.getInputStream()));
				out = new PrintWriter(
						  conn.getOutputStream(),true);
				
				serviceRequest();
				
			
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}		
		}	
		if(!serverIsRunning)
		{
			System.out.println("Sewer zakoñczy³ pracê!");
		}
	}

	
	private void serviceRequest() throws IOException
	{
		out.println("Welcome on server!");
		out.println("Connection established");
		
		// TODO Auto-generated method stub
		DatabaseConnection oracle = new DatabaseConnection("127.0.0.1","1521","railway","qwerty");

		System.out.println("rozpoczynam");
		String tmp="";; 
		String query="";
		
		oracle.connect();
		while((tmp=in.readLine())!=null)
		{
					query+=tmp;
		}
		System.out.println(query);
		writeResp(oracle.executeQuery(query));
		oracle.disconnect();	
	}
	
	private void writeResp(String content)
	{
		out.println(content);
	}
		
}
