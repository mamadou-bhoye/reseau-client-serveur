package SERVEURGameModel;

import java.util.ArrayList;
import java.util.List;

import SERVEURGestionClient.HandleClient;
import SERVEURallAboutGame.Game;

//ANUAIRE	 -> COMMUN  A TOUS

//RECOI UNE ACTION D UN JOUEUR ET LE PARTAGE A TOUT LE MONDE (clientList)
//Appelés à chaque action du client


public class GameModel {
	
	private static final List<GameModelEvents> clientList = new ArrayList<>();

//les méthodes suivantes qui touchent à la liste doivent être synchronised
	
	
	public static synchronized boolean registerUser(HandleClient client) {
		clientList.add(client);
		return true;
	}
	
	
	public static synchronized void demandeofOneClientToGoUp(String gameEvents) {
		for(GameModelEvents gm : clientList) {
			gm.unitWentUp(gameEvents);
		}
	}
	
	
	public static synchronized void demandeofOneClientToGoDown(String gameEvents) {
		for(GameModelEvents gm : clientList) {
			gm.unitWentDown(gameEvents);
		}		
	}
	
	
	public static synchronized void demandeofOneClientToGoLeft(String gameEvents) {
		for(GameModelEvents gm : clientList) {
			gm.unitWentLeft(gameEvents);
		}
	}
	
	
	public static synchronized void demandeofOneClientToGoRight(String gameEvents) {
		for(GameModelEvents gm : clientList) {
			gm.unitWentRight(gameEvents);
		}
	}
	
	
	public static synchronized void demandeofOneClientToPutBomb(String gameEvents) {
		for(GameModelEvents gm : clientList) {
			gm.unitBombPut(gameEvents);
		}
	}
	
	
	/*
	public static synchronized void demandeofOneClientToRemoveBomb(Game game) {
		for(GameModelEvents gm : clientList) {
			gm.unitBombRemoved(game);
		}
	}
	*/
	
	public static void clearAll() {
		
	}



}
