package CLIENTTest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import CLIENTGestionClient.ClientHandleConnection;
import CLIENTallAboutGame.Game;
import CLIENTgui.Gui;

public class ClientCore extends Thread {
	
	private int port;
	public static Socket socket;
	public static ClientHandleConnection client;
	
	
	public ClientCore(int port) {
		this.port = port;
		this.start();
	}
	
	
	public void run() {
		try {
			
			System.out.println("Demande de connexion");
			socket = new Socket(InetAddress.getLocalHost(),port);
			System.out.println("Connexion établie avec un serveur");
			
			new Thread(new ClientHandleConnection(socket)).start();
			
			//new Thread(client = new ClientHandleConnection(socket, new Gui(client.getOutput(),new Game()))).start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			
			System.err.println("Impossible de se connecter ");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Aucun serveur à l écoute ");
			e.printStackTrace();
		}
		

	}
	
	
			

}
