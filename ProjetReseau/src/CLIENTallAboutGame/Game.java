package CLIENTallAboutGame;

import java.util.ArrayList;
import java.util.List;


public class Game{

	private Terrain terrain;
	private Unit unit;
	private boolean running;
	
	private List<GameObserver> observers;
	List<GameEvents> gameEvents;
	
	
	private int tickGame;
	
	
	public Game() {
		this.terrain = new Terrain(this);
		this.unit = new Unit(this,terrain);
		running = false;
		
		observers = new ArrayList<>();
		gameEvents = new ArrayList<>();	
		
		tickGame = 1;
		
	}
	
	/*
	
	public void game() {
		long timer1 = System.currentTimeMillis();
		long timer2;
		long timergittest;
		
		
		while(running) {
			
			if(tickGame == 6) {
				tickGame = 1;
			}
				
			if(unit.getHealth() <= 0) {
				running = false;
			}
			
			if(running) {
				notifyObserver(gameEvents);
			}else {
				gameEvents.add(GameEvents.UnitDied);
				notifyObserver(gameEvents);
			}
							
			
			
			
			//tickGame each 2 seconds -> for bomb time
			if(( timer2 = System.currentTimeMillis() )- timer1 >= 2000) { 
				System.out.println(tickGame + " tick");
				tickGame++;
				timer1 = timer2;
			}
			
			
			
			if(unit.getBomb() != null) {
			
					if(tickGame == 1) {
						if(unit.getBomb().getbombTimePut() == 2) {
							unit.removeBomb();
							
						}
						
						
						
					}else if(tickGame == 2) {
						
						if(unit.getBomb().getbombTimePut() == 3) {
							unit.removeBomb();
						}
						
						
						
						
					}else if(tickGame == 3) {
						
						if(unit.getBomb().getbombTimePut() == 4) {
							unit.removeBomb();
						}
						
						
						
						
					}else if(tickGame == 4) {
						
						if(unit.getBomb().getbombTimePut() == 5) {
							unit.removeBomb();
						}
						
						
						
					}else if(tickGame == 5) {
					
						if(unit.getBomb().getbombTimePut() == 1) {
							unit.removeBomb();
						}
					}
					
			}
			
		}	
			
			
	}
	
	
	
	
	public void start() {
		this.running = true;
		gameEvents.add(GameEvents.GameStart);
		game();
	}
	
	
	*/
	
	//About terrain
	public int getMapSize() {
		return terrain.getMapSize();
	}
	
	public List<NonTraversable> getNonTraversableElements(){
		return terrain.getNonTraversableElements();
	}
	
	public List<Traversable> getTraversableElements(){
		return terrain.getTraversableElements();
	}
	
	public Terrain getTerrain() {
		return this.terrain;
	}
	
	public void addTerrainEvents(GameEvents e) {
		gameEvents.add(e);
		notifyObserver(gameEvents);
	}
	
	
	//About unit
	public Unit getUnit() {
		return this.unit;
	}
	
	public Traversable getUnitPosition() {
		return unit.getPosition();
	}
	
	public boolean setUnitPosition(Unit unit,Coordinate newCoordPosition) {
		return terrain.setUnitPosition(unit,newCoordPosition);
		
	}
	
	public boolean putUnitBomb(Unit unit, Coordinate bombCood) {
		return terrain.putUnitBomb(unit,bombCood);
	}

	public List<GameEvents> getUnitEvents(){
		return this.gameEvents;
	}
	
	public void addUnitEvents(GameEvents e) {
		gameEvents.add(e); //add at the end of list
		notifyObserver(gameEvents);
	}
	
	
	
	
	//About observers
	public void register(GameObserver o) {
		observers.add(o);
	}

	public void unregister(GameObserver o) {
		observers.remove(o);
	}

	
	void notifyObserver(List<GameEvents> events) {
		for (GameObserver gameObserver : observers) {
			gameObserver.notify(events);
		}
	}
	
	
	//TickeGame
		public int getTickGame() {
			return this.tickGame;
		}

	
	
	

}
