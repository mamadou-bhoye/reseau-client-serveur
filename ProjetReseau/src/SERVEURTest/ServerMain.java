package SERVEURTest;

import java.io.IOException;


public class ServerMain {
	
	
	public static void main(String[] args) {
		int port = args.length==1? Integer.parseInt(args[0]): 1227;
		
		try{
			System.out.println("Attente d'un client");
			new ServerCore(port);
		}catch(IOException e){
			System.out.println("Error during initialisation:"+e.toString());
		}
	
	
	}
	

}
