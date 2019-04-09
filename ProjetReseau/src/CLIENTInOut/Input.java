package CLIENTInOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import CLIENTgui.Gui;

//INPUT DU CLIENT 
public class Input {
	
	GameProtocol handler;
	InputStream in;
	
	
	public boolean stop = false;
	
	public Input(InputStream in/*, Gui clientGui*/, GameProtocol handler) throws IOException {
		this.in = in;
		//this.clientGui = clientGui;
		this.handler = handler;
	}
	
	
	public void doRun() throws IOException {
		String gameEventSendByServer;
		
		try (BufferedReader is = new BufferedReader(new InputStreamReader(in))) {
			while (!stop) {
				String line = is.readLine();
				
				if(line == null) {
					throw new IOException();
				}
				
				switch (line) {
				
					/*	
				
					// CE QUE LE SERVEUR RECOIT (input du serveur)
					case "UP":
						handler.sendGoUp();
					break;
					
					
					case "DOWN":
						handler.sendGoDown();
					break;
					
					case "LEFT":
						handler.sendGoLeft();
					break;
					
					case "RIGHT":
						handler.sendGoRight();
					break;
					
					case "BOMB PUT":
						handler.sendBombPut();
					break;
					
					case "BOMB REMOVED":
						handler.sendBombRemoved();
					break;
					
					*/
					
					
					
					// CE QUE LE CLIENT RECOIT (input du client)
					case "UP OK":
						gameEventSendByServer = is.readLine();
						handler.sendOkUp(gameEventSendByServer);
						
					break;
					
					case "DOWN OK":
						gameEventSendByServer = is.readLine();
						System.out.println("TEST ENTREE CLIENT STEP 2");
						handler.sendOkDown(gameEventSendByServer);
						
					break;
					
					
					case "LEFT OK":
						gameEventSendByServer = is.readLine();
						handler.sendOkLeft(gameEventSendByServer);
					break;
					
					
					case "RIGHT OK":
						gameEventSendByServer = is.readLine();
						handler.sendOkRight(gameEventSendByServer);
						
					break;
					
					
					case "BOMB PUT OK":
						gameEventSendByServer = is.readLine();
						handler.sendOkBombPut(gameEventSendByServer);
						
					break;
					/*
					case "BOMB REMOVED OK":
						//handler.sendOkBombRemoved();
					break;
					
					*/
					default:
					throw new GameProtocolException("Invalid input");
				}
			}
		
		
		}

	}
	

}
