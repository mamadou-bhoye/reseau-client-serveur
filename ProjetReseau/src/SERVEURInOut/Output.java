package SERVEURInOut;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import SERVEURallAboutGame.Game;

//OUTPUT DU SERVEUR 
public class Output implements GameProtocol {
	
	PrintWriter os;
	
	public Output(OutputStream out) throws IOException {
		this.os = new PrintWriter(out, true);
	}
	
	
	
	// CE QUE LE SERVEUR ENVOI (output du serveur)
	
	@Override
	public void sendOkUp(String gameEvents) {
		os.println("UP OK");
		os.println(gameEvents);
	}
	
	
	@Override
	public void sendOkDown(String gameEvents) {
		os.println("DOWN OK");
		os.println(gameEvents);
	}
	
	
	@Override
	public void sendOkLeft(String gameEvents) {
		os.println("LEFT OK");
		os.println(gameEvents);
	}
	
	
	@Override
	public void sendOkRight(String gameEvents) {
		os.println("RIGHT OK");
		os.println(gameEvents);
	}
	
	
	@Override
	public void sendOkBombPut(String gameEvents) {
		os.println("BOMB PUT OK");
		os.println(gameEvents);
	}
	
	/*
	@Override
	public void sendOkBombRemoved(Game game) {
		os.println("BOMB REMOVED OK");
	}
	*/
	/*
	
	// CE QUE LE CLIENT ENVOI (output du client)
	
		@Override
		public void sendGoUp() {
			os.println("UP");
		}
		
		@Override
		public void sendGoDown() {
			os.println("DOWN");
		}
		
		@Override
		public void sendGoLeft() {
			os.println("LEFT");
		}
		
		@Override
		public void sendGoRight() {
			os.println("RIGHT");
		}
		
		@Override
		public void sendBombPut() {
			os.println("BOMB PUT");
		}
		
		@Override
		public void sendBombRemoved() {
			os.println("BOMB REMOVED");
		}
		
		
		
		*/

}
