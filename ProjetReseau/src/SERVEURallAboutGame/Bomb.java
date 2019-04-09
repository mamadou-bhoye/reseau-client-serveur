package SERVEURallAboutGame;

import java.util.ArrayList;
import java.util.List;



public class Bomb {
	private Traversable bombPosition;
	private int bombTimePut;
	private int bombLife;
	private int bombScope;
	
	
	
	public Bomb(Traversable bombPosition) {
		this.bombPosition = bombPosition;
		this.bombTimePut = 0;
		this.bombLife = 4; // 4 seconds
		this.bombScope = 2; //By default -> Horizontal et vertical
		
		
	}

	public int getbombTimePut() {
		return this.bombTimePut;
	}
	
	
	public void setBombPut(int bombTimePut) {
		this.bombTimePut = bombTimePut;
	}

	

	public Traversable getBombPosition() {
		return bombPosition;
	}
	
	public int getbombLife() {
		return this.bombLife;
	}
	
	
	
	
	
	
}
