package CLIENTInOut;
 
//DECRIT DANS LE PROTCOLE WORD
//QUESTION ET REPONSE ENTRE CLIENT ET SERVEUR

public interface GameProtocol {
	
	// SERVEUR
	
	default void sendOkUp(String gameEvents) {};
	
	default void sendOkDown(String gameEvents) {};
	
	default void sendOkLeft(String gameEvents) {};
	
	default void sendOkRight(String gameEvents) {};
	
	default void sendOkBombPut(String gameEvents) {};
	
	
	//default void sendOkBombRemoved(Game game) {};


	//CLIENT
	
	default void sendGoUp() {};
	
	default void sendGoDown() {};
	
	default void sendGoLeft() {};
	
	default void sendGoRight() {};
	
	default void sendBombPut() {};
	
	//default void sendBombRemoved() {};
	
	
	
	
	
	
}
