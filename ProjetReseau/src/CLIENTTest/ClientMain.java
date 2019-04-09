package CLIENTTest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import CLIENTGestionClient.ClientHandleConnection;
import CLIENTInOut.Input;
import CLIENTInOut.Output;
import CLIENTgui.Gui;

public class ClientMain  {
	
	public static void main(String[] args) throws IOException {
		
		int port = args.length==1? Integer.parseInt(args[0]): 1227;
		
		
		System.out.println("Client launch...");
		new ClientCore(port);
	
	
	}
		
		
		
	
	
}
