package SERVEURTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

import SERVEURGameModel.GameModel;
import SERVEURGestionClient.HandleClient;
import SERVEURJournal.IntGameJournal;
import SERVEURJournal.TextGameJournal;
import SERVEURallAboutGame.Game;
import SERVEURallAboutGame.GameEvents;

//Gestion du ServerSocket et Gestion du shutdown…
//Noyau

public class ServerCore extends Thread {

//INITIALISATION	
	private int port;
	ServerSocket ss;
	private boolean stop = false;
	private IntGameJournal logger=null;
	private Game game;
	
	public ServerCore(int port) throws IOException {
		this.port = port;
		logger = new TextGameJournal();
		logger.systemMessage("Server started...");
		game = new Game();
		game.addUnitEvents(GameEvents.GameStart);
		this.start();
	}

//GESTION DU SERVERSOCKET	
	public void run() {
		try (ServerSocket ss = new ServerSocket(port)) {
			ss.setSoTimeout(1000);
			while (!stop) {
				try {
					Socket s = ss.accept();
					System.out.println("Connexion établie avec un client");
					new Thread(new HandleClient(s, logger,game)).start();
				}catch (SocketTimeoutException ex) {
				
				}
			}
		} catch (IOException e) {
			System.out.println("Could not bind port " + port);
			Logger.getLogger(ServerCore.class.getName()).log(Level.SEVERE,null, e);
		}
	}
	
//TERMINAISON	
	public synchronized void finish() {
		GameModel.clearAll();
		stop = true;
		}
	
}
