package SERVEURallAboutGame;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




public class Terrain {

	private Game game;
	private int mapSize;
	private List<Traversable> traversableElements;
	private List<NonTraversable> nonTraversableElemnts;
	

	

	public Terrain(Game game) {
		this.game = game;
		this.mapSize = 30;
		traversableElements = new ArrayList<>();
		nonTraversableElemnts = new ArrayList<>();
		
		
		createDefaultLevel();
	}
	
	


	public void swappWallV(NonTraversable murAModifier) {
		
		
		if(murAModifier.getType() == TerrainElementType.BorderWall) {

			nonTraversableElemnts.remove(murAModifier);
			WallV3 newWallV3 = new WallV3(murAModifier.getCoord(), this);
			nonTraversableElemnts.add(newWallV3);

		}else if(murAModifier.getType() == TerrainElementType.WallV3) {

			nonTraversableElemnts.remove(murAModifier);
			WallV2 newWallV2 = new WallV2(murAModifier.getCoord(), this);
			nonTraversableElemnts.add(newWallV2);
			
		}else if (murAModifier.getType() == TerrainElementType.WallV2) {
			
			nonTraversableElemnts.remove(murAModifier);
			WallV1 newWallV1 = new WallV1(murAModifier.getCoord(), this);
			nonTraversableElemnts.add(newWallV1);
			
			
		}else if (murAModifier.getType() == TerrainElementType.WallV1) {
			
			nonTraversableElemnts.remove(murAModifier);
			Empty newEmpty = new Empty(murAModifier.getCoord(), this);
			traversableElements.add(newEmpty);
			
		}
		
		
	}

	
	
	public int getMapSize() {
		return mapSize;
	}

	
	
	public List<NonTraversable> getNonTraversableElements() {
		return new ArrayList<NonTraversable>(nonTraversableElemnts);
	}

	
	
	public List<Traversable> getTraversableElements() {
		return new ArrayList<Traversable>(traversableElements);
	}
	

	public boolean setUnitPosition(Unit unit,Coordinate coordinate) {
		//Test-----------//
		Coordinate deadCoord = new Coordinate(2,8);
		if(coordinate.compare(deadCoord) == 0) {
			unit.setHealth(0);
		}
		//---------------//
		for (Traversable t : traversableElements) {
			if (t.getCoord().compare(coordinate) == 0) {
					unit.setPosition(t);
					return true;
			}
		}
		return false;
		

	}
	
	public boolean putUnitBomb(Unit unit, Coordinate bombCoord) {
		//Put bomb on right
		int x = bombCoord.getX()+1;
		int y = bombCoord.getY();
		Coordinate rightBombCoord = new Coordinate(x,y);
		for (Traversable t : traversableElements) {
			if (t.getCoord().compare(rightBombCoord) == 0) {
					Bomb unitBomb = new Bomb(t);
					/*
					//Now
					long bombTimePut = System.nanoTime();
					System.out.println(bombTimePut);
					//After 4 seconds
					long bombTimeRemoved = bombTimePut + (unitBomb.getbombLife()*1000000000);
					System.out.println(bombTimeRemoved);
					unitBomb.setBombPut(bombTimePut);
					*/
					unit.addBomb(unitBomb);
					return true;
			}
		}
		return false;
		
	}
	
	

	
	
	
	
	void createDefaultLevel() {
		Traversable[][] t = new Traversable[this.mapSize+1][this.mapSize+1];
		NonTraversable[][] nt = new NonTraversable[this.mapSize+1][this.mapSize+1];
		
		
			for(int x = 5; x<=27; x=x+3 ) {
				nt[3][x] = new WallV3(new Coordinate(x,3),this);
			}
		
			for(int x = 5; x<=27; x=x+3 ) {
				nt[6][x] = new WallV3(new Coordinate(x,6),this);
			}
		
		
			for(int x = 5; x<=27; x=x+3) {
				nt[9][x] = new WallV2(new Coordinate(x,9),this);
				
			}
			
		
			for(int x = 5; x<=27; x=x+3) {
				nt[12][x] = new WallV2(new Coordinate(x,12),this);
				
			}
		
			for(int x = 5; x<=27; x=x+3 ) {
				nt[15][x] = new WallV3(new Coordinate(x,15),this);
			}
			
			for(int x = 5; x<=27; x=x+3 ) {
				nt[18][x] = new WallV3(new Coordinate(x,18),this);
			}
		
		
			
			for(int x = 5; x<=27; x=x+3) {
				nt[21][x] = new WallV1(new Coordinate(x,21),this);
			}
			
			for(int x = 5; x<=27; x=x+3) {
				nt[24][x] = new WallV1(new Coordinate(x,24),this);
			}
			
			for(int x = 5; x<=27; x=x+3) {
				nt[27][x] = new WallV2(new Coordinate(x,27),this);
			}
			
			//BORDER WALL
			//haut
			for(int x = 1; x<=this.mapSize;x++) {
				nt[1][x] = new BorderWall(new Coordinate(x,1),this);
			}
			//bas
			for(int x = 1; x<=this.mapSize;x++) {
				nt[this.mapSize][x] = new BorderWall(new Coordinate(x,this.mapSize),this);
			}
			//gauche
			for(int x = 1; x<=this.mapSize;x++) {
				nt[x][1] = new BorderWall(new Coordinate(1,x),this);
			}
			//droite
			for(int x = 1; x<=this.mapSize;x++) {
				nt[x][this.mapSize] = new BorderWall(new Coordinate(this.mapSize,x),this);
			}
		
		
		
		
		//Mettre le reste a Empty
		for (int y = 1; y <= this.mapSize; y++) {
			for (int x = 1; x <= this.mapSize; x++) {
				if (nt[y][x] == null)
					t[y][x] = new Empty(new Coordinate(x, y), this);
			}
		}
		
		
		//Ajout à la liste (nos champs)
		for (int y = 1; y <= this.mapSize; y++) {
			for (int x = 1; x <= this.mapSize; x++) {
				if (t[y][x] != null)
					traversableElements.add(t[y][x]);
				if (nt[y][x] != null)
					nonTraversableElemnts.add(nt[y][x]);
			}
		}

		
		
		
		

		
		
		

	}

}
