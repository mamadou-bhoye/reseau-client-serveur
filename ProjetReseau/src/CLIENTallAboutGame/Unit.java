 package CLIENTallAboutGame;

import java.util.ArrayList;
import java.util.List;

public class Unit {
	private Traversable position;
	private int health;
	private Bomb bomb;
	
	private Game game;
	private Terrain terrain;
	
	
	
	
	public Unit(Game game,Terrain terrain) {
		this.game = game;
		this.terrain = terrain;
		this.bomb = null;
		
		health = 10; //By default
		this.position = new Empty(new Coordinate(2,2),terrain); //By default
		
		
	}
	
	

	public Traversable getPosition() {
		return position;
	}


	public void setPosition(TerrainElement position) {
		
					//Events of moving
					if(((position.getCoord().getX()+1) == (this.position.getCoord().getX()))  &&  ((position.getCoord().getY()) == (this.position.getCoord().getY()))) {
						game.addUnitEvents(GameEvents.UnitGoLeft);
						
					
					} else if(((position.getCoord().getX()-1) == (this.position.getCoord().getX()))  &&  ((position.getCoord().getY()) == (this.position.getCoord().getY())) ) {
						game.addUnitEvents(GameEvents.UnitGoRight);
						
					
					} else if(((position.getCoord().getY()-1) == (this.position.getCoord().getY()))  &&  ((position.getCoord().getX()) == (this.position.getCoord().getX())) ) {
						game.addUnitEvents(GameEvents.UnitGoDown);
						
					
					} else if(((position.getCoord().getY()+1) == (this.position.getCoord().getY()))  &&  ((position.getCoord().getX()) == (this.position.getCoord().getX())) ) {
						game.addUnitEvents(GameEvents.UnitGoUp);
						
					}
					this.position = (Traversable) position;
					
					
		
		
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}
	
	
//BOMB	
	
	public void addBomb(Bomb bomb) {
		this.bomb = bomb;
		bomb.setBombPut(game.getTickGame());
		game.addUnitEvents(GameEvents.UnitPutBomb);
	}
	
	public Bomb getBomb() {
		return this.bomb;
	}

	
	public void removeBomb() {
		Coordinate cb = this.getBomb().getBombPosition().getCoord();
		List<Coordinate> listeVoisinDetruit = new ArrayList<>();
		int xcb = cb.getX();
		int ycb = cb.getY();
		
		Coordinate c1 = new Coordinate((xcb-1),(ycb-1));
		Coordinate c2 = new Coordinate(xcb,(ycb-1));
		Coordinate c3 = new Coordinate((xcb+1),(ycb-1));
		Coordinate c4 = new Coordinate((xcb-1),ycb);
		Coordinate c5 = new Coordinate((xcb+1),ycb);
		Coordinate c6 = new Coordinate((xcb-1),(ycb+1));
		Coordinate c7 = new Coordinate(xcb,(ycb+1));
		Coordinate c8 = new Coordinate((xcb+1),(ycb+1));
		
		listeVoisinDetruit.add(c1);
		listeVoisinDetruit.add(c2);
		listeVoisinDetruit.add(c3);
		listeVoisinDetruit.add(c4);
		listeVoisinDetruit.add(c5);
		listeVoisinDetruit.add(c6);
		listeVoisinDetruit.add(c7);
		listeVoisinDetruit.add(c8);
		
		
		for(NonTraversable nt : terrain.getNonTraversableElements()) {
			Coordinate ntcoord = nt.getCoord();
			for(Coordinate c : listeVoisinDetruit) {
				if(ntcoord.compare(c) == 0) {
					terrain.swappWallV(nt);
				}
			}
		}
		
		game.addUnitEvents(GameEvents.UnitRemoveBomb);
		this.bomb = null;

	}
	

}
