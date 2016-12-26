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
	

	public boolean isEmailExisting(String email)
	{
		out.println("check" + separator + email);

		String resp = getResponse2();
		System.out.println("F resp::" + resp + "otrzy: " + email);
		if(resp.equals(email))
			return true;
		else
			return false;
	}

	public void executeUserProfileUpdate(AppUser appUser)
	{
		
		out.println("execute"+ separator + appUser.getUserID()
							 + separator + appUser.getName()
							 + separator + appUser.getSecondName()
							 + separator + appUser.getAddress()
							 + separator + appUser.getPhoneNumber() );
	}
	
	public void executeUserInsert(AppUser appUser)
	{
		out.println("createUser"
	     +  separator + appUser.getName()
		 + separator + appUser.getSecondName()
		 + separator + appUser.getAddress()
		 + separator + appUser.getPhoneNumber()
		 + separator + appUser.getEmail()
		 + separator + appUser.getPassword()
		);
	}
	
	
	public String login(String email, String password, String string)
	{
		out.println("valid" + separator + email + separator +password + separator+ string);
		String resp = getResponse();
		
		return resp;
		
	}
	
	
	private String getResponse2()
	{
		String resp="";																								
		String tmp="";

			while (!tmp.equals("__END__"))
			{
				System.out.println("wszedlem");
				try {
					
					tmp = in.readLine();
					System.out.println("ODCZYTUJE ...: " + tmp);
					if(!tmp.equals("__END__"))
					resp += tmp;
					else
					{
						System.out.println("ODCZYTANO : " + resp);
						System.out.println("koniec :" + tmp);
						break;
					}
					} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		return resp;
	}
	
	private String getResponse()
	{
		String resp="";																								
		String tmp="";
		while (!tmp.equals("__END__"))
		{
			System.out.println("wszedlem");
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
