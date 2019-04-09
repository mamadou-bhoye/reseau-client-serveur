package SERVEURJournal;

public class TextGameJournal implements IntGameJournal{

	@Override
	public void clientGoUp() {
		// TODO Auto-generated method stub
		System.out.println("CLIENT WENT UP");
		
	}

	@Override
	public void clientGoDown() {
		// TODO Auto-generated method stub
		System.out.println("CLIENT WENT DOWN");
		
	}

	@Override
	public void clientGoLeft() {
		// TODO Auto-generated method stub
		System.out.println("CLIENT WENT LEFT");
		
	}

	@Override
	public void clientGoRight() {
		// TODO Auto-generated method stub
		System.out.println("CLIENT WENT RIGHT");
		
	}

	@Override
	public void clientPutBomb() {
		// TODO Auto-generated method stub
		System.out.println("CLIENT PUT BOMB");
		
	}

	/*
	@Override
	public void clientRemoveBomb() {
		// TODO Auto-generated method stub
		System.out.println("CLIENT REMOVED BOMB");
		
	}
	*/
	
	
	
	@Override
	public void serverOkUp() {
		// TODO Auto-generated method stub
		System.out.println("DEMANDE UP DU CLIENT RECU PAR LE SERVEUR");
				
	}
	
	@Override
	public void serverOkDown() {
		// TODO Auto-generated method stub
		System.out.println("DEMANDE DOWN DU CLIENT RECU PAR LE SERVEUR");
				
	}
	
	@Override
	public void serverOkLeft() {
		// TODO Auto-generated method stub
		System.out.println("DEMANDE LEFT DU CLIENT RECU PAR LE SERVEUR");
				
	}
	
	@Override
	public void serverOkRight() {
		// TODO Auto-generated method stub
		System.out.println("DEMANDE RIGHT DU CLIENT RECU PAR LE SERVEUR");
				
	}
	
	@Override
	public void serverOkPutBomb() {
		// TODO Auto-generated method stub
		System.out.println("DEMANDE PUT BOMB DU CLIENT RECU PAR LE SERVEUR");
				
	}
	
	/*
	@Override
	public void serverOkRemoveBomb(){
		// TODO Auto-generated method stub
		System.out.println("DEMANDE REMOVED BOMB DU CLIENT RECU PAR LE SERVEUR");
				
	}
	*/
	
	@Override
	public void systemMessage(String msg) {
		System.out.println("MSG : "+msg);

	}

	

}
