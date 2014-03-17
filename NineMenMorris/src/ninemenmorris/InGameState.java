package ninemenmorris;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;


import gamestate.GameState;
import gamestate.GameStateManager;

import utility.Background;

/**
 * Holds information about everytihng in the game :
 * pieces, rows, ...
 * and draws everything
 * @author User
 *
 */
public class InGameState extends GameState {
	
	private Background bg = new Background("res/boards/unnamed.png",600,400);
	private int currentPlayer = 0;
	private Board grid = new Board();
	private TurnState[] players = new TurnState[2];
	

	public InGameState(GameStateManager gm) {
		
		super(gm);
		


	}

	/**
	 * draw everything on the screen in the game
	 */
	public void draw(Graphics2D g) {

		bg.draw(g);
		players[0].draw(g);
		players[1].draw(g);

	}

	/**
	 * update things such as piece positions,
	 * checking for three in a row ...
	 */
	public void update() {
		
		if(players[currentPlayer].isFinished())
			currentPlayer = (currentPlayer + 1) % 2;
	}
	
	// what to do if key is pressed, or mouse is clicked

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClick(int x, int y) {

		players[currentPlayer].mouseClick(x, y);

	}

	
	public void mouseReleased(int x, int y, int b) {
		
		if(players[currentPlayer].toTake()) {
			int i = players[(currentPlayer + 1) % 2].pos(x, y);
			if (i >= 0) {
				players[(currentPlayer + 1) % 2].removePiece(i);
				Board.removePiece(i);
				players[currentPlayer].took();
				players[currentPlayer].isFinished();

			}
		}
		
		else	
			players[currentPlayer].mouseReleased(x, y, b);
		
	}

	@Override
	public void mousePressed(int x, int y, int b) {
			
		players[currentPlayer].mousePressed(x, y, b);
		
	}

	@Override
	public void init() {
		
		players[0] = new TurnState(gm, Color.WHITE, 20);
		players[1] = new TurnState(gm, Color.BLACK, 350);
		
	}

}
