package CLIENTgui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.lang.annotation.ElementType;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import CLIENTallAboutGame.*;

public class GamePanel extends JPanel{
	
	private Game game;
	private JFrame frame;
	private int pixSize;
	
	
	private GameDisplay gameDisplayAction;
	
	public GamePanel(JFrame frame, Game game, int pixSize) {
		super();
		this.frame = frame;
		this.game = game;
		this.pixSize = pixSize;
		
		this.gameDisplayAction = GameDisplay.Display;
		
	}
	
	
	public void paintComponent(Graphics g) {
		
		switch (gameDisplayAction) {
		case Display:
			displayGame(g);
			break;
		case Win:
			winDisplay(g);
			break;
		case Lose:
			loseDisplay(g);
			break;
		}

	}
	
	

	
	
	public void displayGame(Graphics g) {
			
		//TERRAIN
		for (NonTraversable e : game.getNonTraversableElements()) {
			
			if(e.getType() == TerrainElementType.WallV3) {
				g.setColor(Color.BLUE);
			} else if(e.getType() == TerrainElementType.WallV2) {
				g.setColor(Color.GREEN);
			} else if(e.getType() == TerrainElementType.WallV1) {
				g.setColor(Color.PINK);
			}else if(e.getType() == TerrainElementType.BorderWall) {
				g.setColor(Color.DARK_GRAY);
			}
			
			
			Coordinate c = e.getCoord();
				int x = c.getX();
				int y = c.getY();
			g.fillRect(x*this.pixSize, y*this.pixSize, this.pixSize, this.pixSize);
				
		}
		
		for (Traversable e : game.getTraversableElements()) {
			g.setColor(Color.CYAN);
			Coordinate c = e.getCoord();
			int x = c.getX();
			int y = c.getY();
			g.fillRect(x*this.pixSize, y*this.pixSize, this.pixSize, this.pixSize);
			
		}
		
		//UNIT
		g.setColor(Color.RED);
		Coordinate c = game.getUnitPosition().getCoord();
		int x = c.getX();
		int y = c.getY();
		g.fillRect(x*this.pixSize, y*this.pixSize, this.pixSize, this.pixSize);
		
		
		//BOMB
		g.setColor(Color.ORANGE);
		if(game.getUnit().getBomb() != null) {
			Coordinate cb = game.getUnit().getBomb().getBombPosition().getCoord();
			int e = cb.getX();
			int f = cb.getY();
			g.fillOval(e*this.pixSize, f*this.pixSize, this.pixSize, this.pixSize);
	
		}
		/*
		for(Bomb b : game.getUnit().getListBomb()) {
			Coordinate cb = b.getBombPosition().getCoord();
			int e = cb.getX();
			int f = cb.getY();
			g.fillOval(e*this.pixSize, f*this.pixSize, this.pixSize, this.pixSize);
		}
		*/
		
		
		
		
	}
	
	public void displayGame () {
		repaint();
	}
	
	
	public void winDisplay(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(10, 10, 450, 450);
		
		
	}
	
	
	public void loseDisplay(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(10, 10, 450, 450);
		
	}
	
	
	public void setGameDisplay(GameDisplay gameDisplayAction) {
		this.gameDisplayAction = gameDisplayAction;
	}
}
