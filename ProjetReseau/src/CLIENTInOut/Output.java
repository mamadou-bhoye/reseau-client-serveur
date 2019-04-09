package CLIENTInOut;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;


//OUTPUT DU CLIENT 
public class Output implements GameProtocol {
	
	PrintWriter os;
	
	public Output(OutputStream out) throws IOException {
		this.os = new PrintWriter(out, true);
	}
	
/*	
	
	// CE QUE LE SERVEUR ENVOI (output du serveur)
	
	@Override
	public void sendOkUp(Game game) {
		os.println("UP OK");
		os.println(game);
	}
	
	
	@Override
	public void sendOkDown(Game game) {
		os.println("DOWN OK");
	}
	
	
	@Override
	public void sendOkLeft(Game game) {
		os.println("LEFT OK");
	}
	
	
	@Override
	public void sendOkRight(Game game) {
		os.println("RIGHT OK");
	}
	
	
	@Override
	public void sendOkBombPut(Game game) {
		os.println("BOMB PUT OK");
	}
	
	
	@Override
	public void sendOkBombRemoved(Game game) {
		os.println("BOMB REMOVED OK");
	}
	
	

*/	
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
		
		/*
		@Override
		public void sendBombRemoved() {
			os.println("BOMB REMOVED");
		}
		
		*/
		
		

}
