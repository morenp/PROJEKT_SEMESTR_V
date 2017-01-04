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

import controler.MainController;
import javafx.application.Platform;

public class Client extends Thread implements Runnable
{
	String separator = "@@";
	private String host;
	private int port;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
    private MainController mainController;
    private Clock clock;
    private Thread clockThread;
	
	public Client(String host, int port)
	{
		this.host=host;
		this.port=port;
		socket = new Socket();
		
		// ZEGAR 
        clock = new Clock();
        clockThread = new Thread(clock);
        clockThread.start();
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
	public boolean isEmailExisting(String email)
	{
		Datagram d =new Datagram();
		d.create("check" + separator + email);
		out.println(d.toString());

		String resp = getResponse2();
		System.out.println("Sprawdzony email : " + email);
		if(resp.equals(email))
			return true;
		else
			return false;
	}

	public String executeUserProfileUpdate(AppUser appUser)
	{
		
		Datagram d =new Datagram();
		
		d.create("execute"+ separator + appUser.getUserID()
		 + separator + appUser.getName()
		 + separator + appUser.getSecondName()
		 + separator + appUser.getAddress()
		 + separator + appUser.getPhoneNumber() );
		
		out.println(d.toString());
		
		String resp = getResponse2();
		
		return resp;	
	}
	
	public String executeUserInsert(AppUser appUser)
	{
		Datagram d =new Datagram();
		d.create("createUser"
	     +  separator + appUser.getName()
		 + separator + appUser.getSecondName()
		 + separator + appUser.getAddress()
		 + separator + appUser.getPhoneNumber()
		 + separator + appUser.getEmail()
		 + separator + appUser.getPassword()
		);
		
		out.println(d.toString());
		
		String resp = getResponse2();
		return resp;
	}
	
	
	public String login(String email, String password)
	{

		Datagram d =new Datagram();
		d.create("valid" + separator + email + separator +password);
		out.println(d.toString());
		
		
		String resp = getResponse2();
		System.out.println("------------------------------------------");
		System.out.println("Odbieram w Client.java : " + resp);
		System.out.println("------------------------------------------");

		return resp;
		
	}
	
	
	private String getResponse2()
	{
		String resp="";																								
	
		try {
			resp = in.readLine();
			//in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Datagram d = new Datagram();
		resp = d.unpack(resp);
		
		
		
		return resp;
		
		
	}
	public void setScreenController(MainController controller)
    {
    	mainController = controller;
    }
	
    public class Clock implements Runnable
    {
        private boolean isRunning;
        
        public void stop()
        {
            isRunning = false;
        }
        
        @Override
        public void run() 
        {
            isRunning = true;
            
            while(isRunning)
            {
                Platform.runLater(new Runnable()
                {
                    @Override
                    public void run() 
                    {
                        mainController.setTime();
                    }
                });
                
                try
                {
                    Thread.sleep(5000);
                }
                catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }

	public void stopAllTasks() {
		clockThread.interrupt();
		this.interrupt();
		
	}
	
}
