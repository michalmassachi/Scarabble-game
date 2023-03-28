package test;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;


public class MyServer {
	int port;
	ClientHandler ch;
	private ServerSocket server;
	Boolean stop;
	Socket aClient;

	public MyServer(int port, ClientHandler ch) {
		this.port=port;
		this.ch=ch;
	}
	
	
	public void start(){
		stop= false;
		new Thread(()->startServer()).start(); 
	}
		
	
	
	
	public void startServer()
	{
		try {
			server=new ServerSocket(port);
			server.setSoTimeout(1000);	
			while(!stop){	
				try{
					aClient=server.accept(); 
					ch.handleClient(aClient.getInputStream(), aClient.getOutputStream());	
					//aClient.getInputStream().close();
					//aClient.getOutputStream().close();
					ch.close();
					aClient.close();
				} catch (SocketTimeoutException e) {}
			}
			server.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}

		

	
	public void close()
	{
		stop=true;
		
		/*try {
			aClient.getInputStream().close();
			aClient.getOutputStream().close();
			aClient.close();
			server.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("safe exit");

		}*/
		
	}
	
	
	
		
	
	
}
