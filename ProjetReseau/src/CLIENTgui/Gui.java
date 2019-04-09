package CLIENTgui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import CLIENTInOut.Output;
import CLIENTallAboutGame.Coordinate;
import CLIENTallAboutGame.Game;
import CLIENTallAboutGame.GameEvents;

public class Gui {
	
	private Game game;
	private JFrame frame;
	
	List<GameEvents> gameEventsForGui;
	private Output cho;
	private GamePanel gamePanel;
	
	
	public Gui( Output cho, Game game) {
		this.game = game;
		gameEventsForGui = new ArrayList<>();
		this.cho = cho;
		
		frame = new JFrame("Bomberman");
		gamePanel = new GamePanel(frame,game , 15);
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setSize( (game.getMapSize()+4)*15, (game.getMapSize()+4)*15 );
		frame.add(gamePanel);
		frame.setVisible(true);
		
		
		
		//Unit Move
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				int x = 0;
				int y = 0;
				Coordinate newCoord;

				switch (key) {
				case KeyEvent.VK_UP:
					cho.sendGoUp();
					break;
				case KeyEvent.VK_DOWN:
					cho.sendGoDown();
					break;
				case KeyEvent.VK_RIGHT:
					cho.sendGoRight();
					break;
				case KeyEvent.VK_LEFT:
					cho.sendGoLeft();
					break;
				case KeyEvent.VK_N:
					cho.sendBombPut();
					break;
				default:
					System.out.println("Other key typed");
					break;
			

			
				}
			}
		});
		frame.pack();
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.toFront();
		frame.requestFocus();


	}

//------------------------------------------------------------------------------------------//	
//LE PLUS IMPORTANT !!!!!! CHANGE L'INTERFACE DU CLIENT
	public void notifyGui(List<GameEvents> events) {
		int x = 0;
		int y = 0;
		Coordinate newCoord;

		// TODO Auto-generated method stub
		if(events.get(events.size()-1) == GameEvents.UnitGoUp) {
			x = game.getUnitPosition().getCoord().getX();
			y = game.getUnitPosition().getCoord().getY();
			newCoord = new Coordinate(x,y-1);
			game.setUnitPosition(game.getUnit(),newCoord);
			
			this.displayGame();
		
		} else if(events.get(events.size()-1) == GameEvents.UnitGoDown) {

			x = game.getUnitPosition().getCoord().getX();
			y = game.getUnitPosition().getCoord().getY();
			newCoord = new Coordinate(x,y+1);
			game.setUnitPosition(game.getUnit(),newCoord);
			
			this.displayGame();
		
		} else if(events.get(events.size()-1) == GameEvents.UnitGoLeft) {

			x = game.getUnitPosition().getCoord().getX();
			y = game.getUnitPosition().getCoord().getY();
			newCoord = new Coordinate(x-1,y);
			game.setUnitPosition(game.getUnit(),newCoord);
			
			this.displayGame();
		
		} else if(events.get(events.size()-1) == GameEvents.UnitGoRight) {

			x = game.getUnitPosition().getCoord().getX();
			y = game.getUnitPosition().getCoord().getY();
			newCoord = new Coordinate(x+1,y);
			game.setUnitPosition(game.getUnit(),newCoord);
			
			this.displayGame();
		
		} else if(events.get(events.size()-1) == GameEvents.UnitPutBomb) {

			game.putUnitBomb(game.getUnit(), game.getUnit().getPosition().getCoord());
			
			this.displayGame();
		
		} else if(events.get(events.size()-1) == GameEvents.UnitTouchedByBomb) {

			this.displayGame();
			
			
			
		} else if(events.get(events.size()-1) == GameEvents.TerrainChangeToEmpty) {
			//this.displayGame();
		} else if(events.get(events.size()-1) == GameEvents.TerrainChangeToWallV1) {
			//this.displayGame();
		} else if(events.get(events.size()-1) == GameEvents.TerrainChangeToWallV2) {
			//this.displayGame();
		
	
	
			
	    //GAME STOP
		} else if(events.get(events.size()-1) == GameEvents.UnitDied) {
			//this.displayLost();
		
	
		
		}
									
	}
	
	
	
	
	public void displayGame() {
		gamePanel.displayGame();
	}
	
	public void displayWin() {
		gamePanel.setGameDisplay(GameDisplay.Win);
		gamePanel.displayGame();
	}

	public void displayLost() {
		gamePanel.setGameDisplay(GameDisplay.Lose);
		gamePanel.displayGame();
	}
	
	
	
	public void convertStringToGameEventAndAddToList(String inputClient) {
		String s1 = "UnitGoUp";
		String s2 = "UnitGoDown";
		String s3 = "UnitGoLeft";
		String s4 = "UnitGoRight";
		String s5 = "UnitPutBomb";
		
		if(inputClient.equals(s1)) {
			 
			addToGuiList(GameEvents.UnitGoUp);
			notifyGui(gameEventsForGui);
		
		}else if(inputClient.equals(s2)) {
			
			System.out.println("CLIENT TRAITEMENT TEST 4 "); 
			addToGuiList(GameEvents.UnitGoDown);
			notifyGui(gameEventsForGui);
			
		}else if(inputClient.equals(s3)) {
			 
			addToGuiList(GameEvents.UnitGoLeft);
			notifyGui(gameEventsForGui);
			
		}else if(inputClient.equals(s4)) {
			 
			addToGuiList(GameEvents.UnitGoRight);
			notifyGui(gameEventsForGui);
			
		}else if(inputClient.equals(s5)) {
			 
			addToGuiList(GameEvents.UnitPutBomb);
			notifyGui(gameEventsForGui);
			
		}
	}
	
	
	
	public void addToGuiList(GameEvents gameEvents) {
		gameEventsForGui.add(gameEvents);
	}
	
	public List<GameEvents> getGuiList(){
		return this.gameEventsForGui;
	}


	
	public void paintComponent(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(10, 10, 450, 450);
		
		
	}

}
