package SERVEURJournal;


//VERIFICATION DU FONCTIONNEMENT DU SERVEUR
//on peut implementer toute les action du client et du serveur
public interface IntGameJournal {
	
	
	public void clientGoUp();
	
	public void clientGoDown();
	
	public void clientGoLeft();
	
	public void clientGoRight();
	
	public void clientPutBomb();
	
	//public void clientRemoveBomb();
	
	
	
	public void serverOkUp();
	
	public void serverOkDown();
	
	public void serverOkLeft();
	
	public void serverOkRight();
	
	public void serverOkPutBomb();
	
	//public void serverOkRemoveBomb();
	
	
	public void systemMessage(String msg);
	
	

}
