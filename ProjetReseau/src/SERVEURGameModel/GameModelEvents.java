package SERVEURGameModel;

import SERVEURallAboutGame.Game;

//ce que le serveur enverra à tout le monde (Handelclient partie 2)

public interface GameModelEvents {
	
	public void unitWentUp(String gameEvents);
	
	public void unitWentDown(String gameEvents);
	
	public void unitWentLeft(String gameEvents);
	
	public void unitWentRight(String gameEvents);
	
	public void unitBombPut(String gameEvents);
	
	//public void unitBombRemoved(Game game);
	
}
