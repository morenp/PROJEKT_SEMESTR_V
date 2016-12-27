
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;




public class Server {

	//private String host = "127.0.0.1";
	private String host = "192.168.43.242";
	
    private int port = 5001;
    private InetSocketAddress isa ;
	private ServerSocket serverSocket; 
	private boolean serverIsRunning; // flaga dzia�ania servera
	private Socket conn; // gniazdo 

	
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
			// Zwi�zanie gniazda serwera z adresem hostu i portu 
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
			// akceptacja po��czenia
			// utworzenie gniazda komunikacji z po��czonym klientem 
			try 
			{
				// oczekiwanie na zgloszenie sie klienta
				conn = serverSocket.accept();
				
				// tworzymy w�tek dla danego po��czenia i uruchamiamy go 
				(new ServerTCPThread(conn)).start();
			} 
			catch(SocketException e)
			{
				System.out.println("Roz��czono z serwerem");
			} catch (IOException e) {
				System.out.println("Zako�czono po��czenie z serwerem");
				
			}finally{
				if(serverSocket != null && serverIsRunning == false)
					try {
						serverSocket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}

		}	
		if(!serverIsRunning)
		{
			System.out.println("Sewer zako�czy� prac�!");
		}
	}

}