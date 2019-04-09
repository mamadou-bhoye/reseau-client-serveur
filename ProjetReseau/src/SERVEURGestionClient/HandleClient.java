package SERVEURGestionClient;

import java.io.IOException;
import java.net.Socket;

import SERVEURGameModel.GameModel;
import SERVEURGameModel.GameModelEvents;
import SERVEURInOut.GameProtocol;
import SERVEURInOut.Input;
import SERVEURInOut.Output;
import SERVEURJournal.IntGameJournal;
import SERVEURallAboutGame.Coordinate;
import SERVEURallAboutGame.Game;
import SERVEURallAboutGame.GameEvents;

//GESTION DE CHAQUE CLIENT DANS LE SERVEURRRRRRRRRRRRRRRRRRRRR 
//UN JOUEUR = UN THREAD = UN HANDLECLIENT 


//envoi vers GameModel avec le "GameProtocol"      et      recoi de GameModel avec le "GameModelEvents"
//cho : serveur vers client

//NORMALEMENT le jeu a une instance de HANDLECLIENT


public class HandleClient  implements Runnable, GameProtocol, GameModelEvents{

	
	//INTIALISATION	
		private Game game;
		private final Socket s;
		private Output cho;
		private Input chi;
		private IntGameJournal journal = null;
		private boolean stop = false;

		public HandleClient(Socket s, IntGameJournal journal, Game game) throws IOException {
			this.s = s;
			this.journal = journal;
			this.game = game;
		}
	

//Implémentation RUNNABLE	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		registerMe();
		try (Socket s1 = s) {
			cho = new Output(s1.getOutputStream());
			chi = new Input(s1.getInputStream(), this);
			chi.doRun();
		} catch (IOException ex) {
			if (!stop) {
				finish();
			}
		}
		
	}


	
	
//DEMANDE DU CLIENT -> chi --------------------------------------------------------------//	

//Implémentation GAMEPROTOCOL -> envoi vers GameModel
	
	public void registerMe() {
		GameModel.registerUser(this);
	}
	
	public void sendGoUp() {
		int x = game.getUnitPosition().getCoord().getX();
		int y = game.getUnitPosition().getCoord().getY();
		Coordinate newCoord = new Coordinate(x,y-1);
		game.setUnitPosition(game.getUnit(),newCoord);
		
		GameEvents lastGameEvent = game.getUnitEvents().get(game.getUnitEvents().size()-1);
		String gameEvent = ""+lastGameEvent;
		GameModel.demandeofOneClientToGoUp(gameEvent);
		journal.serverOkUp();
	}
	
	public void sendOkUp() {
		//no implement -> for client
	}
	
	public void sendGoDown() {
		int x = game.getUnitPosition().getCoord().getX();
		int y = game.getUnitPosition().getCoord().getY();
		Coordinate newCoord = new Coordinate(x,y+1);
		game.setUnitPosition(game.getUnit(),newCoord);
		
		GameEvents lastGameEvent = game.getUnitEvents().get(game.getUnitEvents().size()-1);
		String gameEvent = ""+lastGameEvent;
		GameModel.demandeofOneClientToGoDown(gameEvent);
		journal.serverOkDown();
	}
	
	public void sendOkDown() {
		//no implement -> for client
	}
	
	public void sendGoLeft() {
		int x = game.getUnitPosition().getCoord().getX();
		int y = game.getUnitPosition().getCoord().getY();
		Coordinate newCoord = new Coordinate(x-1,y);
		game.setUnitPosition(game.getUnit(),newCoord);
		
		GameEvents lastGameEvent = game.getUnitEvents().get(game.getUnitEvents().size()-1);
		String gameEvent = ""+lastGameEvent;
		GameModel.demandeofOneClientToGoLeft(gameEvent);
		journal.serverOkLeft();
	}
	
	public void sendOkLeft() {
		//no implement -> for client	
	}
	
	public void sendGoRight() {
		int x = game.getUnitPosition().getCoord().getX();
		int y = game.getUnitPosition().getCoord().getY();
		Coordinate newCoord = new Coordinate(x+1,y);
		game.setUnitPosition(game.getUnit(),newCoord);
		
		GameEvents lastGameEvent = game.getUnitEvents().get(game.getUnitEvents().size()-1);
		String gameEvent = ""+lastGameEvent;
		GameModel.demandeofOneClientToGoRight(gameEvent);
		journal.serverOkRight();
	}
	
	public void sendOkRight() {
		//no implement -> for client
	}
	
	public void sendBombPut() {
		game.putUnitBomb(game.getUnit(), game.getUnit().getPosition().getCoord());
		
		GameEvents lastGameEvent = game.getUnitEvents().get(game.getUnitEvents().size()-1);
		String gameEvent = ""+lastGameEvent;
		GameModel.demandeofOneClientToPutBomb(gameEvent);
		journal.serverOkPutBomb();
	}
	
	public void sendOkBombPut() {
		//no implement -> for client
	}
	
	/*
	public void sendBombRemoved() {
		GameModel.demandeofOneClientToRemoveBomb();
		journal.serverOkRemoveBomb();
	}
	*/
	
	public void sendOkBombRemoved() {
		//no implement -> for client
	}
	
	
//DEMANDE DU CLIENT -> chi --------------------------------------------------------------//	

	
	
	
	
	
	
	
	
	
	

	
	
	
//REPONSE DU SERVEUR VERS LE CLIENT -> cho --------------------------------------------//	
	
//Implémentation GAMEMODELEVENTS -> 	
	@Override
	public void unitWentUp(String gameEvents) {
		cho.sendOkUp(gameEvents);
	}

	@Override
	public void unitWentDown(String gameEvents) {
		cho.sendOkDown(gameEvents);
		System.out.println("TEST SORTI SERVEUR STEP 1");
	}

	@Override
	public void unitWentLeft(String gameEvents) {
		cho.sendOkLeft(gameEvents);
	}

	@Override
	public void unitWentRight(String gameEvents) {
		cho.sendOkRight(gameEvents);
	}

	@Override
	public void unitBombPut(String gameEvents) {
		cho.sendOkBombPut(gameEvents);
	}
	
/*
	@Override
	public void unitBombRemoved(Game game) {
		cho.sendBombRemoved();
	}
*/	
	
	

	//FINISH	
		public synchronized void finish(){
			if (!stop) {
				stop = true;
			try {
				s.close();
			} catch (IOException ex) { ex.printStackTrace(); }
		//		if (name != null)
		//			ChatModel.unregisterUser(name);
		//			logger.clientDisconnected(s.toString(), name);
			}
		}

		
//REPONDE DU SERVEUR VERS LE CLIENT -> cho --------------------------------------------//	
				
		
		public Game getGame() {
			return game;
		}


		
}



























