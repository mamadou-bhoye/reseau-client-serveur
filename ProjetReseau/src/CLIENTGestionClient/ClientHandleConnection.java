package CLIENTGestionClient;

import java.io.IOException;
import java.net.Socket;

import CLIENTInOut.GameProtocol;
import CLIENTInOut.Input;
import CLIENTInOut.Output;
import CLIENTallAboutGame.Game;
import CLIENTgui.Gui;

public class ClientHandleConnection extends Thread implements GameProtocol{

	private final Socket s;
	private Input chi;
	private Output cho;
	Game game;
	Gui clientGui;
	
	public ClientHandleConnection(Socket s) {
		// TODO Auto-generated constructor stub
		
		this.s = s;
			
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try (Socket s1 = s) {
			chi = new Input(s1.getInputStream(), this);
			cho = new Output(s1.getOutputStream());
			game = new Game();
			clientGui = new Gui(cho,game);
			chi.doRun();
		} catch (IOException ex) {
				finish();
			
		}
		
	}
	
	
	
	
	
//REPONSE VENANT DU SERVEUR -> chi --------------------------------------------------------------//	
	
	
	public void sendGoUp() {
		//no implement -> for server
	}
	
	public void sendOkUp(String gameEvents) {
		clientGui.convertStringToGameEventAndAddToList(gameEvents);
		
	}
	
	public void sendGoDown() {
		//no implement -> for server
	}
	
	public void sendOkDown(String gameEvents) {
		System.out.println("TEST TRAITEMENT CLIENT STEP 3");
		clientGui.convertStringToGameEventAndAddToList(gameEvents);
		
	}
	
	public void sendGoLeft() {
		//no implement -> for server
	}
	
	public void sendOkLeft(String gameEvents) {
		clientGui.convertStringToGameEventAndAddToList(gameEvents);
		
	}
	
	public void sendGoRight() {
		//no implement -> for server
	}
	
	public void sendOkRight(String gameEvents) {
		clientGui.convertStringToGameEventAndAddToList(gameEvents);
		
	}
	
	public void sendBombPut() {
		//no implement -> for server
	}
	
	public void sendOkBombPut(String gameEvents) {
		clientGui.convertStringToGameEventAndAddToList(gameEvents);
		
	}
	
	/*
	public void sendBombRemoved() {
		GameModel.demandeofOneClientToRemoveBomb();
		journal.serverOkRemoveBomb();
	}
	
	
	public void sendOkBombRemoved() {
		 
	}
	*/
	
	
	//FINISH	
			public synchronized void finish(){
				try {
					s.close();
				} catch (IOException ex) { ex.printStackTrace(); }
			//		if (name != null)
			//			ChatModel.unregisterUser(name);
			//			logger.clientDisconnected(s.toString(), name);
				}
			
			

	public Output getOutput() {
		return this.cho;
	}

}

