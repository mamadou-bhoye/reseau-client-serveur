package SERVEURInOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

//INPUT DU SERVEUR 
public class Input {
	
	GameProtocol handler;
	InputStream in;
	
	
	public boolean stop = false;
	
	public Input(InputStream in, GameProtocol handler) throws IOException {
		this.in = in;
		this.handler = handler;
	}
	
	
	public void doRun() throws IOException {
		
		try (BufferedReader is = new BufferedReader(new InputStreamReader(in))) {
			while (!stop) {
				String line = is.readLine();
				
				if(line == null) {
					throw new IOException();
				}
				
				switch (line) {
				
					
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
					/*
					case "BOMB REMOVED":
						handler.sendBombRemoved();
					break;
					*/
					
					/*
					
					
					// CE QUE LE CLIENT RECOIT (input du client)
					case "UP OK":
						handler.sendOkUp();
					break;
					
					case "DOWN OK":
						handler.sendOkDown();
					break;
					
					
					case "LEFT OK":
						handler.sendOkLeft();
					break;
					
					
					case "RIGHT OK":
						handler.sendOkRight();
					break;
					
					
					case "BOMB PUT OK":
						handler.sendOkBombPut();
					break;
					
					case "BOMB REMOVED OK":
						handler.sendOkBombRemoved();
					break;
					
					*/
					default:
					throw new GameProtocolException("Invalid input");
				}
			}
		
		
		}

	}
	

}
